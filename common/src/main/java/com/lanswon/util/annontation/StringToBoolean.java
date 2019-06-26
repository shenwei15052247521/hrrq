package com.lanswon.util.annontation;


import java.lang.annotation.*;

/**
 * String转boolean
 * <p>
 *     t(String) --> true(boolean)
 *     f(String) --> false(boolean)
 * </p>
 * @author Jaswine
 */
@Target(ElementType.LOCAL_VARIABLE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface StringToBoolean {

}
