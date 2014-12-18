package org.analogweb.helloworld;

import static org.analogweb.core.response.BasicResponses.json;

import java.io.IOException;
import java.io.InputStream;

import org.analogweb.acf.MultipartParam;
import org.analogweb.annotation.Get;
import org.analogweb.annotation.Param;
import org.analogweb.annotation.Post;
import org.analogweb.annotation.RequestFormats;
import org.analogweb.annotation.Resolver;
import org.analogweb.annotation.Route;
import org.analogweb.core.MediaTypes;
import org.analogweb.core.response.Json;
import org.analogweb.helloworld.annotations.UserAgent;
import org.analogweb.jackson.JacksonJsonValueResolver;

/**
 * Hello Analog Web World!
 * @author snowgoose
 */
@Route("/")
public class HelloWorld {

    @Route
    @Get
    public String ping() {
        return "PONG!";
    }

    @Route("helloworld")
    @Get
    public String helloworld(@Param("n") String name) {
        return String.format("Hello %s World", name);
    }

    @Route("agent")
    @Get
    public String getUserAgent(@UserAgent String userAgent) {
        return String.format("Hello World %s", userAgent);
    }

    @Route
    @Post
    public String upload(@MultipartParam("filedata")InputStream in) throws IOException {
    	try{
        	StringBuilder response = new StringBuilder();
        	int b;
        	while((b = in.read()) != -1){
        		response.append((char)b);
        	}
            return response.toString();
    	} finally {
    		in.close();
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
    public Json getJson(@Resolver(JacksonJsonValueResolver.class) FooBean foo) {
        return json(foo);
    }

    @Route("nothing")
    @Get
    public void doNothing() {
        // Return no content(204)
    }

}
