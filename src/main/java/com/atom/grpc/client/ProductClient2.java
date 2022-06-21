package com.atom.grpc.client;

import com.atom.grpc.api.ProductId;
import com.atom.grpc.api.ProductInfoServiceGrpc;
import com.atom.grpc.api.ProductResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Atom
 */
public class ProductClient2 {


    /**
     * logger of ProductClient
     */
    private static final Logger logger = LoggerFactory.getLogger(ProductClient2.class);

    /**
     * managed channel
     */
    private final ManagedChannel channel;

    /**
     * blocking stub
     */
    private final ProductInfoServiceGrpc.ProductInfoServiceBlockingStub blockingStub;


    private static final String host = "127.0.0.1";
    private static final int serverPort = 50051;


    public ProductClient2(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public ProductClient2(ManagedChannelBuilder<?> channelBuilder) {
        /**
         *  set max message read size
         */
        //构建通信channel
        channelBuilder.maxInboundMessageSize(Integer.MAX_VALUE);
        channel = channelBuilder.build();
        //拿到代理对象,使用 Channel 构建 BlockingStub
        blockingStub = ProductInfoServiceGrpc.newBlockingStub(channel);
    }


    public static void main(String[] args) throws Exception {
        ProductClient2 client = new ProductClient2(host, serverPort);
        ProductResponse productResponse = client.getProduct();
        logger.info("get product result :{} " + productResponse);
    }


    public ProductResponse getProduct() {
        ProductId productIdRequest = ProductId.newBuilder()
                .setValue("1")
                .build();
        try {
            ProductResponse productResponse = blockingStub.getProduct(productIdRequest);
            return productResponse;
        } catch (Exception e) {
            logger.error("get product  failed : " + e.getMessage(), e);
            return null;
        } finally {
            // 关闭channel, 释放资源.
            channel.shutdown();
        }
    }

}
