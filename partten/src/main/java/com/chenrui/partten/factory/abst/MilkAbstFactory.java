package com.chenrui.partten.factory.abst;

import com.chenrui.partten.factory.Mengniu;
import com.chenrui.partten.factory.Milk;
import com.chenrui.partten.factory.Telunsu;
import com.chenrui.partten.factory.Yili;

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
