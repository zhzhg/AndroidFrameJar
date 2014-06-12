package com.frame.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

/**   
 * @Title: PhonePhotoUtils.java 
 * @Package com.zm.utils 
 * @Description: 获取手机相册 
 * @author zhzhg   
 * @version V1.0   
 */

public class zPhonePhotoUtils {
	
	public static String getPath(Context context,Uri uri) {
		String path="";
		if(Build.VERSION.SDK_INT >= 19) {
			String uriPath = uri.getPath();
			String id=uriPath.substring(uriPath.lastIndexOf("/")+1, uriPath.length());
			String[] split = id.split(":");
			String type = split[0];
			Uri contentUri = null;
            if ("image".equals(type)) {
                contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(type)) {
                contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(type)) {
                contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            String selection = "_id=?";
            String[] selectionArgs = new String[] {split[1]};
    	    Cursor cursor = null;
    	    String column = "_data";
    	    String[] projection = {column};
    	    try {
    	        cursor = context.getContentResolver().query(contentUri, projection, selection, selectionArgs,null);
    	        if (cursor != null && cursor.moveToFirst()) {
    	            int index = cursor.getColumnIndexOrThrow(column);
    	            path=cursor.getString(index);
    	        }
    	    } finally {
    	        if (cursor != null)
    	            cursor.close();
    	    }
		}else {
			String[] proj = { MediaStore.Images.Media.DATA };
			Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);
			if (cursor != null) {
				int column_index = cursor
						.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
				cursor.moveToFirst();
				path = cursor.getString(column_index);
			}
		}
		return path;
	}
	
}
