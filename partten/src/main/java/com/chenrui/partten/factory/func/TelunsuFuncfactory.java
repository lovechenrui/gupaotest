package com.chenrui.partten.factory.func;

import com.chenrui.partten.factory.Milk;
import com.chenrui.partten.factory.Telunsu;

public class TelunsuFuncfactory implements Funcfactory {
	public Milk getMilk() {
		return new Telunsu();
	}
}
