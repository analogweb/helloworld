package org.analogweb.helloworld;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Foo{
    @XmlElement
    private String baa = "baz";
    
    public String getBaa(){
        return this.baa;
    }

}

