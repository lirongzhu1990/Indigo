package com.idg.web.untils;

public final class CookieEncryption {

	public final static String offset = "INDIGO_PROJECT";
	/**
	 * 加密
	 * Offset 偏移量
	 * Original 原文
	 */
	public static String setCookie(String original){

		String[] returnValue = new String[original.length()];
		
		for (int i = 0; i < original.length(); i++) {
			
			String or = String.format("%04d", Integer.parseInt(Integer.toHexString(original.charAt(i))));
			String of = String.format("%04d", Integer.parseInt(Integer.toHexString(offset.charAt(i % offset.length()))));
			
			String newString1 = or.substring(0,2) + of.substring(2,4);
			String newString2 = of.substring(0,2) + or.substring(2,4);
			
			char char1 = (char)Integer.parseInt(newString1);
			char char2 = (char)Integer.parseInt(newString2);
			
			returnValue[i] = char1 + "" + char2;
	    }
		
		return "";
	}
	
	/**
	 * 解密
	 * Offset 偏移量
	 * Original 原文
	 */
	public static String getCookie(String original){
		
		return "";
	}
}
