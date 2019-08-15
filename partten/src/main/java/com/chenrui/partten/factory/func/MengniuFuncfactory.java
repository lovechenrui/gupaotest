package com.chenrui.partten.factory.func;

import com.chenrui.partten.factory.Mengniu;
import com.chenrui.partten.factory.Milk;

public class MengniuFuncfactory implements Funcfactory {
	public Milk getMilk() {
		return new Mengniu();
	}
}
