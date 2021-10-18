/**
 * BOS系统客户端：组件收集器，该类实现Bean后置处理器，扫描BOS注解，拿到业务系统所有待注册组件接口and参数，将其统一注册到BOS注册中心
 *
 * ClassName: ComponentCollector
 * Description:
 * date: 2021/10/16 6:23 下午
 *
 * @author licheng
 */
package org.orange.bos.client;

import org.apache.dubbo.config.ApplicationConfig;
import org.orange.bos.client.annotation.OrangeBosComponent;
import org.orange.bos.client.annotation.OrangeBosService;
import org.orange.bos.client.report.BosComponentReportData;
import org.orange.bos.client.report.BosComponentReporter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

@Component
@ComponentScan({"org.orange.bos.client"})
public class ComponentCollector implements BeanPostProcessor {

    final String SERIALVERSIONUID = "serialVersionUID";

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        List<BosComponentReportData> componentList = new ArrayList<>();
        if(null != bean.getClass().getAnnotation(OrangeBosService.class)) {
            Method[] methods = bean.getClass().getMethods();
            for(Method method : methods) {
                OrangeBosComponent orangeBosComponent = method.getAnnotation(OrangeBosComponent.class);
                if(null != orangeBosComponent) {
                    if(method.getParameterCount() > 1) {
                        throw new RuntimeException(
                                new StringBuilder("BOS组件方法参数不唯一:").append(beanName).append(".").append(method).toString());
                    }
                    Map<String, Class<?>> params = new HashMap<>();
                    Parameter[] parameters = method.getParameters();
                    if(!ObjectUtils.isEmpty(parameters)) {
                        Parameter parameter = parameters[0];
                        String name = parameter.getName();
                        Class<?> type = parameter.getType();
                        Field[] declaredFields = type.getDeclaredFields();
                        Arrays.stream(declaredFields).forEach(declaredField -> {
                            if(!declaredField.getName().endsWith(SERIALVERSIONUID)) {
                                params.put(declaredField.getName(), declaredField.getType());
                            }});
                    }
                    Class<?> returnType = method.getReturnType();
                    componentList.add(new BosComponentReportData());
                }
            }
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
