package com.frame.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Title: zStrToMd5Utils.java
 * @Package com.frame.utils
 * @Description: Md5加密工具类
 * @author Kelvin
 * @date: 2014年6月12日 下午3:24:21
 * @version 1.0
 */
public class zStrToMd5Utils {
	public static String strMd5(String str) {
		StringBuffer buf = new StringBuffer("");
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte b[] = md.digest();

			int i;

			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
			System.out.println("result: " + buf.toString());// 32位的加密
			System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();

		}
		return buf.toString();
	}
}
