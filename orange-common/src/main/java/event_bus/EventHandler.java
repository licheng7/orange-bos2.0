package event_bus;

import com.google.common.eventbus.EventBus;
import event_bus.event.TestEvent1;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/15
 * Time:下午8:18
 **/
public class EventHandler {

    @Autowired
    private EventBus eventBus;

    @Autowired
    private TestEventListener testEventListener;

    @PostConstruct
    public void init() {
        eventBus.register(testEventListener);
    }

    @PreDestroy
    public void destroy() {
        eventBus.unregister(testEventListener);
    }

    public void eventPost(){
        eventBus.post(new TestEvent1("orange test event"));
    }
}
