package com.chenrui.pattern.decorator.upgrade;

import com.chenrui.pattern.adapter.ResultMsg;
import com.chenrui.pattern.decorator.old.SignService;

public interface QQSignService extends SignService {
    public ResultMsg loginforQQ(String openid);
}
