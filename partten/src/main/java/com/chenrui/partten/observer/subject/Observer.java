package com.chenrui.partten.observer.subject;

import com.chenrui.partten.observer.core.Event;

public class Observer {
    public void advice(Event event){
        System.out.println("****************我是观察者*******************"+event);
    }
}
