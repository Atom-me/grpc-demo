package com.atom.grpc.server;

import com.atom.grpc.api.*;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Atom
 */
public class ProductInfoServiceImpl extends ProductInfoServiceGrpc.ProductInfoServiceImplBase {

    private static HashMap<String, Product> productHashMap = new HashMap<>();

    @Override
    public void addProduct(ProductRequest request, StreamObserver<ProductId> responseObserver) {
//        super.addProduct(request, responseObserver);

        ProductId productIdResponse = null;
        try {
            String productId = request.getId();
            String productName = request.getName();
            String productDesc = request.getDescription();
            Product product = new Product();
            product.setId(productId);
            product.setName(productName);
            product.setDescription(productDesc);

            productHashMap.put(request.getId(), product);

            productIdResponse = ProductId.newBuilder()
                    .setValue(productId)
                    .build();

        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            // 这种写法是observer,异步写法,老外喜欢用这个框架.
            responseObserver.onNext(productIdResponse);
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(ProductId request, StreamObserver<ProductResponse> responseObserver) {
//        super.getProduct(request, responseObserver);

        ProductResponse productResponse = null;
        try {
            Product product = productHashMap.get(request.getValue());
            if (Objects.nonNull(product)){
                productResponse = ProductResponse.newBuilder()
                        .setId(product.getId())
                        .setName(product.getName())
                        .setDescription(product.getDescription())
                        .build();            }
        } catch (Exception e) {
            responseObserver.onError(e);
        } finally {
            responseObserver.onNext(productResponse);
        }
        responseObserver.onCompleted();

    }
}
