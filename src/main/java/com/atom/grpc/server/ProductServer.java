package com.atom.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Atom
 */
public class ProductServer {
    private static final int port = 50051;
    private Server server;

    private static final Logger logger = LoggerFactory.getLogger(ProductServer.class);


    public void start() throws IOException {
        /* The port on which the server should run */
        server = ServerBuilder.forPort(port)
                .addService(new ProductInfoServiceImpl())
                .build()
                .start();
        logger.info("gRPC server started, listening on port : {}", port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                logger.info("shutting down gRPC server since JVM is shutting down");
                ProductServer.this.stop();
                logger.info("gRPC server shut down");
            }
        });
    }

    /**
     * main launches the server from the command line.
     */

    /**
     * main launches the server from the command line.
     *
     * @param args arguments
     * @throws IOException          io exception
     * @throws InterruptedException interrupted exception
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final ProductServer server = new ProductServer();
        server.start();
        server.blockUntilShutdown();
    }


    /**
     * await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
}
