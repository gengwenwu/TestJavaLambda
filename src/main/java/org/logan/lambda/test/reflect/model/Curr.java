package org.logan.lambda.test.reflect.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc: TODO <br/>
 * time: 2019/6/21 下午3:15 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Curr {

}
