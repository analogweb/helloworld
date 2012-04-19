package org.analogweb.helloworld.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.analogweb.annotation.As;
import org.analogweb.annotation.MapWith;
import org.analogweb.annotation.Scope;
import org.analogweb.core.XmlTypeMapper;

@As
@MapWith(XmlTypeMapper.class)
@Scope("body")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.ANNOTATION_TYPE})
@Inherited
public @interface XmlType {
}
