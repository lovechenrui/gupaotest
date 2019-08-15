package com.chenrui.partten.factory.func;

import com.chenrui.partten.factory.Milk;
import com.chenrui.partten.factory.Yili;

public class YiliFuncfactory implements Funcfactory {
	public Milk getMilk() {
		return new Yili();
	}
}
