package com.chenrui.partten.prototype.json;

import java.util.ArrayList;
import java.util.List;

public class PrototypeJsonDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder  = new StringBuilder().append("").append().toString();
        User user = new User();
        user.setName("chenrui");
        user.setAge("18");
        List<String> hobby = new ArrayList<String>();
        hobby.add("吃饭");
        hobby.add("看书");
        user.setHobbys(hobby);

        User user1 = user.clone();

        user1.getHobbys().add("唱歌");

        System.out.println("user="+user);
        System.out.println("user1="+user1);
        System.out.println(user==user1);

    }
}
