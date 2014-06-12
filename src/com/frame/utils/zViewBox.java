package com.frame.utils;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @Title: zViewBox.java
 * @Package com.frame.utils
 * @Description: findViewById工具类
 * @author Kelvin
 * @date: 2014年6月12日 下午3:21:44
 * @version 1.0
 */
public enum zViewBox {
	View;
	private static final String ID = "id";

	public static void viewBox(Context context, Object obj) {
		Resources resouce = context.getResources();
		if (obj != null && context != null) {
			Field[] fileds = obj.getClass().getDeclaredFields();
			for (Field f : fileds) {
				f.setAccessible(true);
				try {
					View retView = ((Activity) context).findViewById(resouce.getIdentifier(f.getName(), ID,
							context.getPackageName()));
					if (f.getType() == EditText.class) {
						f.set(obj, (EditText) retView);
					} else if (f.getType() == TextView.class) {
						f.set(obj, (TextView) retView);
					} else if (f.getType() == ImageView.class) {
						f.set(obj, (ImageView) retView);
					} else if (f.getType() == Button.class) {
						f.set(obj, (Button) retView);
					} else if (f.getType() == RelativeLayout.class) {
						f.set(obj, (RelativeLayout) retView);
					} else if (f.getType() == LinearLayout.class) {
						f.set(obj, (LinearLayout) retView);
					} else if (f.getType() == FrameLayout.class) {
						f.set(obj, (FrameLayout) retView);
					} else if (f.getType() == ListView.class) {
						f.set(obj, (ListView) retView);
					} else if (f.getType() == GridView.class) {
						f.set(obj, (GridView) retView);
					} else if (f.getType() == CheckBox.class) {
						f.set(obj, (CheckBox) retView);
					} else if (f.getType() == Spinner.class) {
						f.set(obj, (Spinner) retView);
					} else if (f.getType() == WebView.class) {
						f.set(obj, (WebView) retView);
					} else if (f.getType() == ScrollView.class) {
						f.set(obj, (ScrollView) retView);
					}else if (f.getType()==ImageButton.class){
						f.set(obj, (ImageButton) retView);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}