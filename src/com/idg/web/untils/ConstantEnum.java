package com.idg.web.untils;

public enum ConstantEnum {

	COVER_IMAGE_FOLDER("img/Cover Image/"),
	USER_IMAGE_FOLDER("img/User Image/");
	
	// 定义私有变量
	private String local ;
 
	// 构造函数，枚举类型只能为私有
	private ConstantEnum(String local) {
		this.local = local;
	}
 
	@Override
	public String toString() {

		return String.valueOf (this.local);
	}
}
