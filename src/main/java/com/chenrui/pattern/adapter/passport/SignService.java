package com.chenrui.pattern.adapter.passport;

import com.chenrui.pattern.adapter.ResultMsg;
import com.chenrui.pattern.adapter.User;

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
