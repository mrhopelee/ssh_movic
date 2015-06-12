package com.bean;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	public String getMD5(byte[] source){
		String s=null;
		char[] hexDigits={'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f'};
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(source);
			
			byte[] tmp=md.digest();
			
			char[] str=new char[16*2];
			int k=0;
			for(int i=0;i<16;i++){
				byte byte0=tmp[i];
				str[k++]=hexDigits[byte0>>>4 & 0xf];
				str[k++]=hexDigits[byte0 & 0xf];    
			}
			s=new String(str);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return s;
	}
	/*
	public static void main(String[] args) {
		MD5Util md5Util=new MD5Util();
		String result=md5Util.getMD5("���".getBytes());
		System.out.println(result);
	}*/

}