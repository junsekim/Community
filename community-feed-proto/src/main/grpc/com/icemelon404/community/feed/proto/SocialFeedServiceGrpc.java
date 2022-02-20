package com.icemelon404.community.feed.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: FeedServiceProto.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SocialFeedServiceGrpc {

  private SocialFeedServiceGrpc() {}

  public static final String SERVICE_NAME = "SocialFeedService";

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
    if ((getGetFeedMethod = SocialFeedServiceGrpc.getGetFeedMethod) == null) {
      synchronized (SocialFeedServiceGrpc.class) {
        if ((getGetFeedMethod = SocialFeedServiceGrpc.getGetFeedMethod) == null) {
          SocialFeedServiceGrpc.getGetFeedMethod = getGetFeedMethod =
              io.grpc.MethodDescriptor.<com.icemelon404.community.feed.proto.FeedRequest, com.icemelon404.community.feed.proto.FeedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getFeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.FeedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.FeedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SocialFeedServiceMethodDescriptorSupplier("getFeed"))
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
    if ((getPushFeedMethod = SocialFeedServiceGrpc.getPushFeedMethod) == null) {
      synchronized (SocialFeedServiceGrpc.class) {
        if ((getPushFeedMethod = SocialFeedServiceGrpc.getPushFeedMethod) == null) {
          SocialFeedServiceGrpc.getPushFeedMethod = getPushFeedMethod =
              io.grpc.MethodDescriptor.<com.icemelon404.community.feed.proto.FeedPushRequest, com.icemelon404.community.feed.proto.PushResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "pushFeed"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.FeedPushRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.feed.proto.PushResult.getDefaultInstance()))
              .setSchemaDescriptor(new SocialFeedServiceMethodDescriptorSupplier("pushFeed"))
              .build();
        }
      }
    }
    return getPushFeedMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SocialFeedServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SocialFeedServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SocialFeedServiceStub>() {
        @java.lang.Override
        public SocialFeedServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SocialFeedServiceStub(channel, callOptions);
        }
      };
    return SocialFeedServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SocialFeedServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SocialFeedServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SocialFeedServiceBlockingStub>() {
        @java.lang.Override
        public SocialFeedServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SocialFeedServiceBlockingStub(channel, callOptions);
        }
      };
    return SocialFeedServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SocialFeedServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SocialFeedServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SocialFeedServiceFutureStub>() {
        @java.lang.Override
        public SocialFeedServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SocialFeedServiceFutureStub(channel, callOptions);
        }
      };
    return SocialFeedServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SocialFeedServiceImplBase implements io.grpc.BindableService {

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
  public static final class SocialFeedServiceStub extends io.grpc.stub.AbstractAsyncStub<SocialFeedServiceStub> {
    private SocialFeedServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SocialFeedServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SocialFeedServiceStub(channel, callOptions);
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
  public static final class SocialFeedServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SocialFeedServiceBlockingStub> {
    private SocialFeedServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SocialFeedServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SocialFeedServiceBlockingStub(channel, callOptions);
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
  public static final class SocialFeedServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SocialFeedServiceFutureStub> {
    private SocialFeedServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SocialFeedServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SocialFeedServiceFutureStub(channel, callOptions);
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
    private final SocialFeedServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SocialFeedServiceImplBase serviceImpl, int methodId) {
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

  private static abstract class SocialFeedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SocialFeedServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.icemelon404.community.feed.proto.FeedServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SocialFeedService");
    }
  }

  private static final class SocialFeedServiceFileDescriptorSupplier
      extends SocialFeedServiceBaseDescriptorSupplier {
    SocialFeedServiceFileDescriptorSupplier() {}
  }

  private static final class SocialFeedServiceMethodDescriptorSupplier
      extends SocialFeedServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SocialFeedServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SocialFeedServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SocialFeedServiceFileDescriptorSupplier())
              .addMethod(getGetFeedMethod())
              .addMethod(getPushFeedMethod())
              .build();
        }
      }
    }
    return result;
  }
}
