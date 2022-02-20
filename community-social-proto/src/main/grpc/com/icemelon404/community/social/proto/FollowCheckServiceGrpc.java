package com.icemelon404.community.social.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: FollowCheckService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FollowCheckServiceGrpc {

  private FollowCheckServiceGrpc() {}

  public static final String SERVICE_NAME = "FollowCheckService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.FollowInfo,
      com.icemelon404.community.social.proto.FollowStatus> getCheckFollowMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkFollow",
      requestType = com.icemelon404.community.social.proto.FollowInfo.class,
      responseType = com.icemelon404.community.social.proto.FollowStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.FollowInfo,
      com.icemelon404.community.social.proto.FollowStatus> getCheckFollowMethod() {
    io.grpc.MethodDescriptor<com.icemelon404.community.social.proto.FollowInfo, com.icemelon404.community.social.proto.FollowStatus> getCheckFollowMethod;
    if ((getCheckFollowMethod = FollowCheckServiceGrpc.getCheckFollowMethod) == null) {
      synchronized (FollowCheckServiceGrpc.class) {
        if ((getCheckFollowMethod = FollowCheckServiceGrpc.getCheckFollowMethod) == null) {
          FollowCheckServiceGrpc.getCheckFollowMethod = getCheckFollowMethod =
              io.grpc.MethodDescriptor.<com.icemelon404.community.social.proto.FollowInfo, com.icemelon404.community.social.proto.FollowStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "checkFollow"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.social.proto.FollowInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.icemelon404.community.social.proto.FollowStatus.getDefaultInstance()))
              .setSchemaDescriptor(new FollowCheckServiceMethodDescriptorSupplier("checkFollow"))
              .build();
        }
      }
    }
    return getCheckFollowMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FollowCheckServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowCheckServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowCheckServiceStub>() {
        @java.lang.Override
        public FollowCheckServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowCheckServiceStub(channel, callOptions);
        }
      };
    return FollowCheckServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FollowCheckServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowCheckServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowCheckServiceBlockingStub>() {
        @java.lang.Override
        public FollowCheckServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowCheckServiceBlockingStub(channel, callOptions);
        }
      };
    return FollowCheckServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FollowCheckServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FollowCheckServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FollowCheckServiceFutureStub>() {
        @java.lang.Override
        public FollowCheckServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FollowCheckServiceFutureStub(channel, callOptions);
        }
      };
    return FollowCheckServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FollowCheckServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkFollow(com.icemelon404.community.social.proto.FollowInfo request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.FollowStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckFollowMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckFollowMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.icemelon404.community.social.proto.FollowInfo,
                com.icemelon404.community.social.proto.FollowStatus>(
                  this, METHODID_CHECK_FOLLOW)))
          .build();
    }
  }

  /**
   */
  public static final class FollowCheckServiceStub extends io.grpc.stub.AbstractAsyncStub<FollowCheckServiceStub> {
    private FollowCheckServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowCheckServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowCheckServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkFollow(com.icemelon404.community.social.proto.FollowInfo request,
        io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.FollowStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckFollowMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FollowCheckServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FollowCheckServiceBlockingStub> {
    private FollowCheckServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowCheckServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowCheckServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.icemelon404.community.social.proto.FollowStatus checkFollow(com.icemelon404.community.social.proto.FollowInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckFollowMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FollowCheckServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FollowCheckServiceFutureStub> {
    private FollowCheckServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FollowCheckServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FollowCheckServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.icemelon404.community.social.proto.FollowStatus> checkFollow(
        com.icemelon404.community.social.proto.FollowInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckFollowMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_FOLLOW = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FollowCheckServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FollowCheckServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_FOLLOW:
          serviceImpl.checkFollow((com.icemelon404.community.social.proto.FollowInfo) request,
              (io.grpc.stub.StreamObserver<com.icemelon404.community.social.proto.FollowStatus>) responseObserver);
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

  private static abstract class FollowCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FollowCheckServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.icemelon404.community.social.proto.FollowCheckServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FollowCheckService");
    }
  }

  private static final class FollowCheckServiceFileDescriptorSupplier
      extends FollowCheckServiceBaseDescriptorSupplier {
    FollowCheckServiceFileDescriptorSupplier() {}
  }

  private static final class FollowCheckServiceMethodDescriptorSupplier
      extends FollowCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FollowCheckServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FollowCheckServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FollowCheckServiceFileDescriptorSupplier())
              .addMethod(getCheckFollowMethod())
              .build();
        }
      }
    }
    return result;
  }
}
