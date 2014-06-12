package com.frame.image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**   
 * @Title: CompressImage.java 
 * @Description: 图片压缩类
 * @author zhzhg  
 * @version V1.0   
 */

public class zCompressImage {

	/**
	 * 压缩图片
	 * @param filePath 图片路径
	 * @param targetWidth 期望图片宽
	 * @param targetHeight 期望图片高
	 * @param maxsize 图片最大大小KB
	 * @return
	 */
	public static InputStream compressImage(String filePath,int targetWidth,int targetHeight,int maxSize) {
		InputStream is=null;
		try {
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inJustDecodeBounds = true;
			BitmapFactory.decodeFile(filePath, options);
			int height = options.outHeight;
			int width = options.outWidth; 
			options.inJustDecodeBounds=false;
			 int inSampleSize=1;
		    if(width > height && width >targetWidth) {
		    	inSampleSize = (int)(width / targetWidth);
		    }else if(width < height && height > targetHeight) {
		    	inSampleSize = (int)(height/ targetHeight);
		    }
		    if(inSampleSize <= 0) {
		    	inSampleSize =1;
		    }
		    options.inSampleSize = inSampleSize;
		    Bitmap bitmap= BitmapFactory.decodeFile(filePath, options);
		    is=compressQuality(bitmap, maxSize);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return is;
	}
	
	/**
	 * 压缩图片
	 * @param image 图片路径
	 * @param targetWidth 期望图片宽
	 * @param targetHeight 期望图片高
	 * @param maxsize 图片最大大小KB
	 * @return
	 */
	public static InputStream compressImage(Bitmap image,int targetWidth,int targetHeight,int maxSize) {
		InputStream is=null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();         
		    image.compress(Bitmap.CompressFormat.JPEG, 100, baos); 
		    ByteArrayInputStream isBm = new ByteArrayInputStream(baos.toByteArray());
		    BitmapFactory.Options options = new BitmapFactory.Options();
		    options.inJustDecodeBounds = true;
		    Bitmap bitmap = BitmapFactory.decodeStream(isBm, null, options); 
		    int height = options.outHeight;
			int width = options.outWidth; 
			options.inJustDecodeBounds=false;
			int inSampleSize=1;
		    if(width > height && width >targetWidth) {
		    	inSampleSize = (int)(width / targetWidth);
		    }else if(width < height && height > targetHeight) {
		    	inSampleSize = (int)(height/ targetHeight);
		    }
		    if(inSampleSize <= 0) {
		    	inSampleSize =1;
		    }
		    options.inSampleSize = inSampleSize;
		    isBm = new ByteArrayInputStream(baos.toByteArray());  
		    bitmap= BitmapFactory.decodeStream(isBm,null,options);
		    is=compressQuality(bitmap, maxSize);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return is;
	}
	
	
	private static InputStream compressQuality(Bitmap image,int maxSize) {
		ByteArrayInputStream bais=null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			image.compress(Bitmap.CompressFormat.JPEG, 100,baos);
			int quality=100;
			while(baos.toByteArray().length /1024 >maxSize) {
				quality-=10;
				baos.reset();
				image.compress(Bitmap.CompressFormat.JPEG, quality, baos);
			}
			 bais= new ByteArrayInputStream(baos.toByteArray());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return bais;
	}
}
