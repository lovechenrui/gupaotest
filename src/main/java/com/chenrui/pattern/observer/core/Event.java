package com.chenrui.pattern.observer.core;

import java.lang.reflect.Method;

public class Event {
    private Object source;
    private Object target;
    private Method callBack;
    private String triggerName;
    private long triggertime;

    public Event(Object target, Method callBack,String triggerName) {
        this.target = target;
        this.callBack = callBack;
        this.triggerName=triggerName;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallBack() {
        return callBack;
    }

    public void setCallBack(Method callBack) {
        this.callBack = callBack;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public long getTriggertime() {
        return triggertime;
    }

    public void setTriggertime(long triggertime) {
        this.triggertime = triggertime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callBack=" + callBack +
                ", triggerName='" + triggerName + '\'' +
                ", triggertime=" + triggertime +
                '}';
    }
}
