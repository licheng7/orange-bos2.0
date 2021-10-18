package event_bus;

import com.google.common.eventbus.Subscribe;
import event_bus.event.TestEvent1;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created with IDEA
 * author:licheng
 * Date:2021/10/15
 * Time:下午6:02
 **/
@Slf4j
public class TestEventListener {

    @Subscribe
    public void onMessageEvent(TestEvent1 event) {
        System.out.println(event.toString());
    }
}
