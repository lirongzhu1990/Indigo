package com.idg.web.untils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {

	@SuppressWarnings("finally")
	public static String EncoderByMd5(String str){
		
		String newstr = "";
		try{
			
			//确定计算方法
			MessageDigest md5=MessageDigest.getInstance("MD5");
			BASE64Encoder base64en = new BASE64Encoder();
			
			//加密后的字符串
			newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
		}catch(NoSuchAlgorithmException n){
			
			n.printStackTrace();
		}catch (UnsupportedEncodingException u) {
			
			u.printStackTrace();
		}finally{
			
			return newstr;
		}
	}
}

