package com.chenrui.partten.adapter.passport;

import com.chenrui.partten.adapter.ResultMsg;
import com.chenrui.partten.adapter.User;

/**
 * 原有的登录注册接口
 */
public class SignService {

    public ResultMsg regist(User user){
        return new ResultMsg("200",new User(),"注册成功");
    }

    public ResultMsg login(String username,String password){
        return new ResultMsg("200","","登陆成功");
    }
}
