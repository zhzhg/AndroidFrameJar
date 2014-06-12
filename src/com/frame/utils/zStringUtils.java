package com.frame.utils;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @Title: zStringUtils.java
 * @Package com.frame.utils
 * @Description: 字符串工具类
 * @author Kelvin
 * @date: 2014年6月12日 下午2:52:00
 * @version 1.0
 */
public class zStringUtils {

	/**
	 * 
	 * @Title: isEmpty
	 * @Description: 判断字符串是否为空
	 * @param @param str
	 * @param @return 设定文件
	 * @return boolean 为空返回true，不为空返回false
	 * @throws
	 */
	public static boolean isEmpty(String str) {
		return (str == null || str.trim().length() == 0);
	}

	public static boolean isEmpty(String[] strArray) {
		return (strArray == null || strArray.length == 0);
	}

	/**
	 * 
	 * @Title: encodeString
	 * @Description: 对参数编码
	 * @param @param str
	 * @param @param encode
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String encodeString(String str, String encode) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				str = URLEncoder.encode(str, encode);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: nullStringToEmpty
	 * @Description: 把NULL字符串转成空
	 * @param @param str
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String nullStringToEmpty(String str) {
		return str == null ? "" : str;
	}

	/**
	 * 
	 * @Title: capitalizeFirstLetter
	 * @Description: 首字母大写
	 * @param @param str
	 * @param @param isUpperCase true转换首字母是大写，false是转换首字母是小写。
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String capitalizeFirstLetter(String str, boolean isUpperCase) {
		if (!isEmpty(str)) {
			char c = str.charAt(0);
			if (isUpperCase) {
				str = (!Character.isLetter(c) || Character.isUpperCase(c)) ? str
						: new StringBuilder(str.length())
								.append(Character.toUpperCase(c))
								.append(str.substring(1)).toString();
			} else {
				str = (!Character.isLetter(c) || Character.isLowerCase(c)) ? str
						: new StringBuilder(str.length())
								.append(Character.toLowerCase(c))
								.append(str.substring(1)).toString();
			}
		}
		return str;
	}

	/**
	 * 
	 * @Title: htmlEscapeCharsToString
	 * @Description: 替换特殊字符
	 * @param @param str
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String htmlEscapeCharsToString(String str) {
		if (!isEmpty(str)) {
			str = str.replaceAll("&lt;", "<").replaceAll("&gt;", ">")
					.replaceAll("&amp;", "&").replaceAll("&quot;", "\"");
		}
		return str;
	}

	public static String urlToLink(String urlText) {
		// 匹配的条件选项为结束为空格(半角和全角)、换行符、字符串的结尾或者遇到其他格式的文本
		String regexp = "(((http|ftp|https|file)://)|((?<!((http|ftp|https|file)://))www\\.))" // 以http...或www开头
				+ ".*?" // 中间为任意内容，惰性匹配
				+ "(?=(&nbsp;|\\s|　|<br />|$|[<>]))"; // 结束条件
		Pattern pattern = Pattern.compile(regexp, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(urlText);
		StringBuffer stringbuffer = new StringBuffer();
		while (matcher.find()) {
			String url = matcher.group().substring(0, 3).equals("www") ? "http://"
					+ matcher.group()
					: matcher.group();
			String tempString = "<a href=\"" + url + "\">" + matcher.group()
					+ "</a>";
			// 这里对tempString中的"\"和"$"进行一次转义，因为下面对它替换的过程中appendReplacement将"\"和"$"作为特殊字符处理
			int tempLength = tempString.length();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < tempLength; ++i) {
				char c = tempString.charAt(i);
				if (c == '\\' || c == '$') {
					buffer.append("\\").append(c);
				} else {
					buffer.append(c);
				}
			}
			tempString = buffer.toString();
			matcher.appendReplacement(stringbuffer, tempString);
		}
		matcher.appendTail(stringbuffer);
		return stringbuffer.toString();
	}

}
