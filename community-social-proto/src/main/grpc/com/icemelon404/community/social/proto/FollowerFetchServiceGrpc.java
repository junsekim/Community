package com.icemelon404.community.social.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: FollowerFetchService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FollowerFetchServiceGrpc {

  private FollowerFetchServiceGrpc() {}

  public static final String SERVICE_NAME = "FollowerFetchService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.FollowerRequest,
      com.icemelon404.community.social.proto.Follower> getFetchFollowersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchFollowers",
      requestType = com.icemelon404.community.social.proto.FollowerRequest.class,
      responseType = com.icemelon404.community.social.proto.Follower.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.FollowerRequest,
      com.icemelon404.community.social.proto.Follower> getFetchFollowersMethod() {
    io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.FollowerRequest, com.icemelon404.community.social.proto.Follower> getFetchFollowersMethod;
    if ((getFetchFollowersMethod = FollowerFetchServiceGrpc.getFetchFollowersMethod) == null) {
      synchronized (FollowerFetchServiceGrpc.class) {
        if ((getFetchFollowersMethod = FollowerFetchServiceGrpc.getFetchFollowersMethod) == null) {
          FollowerFetchServiceGrpc.getFetchFollowersMethod = getFetchFollowersMethod =
              io.grpc.MethodDescriptor.<com.icemelon404.community.social.proto.FollowerRequest, com.icemelon404.community.social.proto.Follower>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchFollowers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.social.proto.FollowerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.social.proto.Follower.getDefaultInstance()))
              .setSchemaDescriptor(new FollowerFetchServiceMethodDescriptorSupplier("fetchFollowers"))
              .build();
        }
      }
    }
    return getFetchFollowersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FollowerFetchServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowerFetchServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowerFetchServiceStub>() {
        @java.lang.Override
        public FollowerFetchServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowerFetchServiceStub(channel, callOptions);
        }
      };
    return FollowerFetchServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FollowerFetchServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowerFetchServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowerFetchServiceBlockingStub>() {
        @java.lang.Override
        public FollowerFetchServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowerFetchServiceBlockingStub(channel, callOptions);
        }
      };
    return FollowerFetchServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FollowerFetchServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowerFetchServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowerFetchServiceFutureStub>() {
        @java.lang.Override
        public FollowerFetchServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowerFetchServiceFutureStub(channel, callOptions);
        }
      };
    return FollowerFetchServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FollowerFetchServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchFollowers(com.icemelon404.community.social.proto.FollowerRequest request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.Follower> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchFollowersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchFollowersMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.icemelon404.community.social.proto.FollowerRequest,
                com.icemelon404.community.social.proto.Follower>(
                  this, METHODID_FETCH_FOLLOWERS)))
          .build();
    }
  }

  /**
   */
  public static final class FollowerFetchServiceStub extends io.grpc.stub.AbstractAsyncStub<FollowerFetchServiceStub> {
    private FollowerFetchServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowerFetchServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowerFetchServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchFollowers(com.icemelon404.community.social.proto.FollowerRequest request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.Follower> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getFetchFollowersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FollowerFetchServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FollowerFetchServiceBlockingStub> {
    private FollowerFetchServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowerFetchServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowerFetchServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.icemelon404.community.social.proto.Follower> fetchFollowers(
        com.icemelon404.community.social.proto.FollowerRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getFetchFollowersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FollowerFetchServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FollowerFetchServiceFutureStub> {
    private FollowerFetchServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowerFetchServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowerFetchServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_FETCH_FOLLOWERS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FollowerFetchServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FollowerFetchServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_FOLLOWERS:
          serviceImpl.fetchFollowers((com.icemelon404.community.social.proto.FollowerRequest) request,
              (io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.Follower>) responseObserver);
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

  private static abstract class FollowerFetchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FollowerFetchServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.icemelon404.community.social.proto.FollowerFetchServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FollowerFetchService");
    }
  }

  private static final class FollowerFetchServiceFileDescriptorSupplier
      extends FollowerFetchServiceBaseDescriptorSupplier {
    FollowerFetchServiceFileDescriptorSupplier() {}
  }

  private static final class FollowerFetchServiceMethodDescriptorSupplier
      extends FollowerFetchServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FollowerFetchServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FollowerFetchServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FollowerFetchServiceFileDescriptorSupplier())
              .addMethod(getFetchFollowersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
