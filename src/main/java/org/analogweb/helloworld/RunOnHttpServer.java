package org.analogweb.helloworld;

import org.analogweb.core.httpserver.HttpServers;

/**
 * Analogweb application running on Java(Sun) Http Server!
 * @author snowgooseyk
 */
public class RunOnHttpServer {

    public static void main(String... args) {
        HttpServers.create("http://localhost:8080").run();
    }

}
