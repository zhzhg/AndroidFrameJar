package com.frame.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * @Title: zHomeWatcher.java
 * @Package com.frame.utils
 * @Description: Home键监听封装
 * @author Kelvin
 * @date: 2014年6月12日 下午2:43:06
 * @version 1.0
 */
public class zHomeWatcher {

	static final String TAG = "HomeWatcher";
	private Context mContext;
	private IntentFilter mFilter;
	private OnHomePressedListener mListener;
	private InnerRecevier mRecevier;

	// 回调接口
	public interface OnHomePressedListener {
		public void onHomePressed();

		public void onHomeLongPressed();
	}

	public zHomeWatcher(Context context) {
		mContext = context;
		mRecevier = new InnerRecevier();
		mFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
	}

	/**
	 * 设置监听
	 * 
	 * @param listener
	 */
	public void setOnHomePressedListener(OnHomePressedListener listener) {
		mListener = listener;
	}

	/**
	 * 开始监听，注册广播
	 */
	public void startWatch() {
		if (mRecevier != null) {
			mContext.registerReceiver(mRecevier, mFilter);
		}
	}

	/**
	 * 停止监听，注销广播
	 */
	public void stopWatch() {
		if (mRecevier != null) {
			mContext.unregisterReceiver(mRecevier);
		}
	}

	/**
	 * 广播接收者
	 */
	class InnerRecevier extends BroadcastReceiver {
		final String SYSTEM_DIALOG_REASON_KEY = "reason";
		final String SYSTEM_DIALOG_REASON_GLOBAL_ACTIONS = "globalactions";
		final String SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps";
		final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)) {
				String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
				if (reason != null) {
					if (mListener != null) {
						if (reason.equals(SYSTEM_DIALOG_REASON_HOME_KEY)) {
							// 短按home键
							mListener.onHomePressed();
						} else if (reason
								.equals(SYSTEM_DIALOG_REASON_RECENT_APPS)) {
							// 长按home键
							mListener.onHomeLongPressed();
						}
					}
				}
			}
		}
	}
}