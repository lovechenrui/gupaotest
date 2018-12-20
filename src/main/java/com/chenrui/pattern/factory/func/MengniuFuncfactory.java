package com.chenrui.pattern.factory.func;

import com.chenrui.pattern.factory.Mengniu;
import com.chenrui.pattern.factory.Milk;

public class MengniuFuncfactory implements Funcfactory {
	public Milk getMilk() {
		return new Mengniu();
	}
}
