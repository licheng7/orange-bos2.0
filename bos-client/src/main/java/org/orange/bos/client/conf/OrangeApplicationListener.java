/**
 * ClassName: OrangeApplicationListener
 * Description:
 * date: 2021/10/18 2:36 上午
 *
 * @author licheng
 */
package org.orange.bos.client.conf;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class OrangeApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContextRefreshedEvent) {
            int a = 0;
        }
    }
}
