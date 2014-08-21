package org.analogweb.helloworld;

import org.analogweb.netty.HttpServers;

/**
 * Analogweb application running on Netty4!
 * @author snowgooseyk
 */
public class RunOnNetty4 {

    public static void main(String... args) {
        HttpServers.create("http://localhost:8080").run();
    }

}
