package com.chenrui.pattern.decorator.old;

import com.chenrui.pattern.adapter.ResultMsg;
import com.chenrui.pattern.adapter.User;

/**
 * 原有的登录注册接口
 */
public interface SignService {

    public ResultMsg regist(User user);

    public ResultMsg login(String username,String password);
}
