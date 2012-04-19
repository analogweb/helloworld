package org.analogweb.helloworld;

import java.util.Date;

import org.analogweb.annotation.As;
import org.analogweb.annotation.Get;
import org.analogweb.annotation.On;
import org.analogweb.core.direction.Forward;
import org.analogweb.core.direction.Text;
import org.analogweb.core.direction.Xml;
import org.analogweb.helloworld.annotations.Form;
import org.analogweb.helloworld.annotations.UserAgent;
import org.analogweb.helloworld.annotations.XmlType;
import org.analogweb.util.logging.Log;
import org.analogweb.util.logging.Logs;

/**
 * Hello Analog Web World!
 * @author snowgoose
 */
@On("/")
public class HelloWorld {
    
    private static final Log log = Logs.getLog(HelloWorld.class);

    @On
    public Text helloworld() {
        log.info("hello world!");
        return Text.with("Hello World");
    }

    @On
    public Text helloUserAgent(@UserAgent String userAgent) {
        return Text.with("Hello World " + userAgent);
    }
    
    @On 
    public Xml helloXml(@XmlType Foo foo){
        return Xml.as(foo);
    }
    
    @On
    public Forward helloForward(@As("name") final String name) {
        log.info(String.format("hello world %s !", name));
        return Forward.to("/index.jsp").with("name", name);
    }

    @Get
    @On("{name}/world")
    public Forward helloRestFlavor(@As("at") final Date at, @As("name") final String name) {
        log.info(String.format("hello world at %s !", at));
        return Forward.to("/index.jsp").with("name", name);
    }

    @On
    public Xml helloForm(@Form Foo foo){
        return Xml.as(foo);
    }

}
