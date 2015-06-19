package com.idg.web.untils;

public enum ConstantEnum {

	COVER_IMAGE_FOLDER("img/CoverImage/"),
	USER_IMAGE_FOLDER("img/UserImage/");
	
	// 定义私有变量
	private String local ;
 
	// 构造函数，枚举类型只能为私有
	private ConstantEnum(String local) {
		this.local = local;
	}
	
	// 构造函数，枚举类型只能为私有
	private ConstantEnum(char num) {

		switch (num) {
			case 'C': this.local = "COVER_IMAGE_FOLDER";break;
			case 'U': this.local = "USER_IMAGE_FOLDER";break;
			default: this.local = "COVER_IMAGE_FOLDER"; break;
		}
	}
 
	@Override
	public String toString() {

		return String.valueOf (this.local);
	}
}
