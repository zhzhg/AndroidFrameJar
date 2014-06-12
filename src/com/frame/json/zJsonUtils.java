package com.frame.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.frame.utils.zStringUtils;


/**   
 * @Title: JsonUtils.java 
 * @Description: json工具类
 * @author zhzhg  
 * @version V1.0   
 */

public class zJsonUtils {

	
	public static long getLong(JSONObject object,String key,long defaultValue) {
		if(object == null || zStringUtils.isEmpty(key)) {
			return defaultValue;
		}else {
			try {
				if(!object.isNull(key)) {
					return object.getLong(key);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
			return defaultValue;
		}
	}
	
	
	public static long getLong(String json,String key,long defaultValue) {
		if(zStringUtils.isEmpty(json)) {
			return defaultValue;
		}else {
			try {
				JSONObject object=new JSONObject(json);
				return getLong(object, key, defaultValue);
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
		}
	}
	
	public static int getInt(JSONObject object,String key,int defaultValue) {
		if(object == null || zStringUtils.isEmpty(key)) {
			return defaultValue;
		}else {
			try {
				if(!object.isNull(key)) {
					return object.getInt(key);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
			return defaultValue;
		}
	}
	
	public static int getInt(String json,String key,int defaultValue) {
		if(zStringUtils.isEmpty(json)) {
			return defaultValue;
		}else {
			try {
				JSONObject object=new JSONObject(json);
				return getInt(object, key, defaultValue);
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
		}
	}
	
	public static String getString(JSONObject object,String key,String defaultValue) {
		if(object == null || zStringUtils.isEmpty(key)) {
			return defaultValue;
		}else {
			try {
				if(!object.isNull(key)) {
					return object.getString(key);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
			return defaultValue;
		}
	}
	
	public static String getString(String json,String key,String defaultValue) {
		if(zStringUtils.isEmpty(json)) {
			return defaultValue;
		}else {
			try {
				JSONObject object=new JSONObject(json);
				return getString(object, key, defaultValue);
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
		}
	}
	
	public static double getDouble(JSONObject object,String key,double defaultValue) {
		if(object == null || zStringUtils.isEmpty(key)) {
			return defaultValue;
		}else {
			try {
				if(!object.isNull(key)) {
					return object.getDouble(key);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
			return defaultValue;
		}
	}
	
	public static double getDouble(String json,String key,double defaultValue) {
		if(zStringUtils.isEmpty(json)) {
			return defaultValue;
		}else {
			try {
				JSONObject object=new JSONObject(json);
				return getDouble(object, key, defaultValue);
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
		}
	}
	
	public static boolean getBoolean(JSONObject object,String key,boolean defaultValue) {
		if(object == null || zStringUtils.isEmpty(key)) {
			return defaultValue;
		}else {
			try {
				if(!object.isNull(key)) {
					return object.getBoolean(key);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
			return defaultValue;
		}
	}
	
	public static boolean getBoolean(String json,String key,boolean defaultValue) {
		if(zStringUtils.isEmpty(json)) {
			return defaultValue;
		}else {
			try {
				JSONObject object=new JSONObject(json);
				return getBoolean(object, key, defaultValue);
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
		}
	}
	
	public static JSONArray getJSONArray(JSONObject object,String key,JSONArray defaultValue) {
		if(object == null || zStringUtils.isEmpty(key)) {
			return defaultValue;
		}else {
			try {
				if(!object.isNull(key)) {
					return object.getJSONArray(key);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
			return defaultValue;
		}
	}
	
	public static JSONArray getJSONArray(String json,String key,JSONArray defaultValue) {
		if(zStringUtils.isEmpty(json)) {
			return defaultValue;
		}else {
			try {
				JSONObject object=new JSONObject(json);
				return getJSONArray(object, key, defaultValue);
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
		}
	}
	
	public static JSONObject getJSONObject(JSONObject object,String key,JSONObject defaultValue) {
		if(object == null || zStringUtils.isEmpty(key)) {
			return defaultValue;
		}else {
			try {
				if(!object.isNull(key)) {
					return object.getJSONObject(key);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
			return defaultValue;
		}
	}
	
	public static JSONObject getJSONObject(String json,String key,JSONObject defaultValue) {
		if(zStringUtils.isEmpty(json)) {
			return defaultValue;
		}else {
			try {
				JSONObject object=new JSONObject(json);
				return getJSONObject(object, key, defaultValue);
			} catch (JSONException e) {
				e.printStackTrace();
				return defaultValue;
			}
		}
	}
}
