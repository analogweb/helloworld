package org.analogweb.helloworld.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.analogweb.annotation.As;
import org.analogweb.annotation.MapWith;
import org.analogweb.core.ParametersTypeMapper;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@As(":map")
@MapWith(ParametersTypeMapper.class)
public @interface Form {

}
