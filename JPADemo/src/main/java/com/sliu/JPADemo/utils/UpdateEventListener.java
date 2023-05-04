package com.sliu.JPADemo.utils;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class UpdateEventListener implements ApplicationListener<UpdateEvent> {

    @Override
    public void onApplicationEvent(UpdateEvent event) {
        System.out.println(event.getOperation() + "======" + event.getName());

    }
}
