package me.sungbin;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnotherAnnotation {

    String value() default "sungbin";

    int number() default 100;
}
