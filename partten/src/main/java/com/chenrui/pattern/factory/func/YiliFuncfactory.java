package com.chenrui.pattern.factory.func;

import com.chenrui.pattern.factory.Milk;
import com.chenrui.pattern.factory.Yili;

public class YiliFuncfactory implements Funcfactory {
	public Milk getMilk() {
		return new Yili();
	}
}
