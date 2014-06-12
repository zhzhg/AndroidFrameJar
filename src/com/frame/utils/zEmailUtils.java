package com.frame.utils;

import android.text.TextUtils;

/**
 * @Title: zEmailUtils.java
 * @Package com.frame.utils
 * @Description: 判断邮箱格式是否正确
 * @author Kelvin
 * @date: 2014年6月12日 下午3:33:33
 * @version 1.0
 */
public class zEmailUtils {
	private static final String emailAddrReg = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}"
			+ "\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\"
			+ ".)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

	public static boolean isEmailAddr(String email) {
		if (TextUtils.isEmpty(email)) {
			return false;
		}
		if (email.matches(emailAddrReg)) {
			return true;
		}
		return false;
	}

}
