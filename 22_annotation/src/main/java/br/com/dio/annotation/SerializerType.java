package br.com.dio.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface SerializerType {
    FieldFormatEnum fieldFormat() default FieldFormatEnum.CAMEL_CASE;

    boolean prettify() default true;

}
