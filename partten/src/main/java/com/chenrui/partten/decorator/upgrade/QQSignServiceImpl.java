package com.chenrui.partten.decorator.upgrade;

import com.chenrui.partten.adapter.ResultMsg;
import com.chenrui.partten.adapter.User;
import com.chenrui.partten.decorator.old.SignService;

public class QQSignServiceImpl implements QQSignService {

    private SignService signService;

    public QQSignServiceImpl(SignService signService) {
        this.signService = signService;
    }

    public ResultMsg loginforQQ(String openid) {
        User user = new User();
        user.setName(openid);
        user.setPassword(null);
        this.regist(user);
        return this.login(openid,null);
    }

    public ResultMsg regist(User user) {
        return signService.regist(user);
    }

    public ResultMsg login(String username, String password) {
        return signService.login(username,password);
    }
}
