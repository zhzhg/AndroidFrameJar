package com.frame.utils;

import android.util.Log;

/**
 * 日志打印类
 * 
 * @author zhangzg
 * 
 */

public class zLog {
	// 是否打印日志־
	public static boolean isDebug = false;
	// 日志标签
	public static String LOG_TAG = "frame";

	public static void v(String tag, String msg) {
		if (isDebug) {
			Log.v(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (isDebug) {
			Log.i(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (isDebug) {
			Log.d(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (isDebug) {
			Log.w(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (isDebug) {
			Log.e(tag, msg);
		}
	}

	public static void print(String tag, String msg) {
		System.out.println("tag==" + msg);
	}
}
