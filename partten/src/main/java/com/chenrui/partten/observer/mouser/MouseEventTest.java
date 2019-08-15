package com.chenrui.partten.observer.mouser;

import com.chenrui.partten.observer.core.Event;

import java.lang.reflect.Method;

public class MouseEventTest {
    public static void main(String[] args) {
        try{
            MouseObservice observice =  new MouseObservice();
            Method clickMethod =observice.getClass().getMethod("click", Event.class);
            Mouse mouse = new Mouse();
            mouse.addLisenter(MouseEventType.click,observice,clickMethod);
            mouse.click();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
