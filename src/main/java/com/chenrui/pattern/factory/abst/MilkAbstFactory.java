package com.chenrui.pattern.factory.abst;

import com.chenrui.pattern.factory.Mengniu;
import com.chenrui.pattern.factory.Milk;
import com.chenrui.pattern.factory.Telunsu;
import com.chenrui.pattern.factory.Yili;

public class MilkAbstFactory extends  AbstFactory{
	public Milk getTelunsu() {
		return new Telunsu();
	}

	public Milk getYili() {
		return new Yili();
	}

	public Milk getMengniu() {
		return new Mengniu();
	}
}
