package com.icemelon404.community.dispatcher.infra;

import com.icemelon404.community.commons.exception.NoSuchResourceException;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.MonoSink;

import java.util.Optional;

@RequiredArgsConstructor
public class MonoStreamObserver<T> implements StreamObserver<T> {

    private final MonoSink<T> sink;

    @Override
    public void onNext(T value) {
        sink.success(value);
    }

    @Override
    public void onError(Throwable t) {
        sink.error(t);
    }

    @Override
    public void onCompleted() {
    }
}
