package com.cc.smartx.spring.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Iterator;
import java.util.Map;

public class ApplicationStartedEventListener implements SmartApplicationListener {

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        // 判断事件的类型，只监听ApplicationStartedEvent事件类型
        return eventType == ApplicationStartedEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 将ApplicationEvent转换为ApplicationStartedEvent实例
        ApplicationStartedEvent startedEvent = (ApplicationStartedEvent) event;
        ConfigurableEnvironment environment = startedEvent.getApplicationContext().getEnvironment();
        // 获取系统环境变量
        Map<String, Object> props = environment.getSystemEnvironment();
        Iterator<String> iterator = props.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object value = props.get(key);
            System.out.println("Key : " + key + " , Value : " + value);
        }
        System.out.println("启动成功了.");
    }
}
