package generatedClasses;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.59.0)",
    comments = "Source: StaffRpc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StaffServiceGrpc {

  private StaffServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "proto.StaffService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest,
      generatedClasses.StaffResponseOuterClass.StaffResponse> getAddStaffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddStaff",
      requestType = generatedClasses.StaffRequestOuterClass.StaffRequest.class,
      responseType = generatedClasses.StaffResponseOuterClass.StaffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest,
      generatedClasses.StaffResponseOuterClass.StaffResponse> getAddStaffMethod() {
    io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest, generatedClasses.StaffResponseOuterClass.StaffResponse> getAddStaffMethod;
    if ((getAddStaffMethod = StaffServiceGrpc.getAddStaffMethod) == null) {
      synchronized (StaffServiceGrpc.class) {
        if ((getAddStaffMethod = StaffServiceGrpc.getAddStaffMethod) == null) {
          StaffServiceGrpc.getAddStaffMethod = getAddStaffMethod =
              io.grpc.MethodDescriptor.<generatedClasses.StaffRequestOuterClass.StaffRequest, generatedClasses.StaffResponseOuterClass.StaffResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddStaff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffRequestOuterClass.StaffRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffResponseOuterClass.StaffResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StaffServiceMethodDescriptorSupplier("AddStaff"))
              .build();
        }
      }
    }
    return getAddStaffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest1,
      generatedClasses.StaffResponseOuterClass.StaffResponse> getGetStaffInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStaffInfo",
      requestType = generatedClasses.StaffRequestOuterClass.StaffRequest1.class,
      responseType = generatedClasses.StaffResponseOuterClass.StaffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest1,
      generatedClasses.StaffResponseOuterClass.StaffResponse> getGetStaffInfoMethod() {
    io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest1, generatedClasses.StaffResponseOuterClass.StaffResponse> getGetStaffInfoMethod;
    if ((getGetStaffInfoMethod = StaffServiceGrpc.getGetStaffInfoMethod) == null) {
      synchronized (StaffServiceGrpc.class) {
        if ((getGetStaffInfoMethod = StaffServiceGrpc.getGetStaffInfoMethod) == null) {
          StaffServiceGrpc.getGetStaffInfoMethod = getGetStaffInfoMethod =
              io.grpc.MethodDescriptor.<generatedClasses.StaffRequestOuterClass.StaffRequest1, generatedClasses.StaffResponseOuterClass.StaffResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStaffInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffRequestOuterClass.StaffRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffResponseOuterClass.StaffResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StaffServiceMethodDescriptorSupplier("GetStaffInfo"))
              .build();
        }
      }
    }
    return getGetStaffInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generatedClasses.StaffListRequestOuterClass.StaffListRequest,
      generatedClasses.StaffListResponseOuterClass.StaffListResponse> getGetAllStaffInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllStaffInfo",
      requestType = generatedClasses.StaffListRequestOuterClass.StaffListRequest.class,
      responseType = generatedClasses.StaffListResponseOuterClass.StaffListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generatedClasses.StaffListRequestOuterClass.StaffListRequest,
      generatedClasses.StaffListResponseOuterClass.StaffListResponse> getGetAllStaffInfoMethod() {
    io.grpc.MethodDescriptor<generatedClasses.StaffListRequestOuterClass.StaffListRequest, generatedClasses.StaffListResponseOuterClass.StaffListResponse> getGetAllStaffInfoMethod;
    if ((getGetAllStaffInfoMethod = StaffServiceGrpc.getGetAllStaffInfoMethod) == null) {
      synchronized (StaffServiceGrpc.class) {
        if ((getGetAllStaffInfoMethod = StaffServiceGrpc.getGetAllStaffInfoMethod) == null) {
          StaffServiceGrpc.getGetAllStaffInfoMethod = getGetAllStaffInfoMethod =
              io.grpc.MethodDescriptor.<generatedClasses.StaffListRequestOuterClass.StaffListRequest, generatedClasses.StaffListResponseOuterClass.StaffListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllStaffInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffListRequestOuterClass.StaffListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffListResponseOuterClass.StaffListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StaffServiceMethodDescriptorSupplier("GetAllStaffInfo"))
              .build();
        }
      }
    }
    return getGetAllStaffInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest,
      generatedClasses.StaffResponseOuterClass.StaffResponse> getUpdateStaffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStaff",
      requestType = generatedClasses.StaffRequestOuterClass.StaffRequest.class,
      responseType = generatedClasses.StaffResponseOuterClass.StaffResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest,
      generatedClasses.StaffResponseOuterClass.StaffResponse> getUpdateStaffMethod() {
    io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest, generatedClasses.StaffResponseOuterClass.StaffResponse> getUpdateStaffMethod;
    if ((getUpdateStaffMethod = StaffServiceGrpc.getUpdateStaffMethod) == null) {
      synchronized (StaffServiceGrpc.class) {
        if ((getUpdateStaffMethod = StaffServiceGrpc.getUpdateStaffMethod) == null) {
          StaffServiceGrpc.getUpdateStaffMethod = getUpdateStaffMethod =
              io.grpc.MethodDescriptor.<generatedClasses.StaffRequestOuterClass.StaffRequest, generatedClasses.StaffResponseOuterClass.StaffResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStaff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffRequestOuterClass.StaffRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffResponseOuterClass.StaffResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StaffServiceMethodDescriptorSupplier("UpdateStaff"))
              .build();
        }
      }
    }
    return getUpdateStaffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest1,
      generatedClasses.StatusResponseOuterClass.StatusResponse> getRemoveStaffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveStaff",
      requestType = generatedClasses.StaffRequestOuterClass.StaffRequest1.class,
      responseType = generatedClasses.StatusResponseOuterClass.StatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest1,
      generatedClasses.StatusResponseOuterClass.StatusResponse> getRemoveStaffMethod() {
    io.grpc.MethodDescriptor<generatedClasses.StaffRequestOuterClass.StaffRequest1, generatedClasses.StatusResponseOuterClass.StatusResponse> getRemoveStaffMethod;
    if ((getRemoveStaffMethod = StaffServiceGrpc.getRemoveStaffMethod) == null) {
      synchronized (StaffServiceGrpc.class) {
        if ((getRemoveStaffMethod = StaffServiceGrpc.getRemoveStaffMethod) == null) {
          StaffServiceGrpc.getRemoveStaffMethod = getRemoveStaffMethod =
              io.grpc.MethodDescriptor.<generatedClasses.StaffRequestOuterClass.StaffRequest1, generatedClasses.StatusResponseOuterClass.StatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveStaff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StaffRequestOuterClass.StaffRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generatedClasses.StatusResponseOuterClass.StatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StaffServiceMethodDescriptorSupplier("RemoveStaff"))
              .build();
        }
      }
    }
    return getRemoveStaffMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StaffServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StaffServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StaffServiceStub>() {
        @java.lang.Override
        public StaffServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StaffServiceStub(channel, callOptions);
        }
      };
    return StaffServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StaffServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StaffServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StaffServiceBlockingStub>() {
        @java.lang.Override
        public StaffServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StaffServiceBlockingStub(channel, callOptions);
        }
      };
    return StaffServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StaffServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StaffServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StaffServiceFutureStub>() {
        @java.lang.Override
        public StaffServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StaffServiceFutureStub(channel, callOptions);
        }
      };
    return StaffServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addStaff(generatedClasses.StaffRequestOuterClass.StaffRequest request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddStaffMethod(), responseObserver);
    }

    /**
     */
    default void getStaffInfo(generatedClasses.StaffRequestOuterClass.StaffRequest1 request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStaffInfoMethod(), responseObserver);
    }

    /**
     */
    default void getAllStaffInfo(generatedClasses.StaffListRequestOuterClass.StaffListRequest request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffListResponseOuterClass.StaffListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllStaffInfoMethod(), responseObserver);
    }

    /**
     */
    default void updateStaff(generatedClasses.StaffRequestOuterClass.StaffRequest request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateStaffMethod(), responseObserver);
    }

    /**
     */
    default void removeStaff(generatedClasses.StaffRequestOuterClass.StaffRequest1 request,
        io.grpc.stub.StreamObserver<generatedClasses.StatusResponseOuterClass.StatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRemoveStaffMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StaffService.
   */
  public static abstract class StaffServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StaffServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StaffService.
   */
  public static final class StaffServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StaffServiceStub> {
    private StaffServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StaffServiceStub(channel, callOptions);
    }

    /**
     */
    public void addStaff(generatedClasses.StaffRequestOuterClass.StaffRequest request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddStaffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStaffInfo(generatedClasses.StaffRequestOuterClass.StaffRequest1 request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStaffInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllStaffInfo(generatedClasses.StaffListRequestOuterClass.StaffListRequest request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffListResponseOuterClass.StaffListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllStaffInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateStaff(generatedClasses.StaffRequestOuterClass.StaffRequest request,
        io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStaffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeStaff(generatedClasses.StaffRequestOuterClass.StaffRequest1 request,
        io.grpc.stub.StreamObserver<generatedClasses.StatusResponseOuterClass.StatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveStaffMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StaffService.
   */
  public static final class StaffServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StaffServiceBlockingStub> {
    private StaffServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StaffServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public generatedClasses.StaffResponseOuterClass.StaffResponse addStaff(generatedClasses.StaffRequestOuterClass.StaffRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddStaffMethod(), getCallOptions(), request);
    }

    /**
     */
    public generatedClasses.StaffResponseOuterClass.StaffResponse getStaffInfo(generatedClasses.StaffRequestOuterClass.StaffRequest1 request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStaffInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<generatedClasses.StaffListResponseOuterClass.StaffListResponse> getAllStaffInfo(
        generatedClasses.StaffListRequestOuterClass.StaffListRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllStaffInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public generatedClasses.StaffResponseOuterClass.StaffResponse updateStaff(generatedClasses.StaffRequestOuterClass.StaffRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStaffMethod(), getCallOptions(), request);
    }

    /**
     */
    public generatedClasses.StatusResponseOuterClass.StatusResponse removeStaff(generatedClasses.StaffRequestOuterClass.StaffRequest1 request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveStaffMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StaffService.
   */
  public static final class StaffServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StaffServiceFutureStub> {
    private StaffServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StaffServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StaffServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generatedClasses.StaffResponseOuterClass.StaffResponse> addStaff(
        generatedClasses.StaffRequestOuterClass.StaffRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddStaffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generatedClasses.StaffResponseOuterClass.StaffResponse> getStaffInfo(
        generatedClasses.StaffRequestOuterClass.StaffRequest1 request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStaffInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generatedClasses.StaffResponseOuterClass.StaffResponse> updateStaff(
        generatedClasses.StaffRequestOuterClass.StaffRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStaffMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generatedClasses.StatusResponseOuterClass.StatusResponse> removeStaff(
        generatedClasses.StaffRequestOuterClass.StaffRequest1 request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveStaffMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_STAFF = 0;
  private static final int METHODID_GET_STAFF_INFO = 1;
  private static final int METHODID_GET_ALL_STAFF_INFO = 2;
  private static final int METHODID_UPDATE_STAFF = 3;
  private static final int METHODID_REMOVE_STAFF = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_STAFF:
          serviceImpl.addStaff((generatedClasses.StaffRequestOuterClass.StaffRequest) request,
              (io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse>) responseObserver);
          break;
        case METHODID_GET_STAFF_INFO:
          serviceImpl.getStaffInfo((generatedClasses.StaffRequestOuterClass.StaffRequest1) request,
              (io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_STAFF_INFO:
          serviceImpl.getAllStaffInfo((generatedClasses.StaffListRequestOuterClass.StaffListRequest) request,
              (io.grpc.stub.StreamObserver<generatedClasses.StaffListResponseOuterClass.StaffListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_STAFF:
          serviceImpl.updateStaff((generatedClasses.StaffRequestOuterClass.StaffRequest) request,
              (io.grpc.stub.StreamObserver<generatedClasses.StaffResponseOuterClass.StaffResponse>) responseObserver);
          break;
        case METHODID_REMOVE_STAFF:
          serviceImpl.removeStaff((generatedClasses.StaffRequestOuterClass.StaffRequest1) request,
              (io.grpc.stub.StreamObserver<generatedClasses.StatusResponseOuterClass.StatusResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddStaffMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generatedClasses.StaffRequestOuterClass.StaffRequest,
              generatedClasses.StaffResponseOuterClass.StaffResponse>(
                service, METHODID_ADD_STAFF)))
        .addMethod(
          getGetStaffInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generatedClasses.StaffRequestOuterClass.StaffRequest1,
              generatedClasses.StaffResponseOuterClass.StaffResponse>(
                service, METHODID_GET_STAFF_INFO)))
        .addMethod(
          getGetAllStaffInfoMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              generatedClasses.StaffListRequestOuterClass.StaffListRequest,
              generatedClasses.StaffListResponseOuterClass.StaffListResponse>(
                service, METHODID_GET_ALL_STAFF_INFO)))
        .addMethod(
          getUpdateStaffMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generatedClasses.StaffRequestOuterClass.StaffRequest,
              generatedClasses.StaffResponseOuterClass.StaffResponse>(
                service, METHODID_UPDATE_STAFF)))
        .addMethod(
          getRemoveStaffMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              generatedClasses.StaffRequestOuterClass.StaffRequest1,
              generatedClasses.StatusResponseOuterClass.StatusResponse>(
                service, METHODID_REMOVE_STAFF)))
        .build();
  }

  private static abstract class StaffServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StaffServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generatedClasses.StaffRpc.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StaffService");
    }
  }

  private static final class StaffServiceFileDescriptorSupplier
      extends StaffServiceBaseDescriptorSupplier {
    StaffServiceFileDescriptorSupplier() {}
  }

  private static final class StaffServiceMethodDescriptorSupplier
      extends StaffServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StaffServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StaffServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StaffServiceFileDescriptorSupplier())
              .addMethod(getAddStaffMethod())
              .addMethod(getGetStaffInfoMethod())
              .addMethod(getGetAllStaffInfoMethod())
              .addMethod(getUpdateStaffMethod())
              .addMethod(getRemoveStaffMethod())
              .build();
        }
      }
    }
    return result;
  }
}
