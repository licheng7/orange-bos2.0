package annotation;

import conf.CommonInitConf;
import event_bus.EventBusConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/15
 * Time:下午4:18
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({EventBusConfig.class, CommonInitConf.class})
public @interface EnableOrangeCommon {

}
