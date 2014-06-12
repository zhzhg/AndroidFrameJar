package com.frame.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.content.Context;


/**   
 * @Title: zAssetsResourceUtils.java 
 * @Description: assets工具类
 * @author zhzhg
 * @version V1.0   
 */

public class zAssetsResourceUtils {

	public static String geFileFromAssets(Context context,String fileName) {
		if(context == null || zStringUtils.isEmpty(fileName)) {
			return null;
		}else {
			StringBuilder sb=new StringBuilder();
			try {
				InputStreamReader in = new InputStreamReader(context.getResources().getAssets().open(fileName));
	            BufferedReader br = new BufferedReader(in);
	            String line;
	            while ((line = br.readLine()) != null) {
	                sb.append(line);
	            }
			}catch(Exception e) {
				e.printStackTrace();
			}
			return sb.toString();
		}
	}
	
	
	public static String geFileFromRaw(Context context,int resId) {
		if(context == null) {
			return null;
		}else {
			StringBuilder sb = new StringBuilder();
			try{
				InputStreamReader in = new InputStreamReader(context.getResources().openRawResource(resId));
	            BufferedReader br = new BufferedReader(in);
	            String line;
	            while ((line = br.readLine()) != null) {
	                sb.append(line);
	            }
			}catch(Exception e) {
				e.printStackTrace();
			}
			return sb.toString();
		}
	}
}
