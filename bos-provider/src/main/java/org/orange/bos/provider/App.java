package org.orange.bos.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;

/**
 * ClassName: org.orange.bos.provider.App
 * Description:
 * date: 2021/10/17 11:49 下午
 *
 * @author licheng
 */
@Slf4j
@SpringBootApplication(scanBasePackages = {"org.orange.bos.provider"})
@PropertySource(value = {"classpath:application.yaml"})
@EnableDiscoveryClient
public class App {
    public static void main(String[] args) {
        log.info("bos-processor启动");
        SpringApplication.run(App.class, args);
    }
}
