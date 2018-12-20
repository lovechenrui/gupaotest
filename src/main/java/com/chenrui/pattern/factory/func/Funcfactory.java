package com.chenrui.pattern.factory.func;

import com.chenrui.pattern.factory.Milk;

/**
 * 大工厂，可以找不同的厂家生产牛奶
 */
public interface Funcfactory {
	Milk getMilk();
}
