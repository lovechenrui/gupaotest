package com.chenrui.pattern.observer.mouser;

import com.chenrui.pattern.observer.core.Event;

public class MouseObservice {
    public void click(Event event){
        System.out.println("监听单击事件"+event);
    }

    public void doubleclick(Event event){
        System.out.println("监听双击事件"+event);
    }

    public void keyup(Event event){
        System.out.println("监听鼠标弹起"+event);
    }

    public void keydown(Event event){
        System.out.println("监听鼠标按下"+event);
    }
}
