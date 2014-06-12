package com.frame.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences工具类
 * 
 * @author zhangzg
 * 
 */

public class zShareFileUtils {

	public SharedPreferences mPreference = null;// 共享文件

	/**
	 * 初始化SharedPreferences
	 * 
	 * @param context
	 * @param fileName
	 *            文件名
	 * @param mode
	 *            操作模式
	 */
	public void initSharePre(Context context, String fileName, int mode) {
		mPreference = context.getSharedPreferences(fileName, mode);
	}

	/**
	 * 从共享文件中获取字符串
	 * 
	 * @param key
	 *            表签名
	 * @param defValue
	 *            值
	 */
	public String getString(String key, String defValue) {
		return mPreference.getString(key, defValue);
	}

	/**
	 * 从共享文件中获取整型数据
	 * 
	 * @param key
	 *            表签名
	 * @param defValue
	 *            值
	 */
	public int getInt(String key, int defValue) {
		return mPreference.getInt(key, defValue);
	}

	/**
	 * 从共享文件中获取boolean数据
	 * 
	 * @param key
	 *            表签名
	 * @param defValue
	 *            值
	 */
	public boolean getBoolean(String key, boolean defValue) {
		return mPreference.getBoolean(key, defValue);
	}

	/**
	 * 保存字符串数据
	 * 
	 * @param key
	 *            表签名
	 * @param defValue
	 *            值
	 */
	public void setString(String key, String defValue) {
		mPreference.edit().putString(key, defValue).commit();
	}

	/**
	 * 保存整型数据
	 * 
	 * @param key
	 *            表签名
	 * @param defValue
	 *            值
	 */
	public void setInt(String key, int defValue) {
		mPreference.edit().putInt(key, defValue).commit();
	}

	/**
	 * 保存boolean数据
	 * 
	 * @param key
	 *            表签名
	 * @param defValue
	 *            值
	 */
	public void setBoolean(String key, boolean defValue) {
		mPreference.edit().putBoolean(key, defValue).commit();
	}

}
