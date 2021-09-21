package com.rpshjha.gmailproject.annotation;

import java.lang.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 08/09/21
 * Time: 10:35 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeScreenshot {

//    public String filename() default "";
}
