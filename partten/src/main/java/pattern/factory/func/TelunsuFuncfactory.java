package com.chenrui.pattern.factory.func;

import com.chenrui.pattern.factory.Milk;
import com.chenrui.pattern.factory.Telunsu;

public class TelunsuFuncfactory implements Funcfactory {
	public Milk getMilk() {
		return new Telunsu();
	}
}
