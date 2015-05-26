package org.analogweb.helloworld;

import static org.analogweb.core.response.BasicResponses.json;

import java.io.IOException;
import java.io.InputStream;

import org.analogweb.Renderable;
import org.analogweb.RequestPath;
import org.analogweb.annotation.MultipartParam;
import org.analogweb.annotation.Context;
import org.analogweb.annotation.Get;
import org.analogweb.annotation.Param;
import org.analogweb.annotation.PathVariable;
import org.analogweb.annotation.Post;
import org.analogweb.annotation.RequestFormats;
import org.analogweb.annotation.Route;
import org.analogweb.core.MediaTypes;
import org.analogweb.core.Servers;
import org.analogweb.core.response.HttpStatus;
import org.analogweb.core.response.Json;
import org.analogweb.core.response.Text;
import org.analogweb.helloworld.annotations.UserAgent;
import org.analogweb.jackson.JsonType;
import org.analogweb.util.logging.Log;
import org.analogweb.util.logging.Logs;

/**
 * Hello Analog Web World!
 * @author snowgoose
 */
@Route("/")
public class HelloWorld {

    private Log log = Logs.getLog(HelloWorld.class);

    public static void main(String... args) {
        Servers.run();
    }

    @Route
    @Get
    public String ping() {
        return "PONG!";
    }

    @Route("/path/*")
    @Get
    public String path(@Context RequestPath path) {
        return path.getActualPath();
    }

    @Route("helloworld")
    @Get
    public String helloworld(@Param("n") String name) {
        return String.format("Hello %s World", name);
    }

    @Route("hello/{who}/world")
    @Get
    public String helloSomeoneWorld(@PathVariable("who") String name) {
        return String.format("Hello %s World", name);
    }

    @Route("agent")
    @Get
    public String getUserAgent(@UserAgent String userAgent) {
        return String.format("Hello World %s", userAgent);
    }

    @Route
    @Post
    public Renderable upload(@MultipartParam("filedata") InputStream in) throws IOException {
        try {
            if (in == null) {
                return HttpStatus.BAD_REQUEST;
            }
            StringBuilder response = new StringBuilder();
            int b;
            while ((b = in.read()) != -1) {
                response.append((char) b);
            }
            // echo upload contents.
            return Text.with(response.toString());
        } finally {
            //    		in.close();
        }
    }

    @Route("json")
    @Get
    public Json getJson() {
        return json(new FooBean());
    }

    @Route("json")
    @RequestFormats(MediaTypes.APPLICATION_JSON)
    @Post
    public Json getJson(@JsonType FooBean foo) {
        log.info(foo.toString());
        return json(foo);
    }

    @Route("nothing")
    @Get
    public void doNothing() {
        // Return no content(204)
    }
}
