package com.frame.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;

import android.util.Log;

/**
 * @Title: zFileUtils.java
 * @Package com.frame.utils
 * @Description: 文件工具类
 * @author Kelvin
 * @date: 2014年6月12日 下午2:42:24
 * @version 1.0
 */
public class zFileUtils {

	/**
	 * 
	 * @Title: readFile
	 * @Description: 读取文件内容
	 * @param @param filePath
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String readFile(String filePath) {
		File file = new File(filePath);
		StringBuilder fileContent = new StringBuilder("");
		if (file == null || !file.isFile()) {
			return fileContent.toString();
		}
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (!fileContent.toString().equals("")) {
					fileContent.append("\r\n");
				}
				fileContent.append(line);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return fileContent.toString();
	}
	
	/**
	 * 读取文件
	 * @param filePath
	 * @return
	 */
	public static InputStream readFileInputStream(String filePath) {
		InputStream is = null;
		try {
			is = new FileInputStream(filePath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return is;
	}

	/**
	 * 
	 * @Title: writeFile
	 * @Description: 写文件
	 * @param @param filePath
	 * @param @param content
	 * @param @param append
	 * @param @return true表示成功
	 * @return boolean 返回类型
	 * @throws
	 */
	public static boolean writeFile(String filePath,String fileName, String content, boolean append) {
		FileWriter fileWriter = null;
		boolean result = false;
		if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			try {

				File file = new File(filePath);
				if (!file.exists()) {
					file.mkdirs();
				}
				Log.i("file", filePath);
				fileWriter = new FileWriter(filePath+fileName, append);
				fileWriter.write(content);
				result = true;
			} catch (Exception e) {
				e.printStackTrace();
				Log.i("file", e.toString());
			} finally {
				if (fileWriter != null) {
					try {
						fileWriter.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
		return result;
	}
	
	

	public static boolean writeFile(String filePath, InputStream inputStream, boolean append) {
		OutputStream o = null;
		boolean result = false;
		try {
			o = new FileOutputStream(filePath);
			byte data[] = new byte[1024];
			int length = -1;
			while ((length = inputStream.read(data)) != -1) {
				o.write(data, 0, length);
			}
			o.flush();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (o != null) {
				try {
					o.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		return result;
	}
	/**
	 * 
	 * @Title: getFileNameWithoutPath
	 * @Description: 根据文件路径获取文件名称,不含后缀
	 * @param @param filePath
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String getFileNameWithoutExtension(String filePath) {
		if (!zStringUtils.isEmpty(filePath)) {
			int extenPosi = filePath.lastIndexOf(".");
			int filePosi = filePath.lastIndexOf(File.separator);
			if (filePosi == -1) {
				filePath = (extenPosi == -1 ? filePath : filePath.substring(0, extenPosi));
			}
			if (extenPosi == -1) {
				filePath = filePath.substring(filePosi + 1);
			}
			filePath = (filePosi < extenPosi ? filePath.substring(filePosi + 1, extenPosi) : filePath.substring(filePosi + 1));
		}
		return filePath;
	}

	public static String getFileName(String filePath) {
		if (!zStringUtils.isEmpty(filePath)) {
			int filePosi = filePath.lastIndexOf(File.separator);
			filePath = (filePosi == -1) ? filePath : filePath.substring(filePosi + 1);
		}
		return filePath;
	}

	public static String getFilePath(String filePath) {
		if (!zStringUtils.isEmpty(filePath)) {
			return filePath.substring(0, filePath.lastIndexOf(File.separator)) + "/";
		}
		return filePath;
	}

	/**
	 * 删除指定目录下所有文件
	 * 
	 * @param filePath
	 *            删除文件路径
	 */
	public static void deleteAllFile(final String filePath) {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					File display = new File(filePath);
					if (!display.exists()) {
						return;
					}
					File[] items = display.listFiles();
					int i = display.listFiles().length;
					for (int j = 0; j < i; j++) {
						if (items[j].isFile()) {
							items[j].delete();// 删除文件
						} else {
							// 迭代删除
							deleteAllFile(items[j].getAbsolutePath());
							// 删除目录
							items[j].delete();
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});
		t.start();
	}
}
