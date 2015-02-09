package org.analogweb.helloworld;

import org.analogweb.core.Servers;

/**
 * RUN an Analogweb Application!
 * @author snowgooseyk
 */
public class Runner {

    public static void main(String... args) {
        Servers.create("http://localhost:8080").run();
    }

}
