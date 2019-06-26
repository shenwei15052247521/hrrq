package com.lanswon.util.reflect;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface String2Boolean {

	boolean value() default true;
}
