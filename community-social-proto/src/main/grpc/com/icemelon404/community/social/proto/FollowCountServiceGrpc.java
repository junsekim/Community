package com.icemelon404.community.social.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: FollowCountService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FollowCountServiceGrpc {

  private FollowCountServiceGrpc() {}

  public static final String SERVICE_NAME = "FollowCountService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.User,
      com.icemelon404.community.social.proto.FollowCount> getFetchCountMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fetchCount",
      requestType = com.icemelon404.community.social.proto.User.class,
      responseType = com.icemelon404.community.social.proto.FollowCount.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.User,
      com.icemelon404.community.social.proto.FollowCount> getFetchCountMethod() {
    io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.User, com.icemelon404.community.social.proto.FollowCount> getFetchCountMethod;
    if ((getFetchCountMethod = FollowCountServiceGrpc.getFetchCountMethod) == null) {
      synchronized (FollowCountServiceGrpc.class) {
        if ((getFetchCountMethod = FollowCountServiceGrpc.getFetchCountMethod) == null) {
          FollowCountServiceGrpc.getFetchCountMethod = getFetchCountMethod =
              io.grpc.MethodDescriptor.<com.icemelon404.community.social.proto.User, com.icemelon404.community.social.proto.FollowCount>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "fetchCount"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.social.proto.User.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.social.proto.FollowCount.getDefaultInstance()))
              .setSchemaDescriptor(new FollowCountServiceMethodDescriptorSupplier("fetchCount"))
              .build();
        }
      }
    }
    return getFetchCountMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FollowCountServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowCountServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowCountServiceStub>() {
        @java.lang.Override
        public FollowCountServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowCountServiceStub(channel, callOptions);
        }
      };
    return FollowCountServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FollowCountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowCountServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowCountServiceBlockingStub>() {
        @java.lang.Override
        public FollowCountServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowCountServiceBlockingStub(channel, callOptions);
        }
      };
    return FollowCountServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FollowCountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowCountServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowCountServiceFutureStub>() {
        @java.lang.Override
        public FollowCountServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowCountServiceFutureStub(channel, callOptions);
        }
      };
    return FollowCountServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FollowCountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void fetchCount(com.icemelon404.community.social.proto.User request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.FollowCount> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getFetchCountMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFetchCountMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.icemelon404.community.social.proto.User,
                com.icemelon404.community.social.proto.FollowCount>(
                  this, METHODID_FETCH_COUNT)))
          .build();
    }
  }

  /**
   */
  public static final class FollowCountServiceStub extends io.grpc.stub.AbstractAsyncStub<FollowCountServiceStub> {
    private FollowCountServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowCountServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowCountServiceStub(channel, callOptions);
    }

    /**
     */
    public void fetchCount(com.icemelon404.community.social.proto.User request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.FollowCount> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchCountMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FollowCountServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FollowCountServiceBlockingStub> {
    private FollowCountServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowCountServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowCountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.icemelon404.community.social.proto.FollowCount fetchCount(com.icemelon404.community.social.proto.User request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchCountMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FollowCountServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FollowCountServiceFutureStub> {
    private FollowCountServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowCountServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowCountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.icemelon404.community.social.proto.FollowCount> fetchCount(
        com.icemelon404.community.social.proto.User request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchCountMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FETCH_COUNT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FollowCountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FollowCountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FETCH_COUNT:
          serviceImpl.fetchCount((com.icemelon404.community.social.proto.User) request,
              (io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.FollowCount>) responseObserver);
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

  private static abstract class FollowCountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FollowCountServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.icemelon404.community.social.proto.FollowCountServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FollowCountService");
    }
  }

  private static final class FollowCountServiceFileDescriptorSupplier
      extends FollowCountServiceBaseDescriptorSupplier {
    FollowCountServiceFileDescriptorSupplier() {}
  }

  private static final class FollowCountServiceMethodDescriptorSupplier
      extends FollowCountServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FollowCountServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FollowCountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FollowCountServiceFileDescriptorSupplier())
              .addMethod(getFetchCountMethod())
              .build();
        }
      }
    }
    return result;
  }
}
