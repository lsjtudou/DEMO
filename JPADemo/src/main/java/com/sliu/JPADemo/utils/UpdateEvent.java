package com.sliu.JPADemo.utils;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Getter
public class UpdateEvent extends ApplicationEvent {

    private String name;

    private String operation;

    public UpdateEvent(Object source) {
        super(source);
    }

    public UpdateEvent(Object source, Clock clock) {
        super(source, clock);
    }

    public UpdateEvent(String name, String operation, Object source) {
        super(source);
        this.name = name;
        this.operation = operation;
    }
}
