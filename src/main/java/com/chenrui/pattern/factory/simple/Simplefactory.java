package com.chenrui.pattern.factory.simple;

import com.chenrui.pattern.factory.Mengniu;
import com.chenrui.pattern.factory.Milk;
import com.chenrui.pattern.factory.Telunsu;
import com.chenrui.pattern.factory.Yili;

public class Simplefactory {
	/**
	 * 小作坊自己生产各种品牌的牛奶
	 * @param name
	 * @return
	 */
	public Milk getMilk(String name){
		if("telunsu".equals(name)){
			return new Telunsu();
		}
		if("mengniu".equals(name)){
			return new Mengniu();
		}
		if("yili".equals(name)){
			return new Yili();
		}
		return null;
	}
}
