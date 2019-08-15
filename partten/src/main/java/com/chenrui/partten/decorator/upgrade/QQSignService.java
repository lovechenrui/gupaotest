package com.chenrui.partten.decorator.upgrade;

import com.chenrui.partten.adapter.ResultMsg;
import com.chenrui.partten.decorator.old.SignService;

public interface QQSignService extends SignService {
    public ResultMsg loginforQQ(String openid);
}
