package com.chenrui.partten.prototype.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;

import java.util.List;

public class User implements IPrototype<User> {
    private String name;
    private String age;
    private List<String> hobbys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getHobbys() {
        hobbys.stream().sorted().anyMatch();
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", hobbys=" + hobbys +
                '}';
    }

    public User clone()  {
        String jsonstr =  JSON.toJSONString(this);// JSONObject.toJSONString(this);
        User user =  JSON.parseObject(jsonstr,User.class);
        return user;
    }
}
