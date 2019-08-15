package com.chenrui.partten.decorator.old;

import com.chenrui.partten.adapter.ResultMsg;
import com.chenrui.partten.adapter.User;

/**
 * 原有的登录注册接口
 */
public interface SignService {

    public ResultMsg regist(User user);

    public ResultMsg login(String username,String password);
}
