package com.chenrui.partten.factory.func;

import com.chenrui.partten.factory.Milk;

/**
 * 大工厂，可以找不同的厂家生产牛奶
 */
public interface Funcfactory {
	Milk getMilk();
}
