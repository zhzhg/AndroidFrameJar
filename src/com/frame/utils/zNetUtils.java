package com.frame.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @Title: zNetUtils.java
 * @Package com.frame.utils
 * @Description: 网络工具类，主要对当前设备的网络状态和类型进行判断
 * @author Kelvin
 * @date: 2014年6月12日 下午2:47:52
 * @version 1.0
 */
public class zNetUtils {
	public static final int TYPE_MOBILE_CMNET = 1;
	public static final int TYPE_MOBILE_CMWAP = 2;
	public static final int TYPE_WIFI = 3;
	public static final int TYPE_NO = 0;
	public static final int TYPE_MOBILE_CTWAP = 4; // 移动梦网代理

	/**
	 * 获得当前网络类型
	 * 
	 * @param mContext
	 *            上下文
	 * @return TYPE_MOBILE_CMNET:1 TYPE_MOBILE_CMWAP:2 TYPE_WIFI:3
	 *         TYPE_NO:0(未知类型)
	 */
	public static int getNetWorkType(Context mContext) {
		ConnectivityManager cm = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		// 获得当前网络信息
		NetworkInfo networkInfo = cm.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isAvailable()) {
			int currentNetWork = networkInfo.getType();
			if (currentNetWork == ConnectivityManager.TYPE_MOBILE) {
				if (networkInfo.getExtraInfo() != null
						&& networkInfo.getExtraInfo().equals("cmwap")) {
					// 当前网络为:cmwap网络
					return TYPE_MOBILE_CMWAP;
				} else if (networkInfo.getExtraInfo() != null
						&& networkInfo.getExtraInfo().equals("uniwap")) {
					// 当前网络为:uniwap网络
					return TYPE_MOBILE_CMWAP;
				} else if (networkInfo.getExtraInfo() != null
						&& networkInfo.getExtraInfo().equals("3gwap")) {
					// 当前网络为:3gwap网络
					return TYPE_MOBILE_CMWAP;
				} else if (networkInfo.getExtraInfo() != null
						&& networkInfo.getExtraInfo().contains("ctwap")) {
					// 当前网络为ctwap网络
					return TYPE_MOBILE_CTWAP;
				} else {
					// 当前网络为:net网络
					return TYPE_MOBILE_CMNET;
				}

			} else if (currentNetWork == ConnectivityManager.TYPE_WIFI) {
				// 当前网络为:WIFI网络
				return TYPE_WIFI;
			} else {
				// 未知的移动网络
				return TYPE_MOBILE_CMNET;
			}
		}

		// 当前网络为:不是我们考虑的网络
		return TYPE_NO;
	}

}
