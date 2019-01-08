package com.chenrui.pattern.observer.mouser;

import com.chenrui.pattern.observer.core.EventLisenter;

public class Mouse extends EventLisenter{
    public void click(){
        System.out.println("单击事件");
        trigger(MouseEventType.click);
    }

    public void doubleclick(){
        System.out.println("双击事件");
        trigger(MouseEventType.doubleclick);
    }

    public void keyup(){
        System.out.println("鼠标弹起");
        trigger(MouseEventType.keyup);
    }

    public void keydown(){
        System.out.println("鼠标按下");
        trigger(MouseEventType.keydown);
    }
}
