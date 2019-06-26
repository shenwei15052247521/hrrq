package com.lanswon.util.validator;

import java.lang.annotation.*;


/**
 * 参数验证注解
 * @author Jaswine
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidateParam {

	ValidatorEnum[] value() default {};

	String name() default "";
}
