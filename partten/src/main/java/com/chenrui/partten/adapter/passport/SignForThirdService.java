package com.chenrui.partten.adapter.passport;

import com.chenrui.partten.adapter.ResultMsg;
import com.chenrui.partten.adapter.User;

public class SignForThirdService extends SignService {
    /**
     * 其他的第三方登陆和这个类似
     * @param openid
     * @return
     */
    public ResultMsg loginforQQ(String openid){
        //openid唯一，可以作为用户
        //密码empty
        //注册成一个用户
        User user = new User();
        user.setName(openid);
        user.setPassword(null);
        ResultMsg rs = super.regist(user);
        //登陆
        ResultMsg rsmsg = super.login(openid,null);
        return rsmsg;
    }
}
