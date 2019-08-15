package com.chenrui.partten.observer.subject;

import com.chenrui.partten.observer.core.Event;

import java.lang.reflect.Method;

public class SubjectEventTest {
    public static void main(String[] args) {
        try{
            Observer observer = new Observer();
            Method callback = observer.getClass().getMethod("advice",new Class<?>[]{Event.class});
            Subject subject = new Subject();
            subject.addLisenter(SubjectEventType.add,observer,callback);
            subject.addLisenter(SubjectEventType.remove,observer,callback);
            subject.addLisenter(SubjectEventType.edit,observer,callback);
            subject.addLisenter(SubjectEventType.query,observer,callback);
            subject.add();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
