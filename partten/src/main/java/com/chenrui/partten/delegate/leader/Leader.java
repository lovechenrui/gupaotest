package com.chenrui.partten.delegate.leader;

import java.util.HashMap;
import java.util.Map;

public class Leader implements ITarget {
    private Map<String,ITarget> targetMap = new HashMap<String,ITarget>();
    public Leader() {
        targetMap.put("加密",new TargetA());
        targetMap.put("登陆",new TargetB());
    }

    public void doing(String command) {
        targetMap.get(command).doing(command);
    }
}
