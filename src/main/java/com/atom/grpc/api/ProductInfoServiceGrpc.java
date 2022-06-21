package com.atom.grpc.api;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 *ProductInfo服务定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: ProductInfo.proto")
public final class ProductInfoServiceGrpc {

  private ProductInfoServiceGrpc() {}

  public static final String SERVICE_NAME = "ProductInfoService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.atom.grpc.api.ProductRequest,
      com.atom.grpc.api.ProductId> METHOD_ADD_PRODUCT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "ProductInfoService", "addProduct"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.atom.grpc.api.ProductRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.atom.grpc.api.ProductId.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.atom.grpc.api.ProductId,
      com.atom.grpc.api.ProductResponse> METHOD_GET_PRODUCT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "ProductInfoService", "getProduct"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.atom.grpc.api.ProductId.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.atom.grpc.api.ProductResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductInfoServiceStub newStub(io.grpc.Channel channel) {
    return new ProductInfoServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductInfoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProductInfoServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ProductInfoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProductInfoServiceFutureStub(channel);
  }

  /**
   * <pre>
   *ProductInfo服务定义
   * </pre>
   */
  public static abstract class ProductInfoServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *添加商品 ,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public void addProduct(com.atom.grpc.api.ProductRequest request,
        io.grpc.stub.StreamObserver<com.atom.grpc.api.ProductId> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_PRODUCT, responseObserver);
    }

    /**
     * <pre>
     *获取商品详情,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public void getProduct(com.atom.grpc.api.ProductId request,
        io.grpc.stub.StreamObserver<com.atom.grpc.api.ProductResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_PRODUCT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_PRODUCT,
            asyncUnaryCall(
              new MethodHandlers<
                com.atom.grpc.api.ProductRequest,
                com.atom.grpc.api.ProductId>(
                  this, METHODID_ADD_PRODUCT)))
          .addMethod(
            METHOD_GET_PRODUCT,
            asyncUnaryCall(
              new MethodHandlers<
                com.atom.grpc.api.ProductId,
                com.atom.grpc.api.ProductResponse>(
                  this, METHODID_GET_PRODUCT)))
          .build();
    }
  }

  /**
   * <pre>
   *ProductInfo服务定义
   * </pre>
   */
  public static final class ProductInfoServiceStub extends io.grpc.stub.AbstractStub<ProductInfoServiceStub> {
    private ProductInfoServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductInfoServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductInfoServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductInfoServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *添加商品 ,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public void addProduct(com.atom.grpc.api.ProductRequest request,
        io.grpc.stub.StreamObserver<com.atom.grpc.api.ProductId> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_PRODUCT, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *获取商品详情,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public void getProduct(com.atom.grpc.api.ProductId request,
        io.grpc.stub.StreamObserver<com.atom.grpc.api.ProductResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_PRODUCT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *ProductInfo服务定义
   * </pre>
   */
  public static final class ProductInfoServiceBlockingStub extends io.grpc.stub.AbstractStub<ProductInfoServiceBlockingStub> {
    private ProductInfoServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductInfoServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductInfoServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductInfoServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *添加商品 ,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public com.atom.grpc.api.ProductId addProduct(com.atom.grpc.api.ProductRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_PRODUCT, getCallOptions(), request);
    }

    /**
     * <pre>
     *获取商品详情,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public com.atom.grpc.api.ProductResponse getProduct(com.atom.grpc.api.ProductId request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_PRODUCT, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *ProductInfo服务定义
   * </pre>
   */
  public static final class ProductInfoServiceFutureStub extends io.grpc.stub.AbstractStub<ProductInfoServiceFutureStub> {
    private ProductInfoServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductInfoServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductInfoServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductInfoServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *添加商品 ,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.atom.grpc.api.ProductId> addProduct(
        com.atom.grpc.api.ProductRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_PRODUCT, getCallOptions()), request);
    }

    /**
     * <pre>
     *获取商品详情,格式为"方法名 请求参数 返回参数"
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.atom.grpc.api.ProductResponse> getProduct(
        com.atom.grpc.api.ProductId request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_PRODUCT, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCT = 0;
  private static final int METHODID_GET_PRODUCT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductInfoServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductInfoServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCT:
          serviceImpl.addProduct((com.atom.grpc.api.ProductRequest) request,
              (io.grpc.stub.StreamObserver<com.atom.grpc.api.ProductId>) responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct((com.atom.grpc.api.ProductId) request,
              (io.grpc.stub.StreamObserver<com.atom.grpc.api.ProductResponse>) responseObserver);
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

  private static final class ProductInfoServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.atom.grpc.api.ProductInfoProto.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductInfoServiceDescriptorSupplier())
              .addMethod(METHOD_ADD_PRODUCT)
              .addMethod(METHOD_GET_PRODUCT)
              .build();
        }
      }
    }
    return result;
  }
}
