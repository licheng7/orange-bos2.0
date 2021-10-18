package org.orange.bos.client.annotation;

import lombok.ToString;

import java.lang.annotation.*;

/**
 * 用来标注在业务方法上，将业务方法注册为BOS组件；该注解必须配合{@link OrangeBosService}一起使用
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface OrangeBosComponent {

    /**
     * 标注接口（组件）名称
     * @return
     */
    String name();

    /**
     * 组件版本号
     * @return
     */
    String version() default "1.0.0_DEFAULT";

    /**
     * 组件描述
     * @return
     */
    String desc() default "";
}
