package com.jianjoy.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Author: zhoujian
 * Description:
 * Date: 2021/5/16 22:48
 */
public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create(new InetSocketAddress(8801), 0);
        httpServer.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                byte[] content = "Hello".getBytes("utf-8");
                httpExchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
                httpExchange.sendResponseHeaders(200, content.length);
                httpExchange.getResponseBody().write(content);
                httpExchange.close();
            }
        });
        httpServer.start();
        System.out.println("SimpleHttpServer started.");
    }

}
