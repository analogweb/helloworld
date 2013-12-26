package org.analogweb.helloworld;

import static org.analogweb.core.response.BasicResponses.text;
import static org.analogweb.core.response.BasicResponses.xml;

import java.net.URI;

import org.analogweb.Renderable;
import org.analogweb.annotation.Bean;
import org.analogweb.annotation.Get;
import org.analogweb.annotation.PathVariable;
import org.analogweb.annotation.Post;
import org.analogweb.annotation.Put;
import org.analogweb.annotation.RequestFormats;
import org.analogweb.annotation.Route;
import org.analogweb.annotation.XmlType;
import org.analogweb.core.MediaTypes;
import org.analogweb.core.httpserver.HttpServers;
import org.analogweb.core.response.HttpStatus;
import org.analogweb.core.response.Text;
import org.analogweb.core.response.Xml;
import org.analogweb.helloworld.annotations.UserAgent;

/**
 * Hello Analog Web World!
 * @author snowgoose
 */
@Route("/")
public class HelloWorld {

    public static void main(String... args) {
        HttpServers.create(URI.create("http://localhost:8080")).start();
    }

    @Route
    @Get
    public String helloworld() {
        return "Hello World";
    }

    @Route("hello/{name}/world")
    @Get
    public Text helloworld(@PathVariable("name") String name) {
        return text(String.format("Hello %s World", name));
    }

    @Route
    @Get
    public Text helloUserAgent(@UserAgent String userAgent) {
        return text(String.format("Hello World %s", userAgent));
    }

    @Route
    @Get
    public Xml helloXml() {
        FooBean foo = new FooBean();
        return xml(foo);
    }

    @Route
    @RequestFormats
    @Put
    public Renderable helloXmlValue(@XmlType FooBean foo) {
        if (foo == null) {
            return HttpStatus.BAD_REQUEST.byReasonOf("XML entity required.");
        }
        return text("Hello World " + foo.getBaa());
    }

    @Route
    @RequestFormats(MediaTypes.APPLICATION_FORM_URLENCODED)
    @Put
    @Post
    public Xml helloBean(@Bean FooBean foo) {
        return xml(foo);
    }
}
