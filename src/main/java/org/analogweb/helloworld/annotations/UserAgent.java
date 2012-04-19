package org.analogweb.helloworld.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.analogweb.annotation.As;
import org.analogweb.annotation.Scope;


@As("User-Agent")
@Scope("header")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.ANNOTATION_TYPE})
@Inherited
public @interface UserAgent {

}
