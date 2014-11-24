package org.analogweb.helloworld;

import static org.analogweb.core.response.HttpStatus.*;
import org.analogweb.annotation.Route;
import org.analogweb.core.response.HttpStatus;

@Route("/inherit")
public class HelloWorldInheritance extends HelloWorld {

    @Route
    @Override
    public String ping(){
        return "Inherit PONG!";
    }

    @Route
    public HttpStatus forbidden(){
        return FORBIDDEN.byReasonOf("nothing to do!");
    }

}
