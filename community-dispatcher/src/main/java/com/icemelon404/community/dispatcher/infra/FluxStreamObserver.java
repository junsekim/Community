package com.icemelon404.community.dispatcher.infra;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.FluxSink;

@RequiredArgsConstructor
public class FluxStreamObserver<T> implements StreamObserver<T> {

    private final FluxSink<T> sink;

    @Override
    public void onNext(T value) {
        sink.next(value);
    }

    @Override
    public void onError(Throwable t) {
        sink.error(t);
    }

    @Override
    public void onCompleted() {
        sink.complete();
    }
}
