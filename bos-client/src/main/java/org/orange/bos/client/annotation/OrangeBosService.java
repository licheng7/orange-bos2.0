package org.orange.bos.client.annotation;

import java.lang.annotation.*;

/**
 * 用来标注在业务类上，
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OrangeBosService {

    /**
     * 必须和dubbo服务提供者的group设置一致
     * @return
     */
    String group() default "";
}
