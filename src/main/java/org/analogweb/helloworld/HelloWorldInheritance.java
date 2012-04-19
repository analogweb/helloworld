package org.analogweb.helloworld;

import org.analogweb.annotation.On;
import org.analogweb.core.direction.HttpStatus;
import org.analogweb.core.direction.Text;

@On("/inherit")
public class HelloWorldInheritance extends HelloWorld {

    @On
    @Override
    public Text helloworld(){
        return Text.with("hello inhelit world!");
    }

    @On
    public HttpStatus doAnything(){
        return HttpStatus.FORBIDDEN.byReasonOf("nothing to do!");
    }

}
