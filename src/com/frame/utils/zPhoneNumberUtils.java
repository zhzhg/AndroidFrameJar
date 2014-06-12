package com.frame.utils;

/**
 * @Title: zPhoneNumberUtils.java
 * @Package com.frame.utils
 * @Description: 手机号判断工具类
 * @author Kelvin
 * @date: 2014年6月12日 下午3:30:39
 * @version 1.0
 */
public class zPhoneNumberUtils {

	public static boolean telNumMatch(String phoneNum) {
		/*
		 * 移动: 2G号段(GSM网络)有139,138,137,136,135,134,159,158,152,151,150,
		 * 3G号段(TD-SCDMA网络)有157,182,183,188,187 147是移动TD上网卡专用号段. 联通:
		 * 2G号段(GSM网络)有130,131,132,155,156 3G号段(WCDMA网络)有186,185 电信:
		 * 2G号段(CDMA网络)有133,153 3G号段(CDMA网络)有189,180,181
		 */
		String YD = "^[1]{1}(([3]{1}[4-9]{1})|([5]{1}[012789]{1})|([8]{1}[2378]{1})|([4]{1}[7]{1}))[0-9]{8}$";
		String LT = "^[1]{1}(([3]{1}[0-2]{1})|([5]{1}[56]{1})|([8]{1}[56]{1}))[0-9]{8}$";
		String DX = "^[1]{1}(([3]{1}[3]{1})|([5]{1}[3]{1})|([8]{1}[0-9]{1}))[0-9]{8}$";
		// 判断手机号码是否是11位
		if (phoneNum.length() == 11) {
			// 判断手机号码是否符合中国移动的号码规则
			if (phoneNum.matches(YD)) {
				return true;
			}
			// 判断手机号码是否符合中国联通的号码规则
			else if (phoneNum.matches(LT)) {
				return true;
			}
			// 判断手机号码是否符合中国电信的号码规则
			else if (phoneNum.matches(DX)) {
				return true;
			}
			// 都不合适 未知
			else {
				return false;
			}
		}
		// 不是11位
		else {
			return false;
		}
	}

}
