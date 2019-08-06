package com.proto.server.greeting;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GreetingServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello world");
        Server server = ServerBuilder.forPort(50051).build();
        server.start();

        server.awaitTermination();
        Runtime.getRuntime().addShutdownHook(new Thread( ()->{
            System.out.println("got a shutdown request");
            server.shutdown();
            System.out.println("server fully stopped");
        }));
    }
}
