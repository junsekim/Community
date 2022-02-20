package com.icemelon404.community.dispatcher.infra;

import com.icemelon404.community.dispatcher.domain.paging.FollowerCountFetcher;
import com.icemelon404.community.social.proto.FollowCount;
import com.icemelon404.community.social.proto.FollowCountServiceGrpc;
import com.icemelon404.community.social.proto.User;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GrpcFollowerCountFetcher implements FollowerCountFetcher {

    private final FollowCountServiceGrpc.FollowCountServiceStub stub;

    @Override
    public Mono<Integer> fetchFollowerCount(long followee) {
       Mono<FollowCount> mono =  Mono.create(sink -> stub.fetchCount(User.newBuilder().setUserId(followee).build(), new MonoStreamObserver<>(sink)));
       return mono.map(FollowCount::getFollowerCount);
    }
}
