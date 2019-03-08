package com.chenrui.pattern.decorator.upgrade;

import com.chenrui.pattern.adapter.ResultMsg;
import com.chenrui.pattern.adapter.User;
import com.chenrui.pattern.decorator.old.SignService;

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
