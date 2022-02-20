package com.icemelon404.community.grpc.common;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import lombok.RequiredArgsConstructor;

import java.net.URI;

@RequiredArgsConstructor
public class DiscoveryClientNameResolverProvider extends NameResolverProvider {

    private final EurekaClient client;

    @Override
    protected boolean isAvailable() {
        return true;
    }

    @Override
    protected int priority() {
        return 5;
    }

    @Override
    public String getDefaultScheme() {
        return "discover";
    }

    @Override
    public NameResolver newNameResolver(URI targetUri, NameResolver.Args args) {
        return new DiscoveryClientNameResolver(client, targetUri.getHost());
    }
}
