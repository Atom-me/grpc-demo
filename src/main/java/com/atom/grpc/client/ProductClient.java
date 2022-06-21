package com.atom.grpc.client;

import com.atom.grpc.api.ProductId;
import com.atom.grpc.api.ProductInfoServiceGrpc;
import com.atom.grpc.api.ProductRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Atom
 */
public class ProductClient {


    /**
     * logger of ProductClient
     */
    private static final Logger logger = LoggerFactory.getLogger(ProductClient.class);

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


    public ProductClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    public ProductClient(ManagedChannelBuilder<?> channelBuilder) {
        /**
         *  set max message read size
         */
        //构建通信channel
        channelBuilder.maxInboundMessageSize(Integer.MAX_VALUE);
        channel = channelBuilder.build();
        //拿到代理对象,使用 Channel 构建 BlockingStub
        blockingStub = ProductInfoServiceGrpc.newBlockingStub(channel);
    }


    public static void main(String[] args) {
        ProductClient client = new ProductClient(host, serverPort);
        String addResult = client.addProduct();
        logger.info("add product result :{} " + addResult);
    }


    public String addProduct() {
        ProductRequest productRequest = ProductRequest.newBuilder()
                .setId("1")
                .setName("mobile")
                .setDescription("atom's iphone12 mini")
                .build();
        try {
            ProductId productId = blockingStub.addProduct(productRequest);
            return productId.getValue();
        } catch (Exception e) {
            logger.error("add product  failed : " + e.getMessage(), e);
            return null;
        } finally {
            // 关闭channel, 释放资源.
            channel.shutdown();
        }
    }

}
