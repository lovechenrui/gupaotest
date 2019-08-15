package com.chenrui.partten.decorator.old;

import com.chenrui.partten.adapter.ResultMsg;
import com.chenrui.partten.adapter.User;

public class SignServiceImpl implements SignService {
    public com.chenrui.partten.adapter.ResultMsg regist(com.chenrui.partten.adapter.User user){
        return new com.chenrui.partten.adapter.ResultMsg("200",new User(),"注册成功");
    }

    public com.chenrui.partten.adapter.ResultMsg login(String username, String password){
        return new ResultMsg("200","","登陆成功");
    }
}
