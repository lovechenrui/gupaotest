package com.chenrui.partten.observer.subject;

import com.chenrui.partten.observer.core.EventLisenter;

public class Subject extends EventLisenter {
    public void add(){
        System.out.println("添加方法");
        trigger(SubjectEventType.add);
    }

    public void remove(){
        System.out.println("删除方法");
        trigger(SubjectEventType.remove);
    }

    public void edit(){
        System.out.println("编辑方法");
        trigger(SubjectEventType.edit);
    }

    public void query(){
        System.out.println("查询方法");
        trigger(SubjectEventType.query);
    }
}
