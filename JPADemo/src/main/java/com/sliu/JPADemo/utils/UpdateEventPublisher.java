package com.sliu.JPADemo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UpdateEventPublisher {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    public void publishUpdateEvent(String name, String operation) {
        applicationEventPublisher.publishEvent(new UpdateEvent(name, operation, this));
    }
}
