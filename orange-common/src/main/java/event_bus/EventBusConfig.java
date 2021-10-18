package event_bus;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/15
 * Time:下午8:16
 **/
@Slf4j
@Configuration
public class EventBusConfig {

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @Bean
    public EventHandler eventHandler() {
        return new EventHandler();
    }


}
