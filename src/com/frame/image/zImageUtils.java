package com.frame.image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.apache.http.util.ByteArrayBuffer;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * @Title: zImageUtils.java
 * @Package com.frame.image
 * @Description: 图片转换类
 * @author Kelvin
 * @date: 2014年6月12日 下午2:53:40
 * @version 1.0
 */
public class zImageUtils {
	
//	测试提交
	
	
	
	public static byte[] bitmapToBytes(Bitmap bm) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.PNG,100,baos);
		return baos.toByteArray();
	}

	
	public static Bitmap bytesToBitmap(byte[] bytes) {
		if(bytes.length >0 ) {
			return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
		}
		return null;
	}
	
	public static InputStream bitmapToInputStream(Bitmap bm) {
		InputStream is =new ByteArrayInputStream(bitmapToBytes(bm));
		return is;
	}
	
	public static Drawable bitmapToDrawable(Bitmap bm) {
		BitmapDrawable bd = new BitmapDrawable(bm);
		return bd;
	}
	
	public static Drawable inputStreamToDrawable(InputStream is) {
		Bitmap bm =BitmapFactory.decodeStream(is);
		return bitmapToDrawable(bm);
	}
}
