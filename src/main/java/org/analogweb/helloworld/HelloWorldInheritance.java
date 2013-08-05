package org.analogweb.helloworld;

import org.analogweb.annotation.Route;
import org.analogweb.core.response.HttpStatus;
import org.analogweb.core.response.Text;

@Route("/inherit")
public class HelloWorldInheritance extends HelloWorld {

    @Route
    @Override
    public Text helloworld(){
        return Text.with("hello inherit world!");
    }

    @Route
    public HttpStatus forbidden(){
        return HttpStatus.FORBIDDEN.byReasonOf("nothing to do!");
    }

}
