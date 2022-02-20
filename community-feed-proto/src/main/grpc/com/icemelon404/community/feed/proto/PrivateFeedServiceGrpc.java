package com.icemelon404.community.feed.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: FeedServiceProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PrivateFeedServiceGrpc {

  private PrivateFeedServiceGrpc() {}

  public static final String SERVICE_NAME = "PrivateFeedService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.icemelon404.community.feed.proto.FeedRequest,
      com.icemelon404.community.feed.proto.FeedResponse> getGetFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFeed",
      requestType = com.icemelon404.community.feed.proto.FeedRequest.class,
      responseType = com.icemelon404.community.feed.proto.FeedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.icemelon404.community.feed.proto.FeedRequest,
      com.icemelon404.community.feed.proto.FeedResponse> getGetFeedMethod() {
    io.grpc.MethodDescriptor<com.icemelon404.community.feed.proto.FeedRequest, com.icemelon404.community.feed.proto.FeedResponse> getGetFeedMethod;
    if ((getGetFeedMethod = PrivateFeedServiceGrpc.getGetFeedMethod) == null) {
      synchronized (PrivateFeedServiceGrpc.class) {
        if ((getGetFeedMethod = PrivateFeedServiceGrpc.getGetFeedMethod) == null) {
          PrivateFeedServiceGrpc.getGetFeedMethod = getGetFeedMethod =
              io.grpc.MethodDescriptor.<com.icemelon404.community.feed.proto.FeedRequest, com.icemelon404.community.feed.proto.FeedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getFeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.FeedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.FeedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PrivateFeedServiceMethodDescriptorSupplier("getFeed"))
              .build();
        }
      }
    }
    return getGetFeedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.icemelon404.community.feed.proto.FeedPushRequest,
      com.icemelon404.community.feed.proto.PushResult> getPushFeedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "pushFeed",
      requestType = com.icemelon404.community.feed.proto.FeedPushRequest.class,
      responseType = com.icemelon404.community.feed.proto.PushResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.icemelon404.community.feed.proto.FeedPushRequest,
      com.icemelon404.community.feed.proto.PushResult> getPushFeedMethod() {
    io.grpc.MethodDescriptor<com.icemelon404.community.feed.proto.FeedPushRequest, com.icemelon404.community.feed.proto.PushResult> getPushFeedMethod;
    if ((getPushFeedMethod = PrivateFeedServiceGrpc.getPushFeedMethod) == null) {
      synchronized (PrivateFeedServiceGrpc.class) {
        if ((getPushFeedMethod = PrivateFeedServiceGrpc.getPushFeedMethod) == null) {
          PrivateFeedServiceGrpc.getPushFeedMethod = getPushFeedMethod =
              io.grpc.MethodDescriptor.<com.icemelon404.community.feed.proto.FeedPushRequest, com.icemelon404.community.feed.proto.PushResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "pushFeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.FeedPushRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.PushResult.getDefaultInstance()))
              .setSchemaDescriptor(new PrivateFeedServiceMethodDescriptorSupplier("pushFeed"))
              .build();
        }
      }
    }
    return getPushFeedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrivateFeedServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivateFeedServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrivateFeedServiceStub>() {
        @java.lang.Override
        public PrivateFeedServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrivateFeedServiceStub(channel, callOptions);
        }
      };
    return PrivateFeedServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrivateFeedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivateFeedServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrivateFeedServiceBlockingStub>() {
        @java.lang.Override
        public PrivateFeedServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrivateFeedServiceBlockingStub(channel, callOptions);
        }
      };
    return PrivateFeedServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrivateFeedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrivateFeedServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrivateFeedServiceFutureStub>() {
        @java.lang.Override
        public PrivateFeedServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrivateFeedServiceFutureStub(channel, callOptions);
        }
      };
    return PrivateFeedServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PrivateFeedServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getFeed(com.icemelon404.community.feed.proto.FeedRequest request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.feed.proto.FeedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeedMethod(), responseObserver);
    }

    /**
     */
    public void pushFeed(com.icemelon404.community.feed.proto.FeedPushRequest request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.feed.proto.PushResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPushFeedMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.icemelon404.community.feed.proto.FeedRequest,
                com.icemelon404.community.feed.proto.FeedResponse>(
                  this, METHODID_GET_FEED)))
          .addMethod(
            getPushFeedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.icemelon404.community.feed.proto.FeedPushRequest,
                com.icemelon404.community.feed.proto.PushResult>(
                  this, METHODID_PUSH_FEED)))
          .build();
    }
  }

  /**
   */
  public static final class PrivateFeedServiceStub extends io.grpc.stub.AbstractAsyncStub<PrivateFeedServiceStub> {
    private PrivateFeedServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivateFeedServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivateFeedServiceStub(channel, callOptions);
    }

    /**
     */
    public void getFeed(com.icemelon404.community.feed.proto.FeedRequest request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.feed.proto.FeedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void pushFeed(com.icemelon404.community.feed.proto.FeedPushRequest request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.feed.proto.PushResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPushFeedMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PrivateFeedServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PrivateFeedServiceBlockingStub> {
    private PrivateFeedServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivateFeedServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivateFeedServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.icemelon404.community.feed.proto.FeedResponse getFeed(com.icemelon404.community.feed.proto.FeedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeedMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.icemelon404.community.feed.proto.PushResult pushFeed(com.icemelon404.community.feed.proto.FeedPushRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPushFeedMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PrivateFeedServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PrivateFeedServiceFutureStub> {
    private PrivateFeedServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrivateFeedServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrivateFeedServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.icemelon404.community.feed.proto.FeedResponse> getFeed(
        com.icemelon404.community.feed.proto.FeedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeedMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.icemelon404.community.feed.proto.PushResult> pushFeed(
        com.icemelon404.community.feed.proto.FeedPushRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPushFeedMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_FEED = 0;
  private static final int METHODID_PUSH_FEED = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PrivateFeedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PrivateFeedServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_FEED:
          serviceImpl.getFeed((com.icemelon404.community.feed.proto.FeedRequest) request,
              (io.grpc.stub.StreamObserver<com.icemelon404.community.feed.proto.FeedResponse>) responseObserver);
          break;
        case METHODID_PUSH_FEED:
          serviceImpl.pushFeed((com.icemelon404.community.feed.proto.FeedPushRequest) request,
              (io.grpc.stub.StreamObserver<com.icemelon404.community.feed.proto.PushResult>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PrivateFeedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrivateFeedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.icemelon404.community.feed.proto.FeedServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrivateFeedService");
    }
  }

  private static final class PrivateFeedServiceFileDescriptorSupplier
      extends PrivateFeedServiceBaseDescriptorSupplier {
    PrivateFeedServiceFileDescriptorSupplier() {}
  }

  private static final class PrivateFeedServiceMethodDescriptorSupplier
      extends PrivateFeedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PrivateFeedServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrivateFeedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrivateFeedServiceFileDescriptorSupplier())
              .addMethod(getGetFeedMethod())
              .addMethod(getPushFeedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
