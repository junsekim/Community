package com.icemelon404.community.grpc.common;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.CacheRefreshedEvent;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.StatusChangeEvent;
import com.netflix.discovery.shared.Application;
import io.grpc.Attributes;
import io.grpc.EquivalentAddressGroup;
import io.grpc.NameResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class DiscoveryClientNameResolver extends NameResolver {

    private final EurekaClient discoveryClient;
    private final String serviceName;

    @Override
    public String getServiceAuthority() {
        return "";
    }

    @Override
    public void shutdown() {
    }

    @Override
    public void start(Listener2 listener) {
        discoverAndRegisterTo(listener);
        discoveryClient.registerEventListener((event) -> {
            if (!(event instanceof CacheRefreshedEvent))
                return;
            discoverAndRegisterTo(listener);
        });
    }

    private void discoverAndRegisterTo(Listener listener) {
        listener.onAddresses(discoverAddressGroups(), Attributes.EMPTY);
    }

    private List<EquivalentAddressGroup> discoverAddressGroups() {
        List<InstanceInfo> instances = discoveryClient.getInstancesByVipAddress(this.serviceName, false);
        if (instances == null)
            return Collections.emptyList();
        return instances
                .stream()
                .map(this::socketAddressOf)
                .map(this::addressGroupOf)
                .peek(it -> log.debug("discovered address: {}", it.getAddresses().get(0).toString()))
                .collect(Collectors.toList());
    }

    private SocketAddress socketAddressOf(InstanceInfo instance) {
        return  new InetSocketAddress(instance.getIPAddr(), instance.getPort());
    }

    private EquivalentAddressGroup addressGroupOf(SocketAddress address) {
        return new EquivalentAddressGroup(Collections.singletonList(address));
    }
}
