package org.analogweb.helloworld;

import java.net.URI;

import org.analogweb.Renderable;
import org.analogweb.annotation.Bean;
import org.analogweb.annotation.RequestFormats;
import org.analogweb.annotation.Route;
import org.analogweb.annotation.XmlType;
import org.analogweb.core.MediaTypes;
import org.analogweb.core.httpserver.HttpServers;
import org.analogweb.core.response.HttpStatus;
import org.analogweb.core.response.Text;
import org.analogweb.core.response.Xml;
import org.analogweb.helloworld.annotations.UserAgent;
import org.analogweb.util.logging.Log;
import org.analogweb.util.logging.Logs;

/**
 * Hello Analog Web World!
 * @author snowgoose
 */
@Route("/")
public class HelloWorld {

    private static final Log log = Logs.getLog(HelloWorld.class);

    public static void main(String... args) {
        HttpServers.create(URI.create("http://localhost:8080")).start();
    }

    @Route
    public Text helloworld() {
        log.info("hello world!");
        return Text.with("Hello World");
    }

    @Route
    public Text helloUserAgent(@UserAgent String userAgent) {
        return Text.with("Hello World " + userAgent);
    }

    @Route
    public Xml helloXml() {
        FooBean foo = new FooBean();
        return Xml.as(foo);
    }

    @Route
    @RequestFormats(MediaTypes.APPLICATION_XML)
    public Renderable helloXmlValue(@XmlType FooBean foo) {
        if(foo == null){
            return HttpStatus.BAD_REQUEST.byReasonOf("XML entity required.");
        }
        return Text.with("Hello World " + foo.getBaa());
    }

    @Route
    public Xml helloBean(@Bean FooBean foo) {
        return Xml.as(foo);
    }
}
