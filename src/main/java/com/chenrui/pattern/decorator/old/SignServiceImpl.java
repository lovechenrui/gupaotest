package com.chenrui.pattern.decorator.old;

import com.chenrui.pattern.adapter.ResultMsg;
import com.chenrui.pattern.adapter.User;

public class SignServiceImpl implements SignService {
    public com.chenrui.pattern.adapter.ResultMsg regist(com.chenrui.pattern.adapter.User user){
        return new com.chenrui.pattern.adapter.ResultMsg("200",new User(),"注册成功");
    }

    public com.chenrui.pattern.adapter.ResultMsg login(String username, String password){
        return new ResultMsg("200","","登陆成功");
    }
}
