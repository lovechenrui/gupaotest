package com.chenrui.pattern.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventLisenter {
    //注册器
   protected Map<Enum,Event> triggerEvents = new HashMap<Enum, Event>();

   public void addLisenter(Enum eventType,Object target,Method callback){
       triggerEvents.put(eventType,new Event(target,callback,eventType.toString()));
   }

   private void trigger(Event event){
       event.setSource(this);
       event.setTriggertime(System.currentTimeMillis());
       try {
           event.getCallBack().invoke(event.getTarget(),event);
       } catch (IllegalAccessException e) {
           e.printStackTrace();
       } catch (InvocationTargetException e) {
           e.printStackTrace();
       }
   }

   protected void trigger(Enum eventType){
       if(triggerEvents.containsKey(eventType)){
           trigger(triggerEvents.get(eventType));
       }else{
           return;
       }
   }
}
