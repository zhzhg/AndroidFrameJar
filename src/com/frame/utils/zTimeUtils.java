package com.frame.utils;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.widget.SimpleAdapter;

/**
 * @Title: zTimeUtils.java
 * @Package com.frame.utils
 * @Description: 时间工具类
 * @author Kelvin
 * @date: 2014年6月12日 下午2:52:33
 * @version 1.0
 */
public class zTimeUtils {

	/**
	 * 格式化时间
	 * 
	 * @param indate
	 *            初始时间
	 * @param MaskStr
	 *            比如“yyyy-MM-dd HH:mm:ss ”
	 * @return
	 */
	public static String formatDateStr(Date date, String MaskStr) {
		String retStr = "";
		try {
			SimpleDateFormat sdf = null;
			sdf = new SimpleDateFormat(MaskStr);
			retStr = sdf.format(date);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return retStr;
	}

	/**
	 * 判断指定的时间是出于哪个时间段 格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param nTime
	 *            指定的时间
	 * @return 今天:today 昨天：yesterday 以前:before;
	 */

	public static String parseDate(String nTime) {
		try {
			String ret = "";
			SimpleDateFormat sdf = null;
			if (nTime.length() == 19) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			} else if (nTime.length() == 16) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			} else if (nTime.length() == 13) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH");
			} else if (nTime.length() == 10) {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			}
			long create = sdf.parse(nTime).getTime();
			Calendar now = Calendar.getInstance();
			long ms = 1000 * (now.get(Calendar.HOUR_OF_DAY) * 3600
					+ now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND));// 毫秒数
			long ms_now = now.getTimeInMillis();
			if (ms_now - create < ms) {
				ret = "today";
			} else if (ms_now - create < (ms + 24 * 3600 * 1000)) {
				ret = "yesterday";
			} else {
				ret = "before";
			}
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 计算指定时间是否在开始时间之前 格式是 yyyy-MM-dd 到 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 *            指定时间
	 * @param starttime
	 *            开始时间
	 * @return boolean
	 */
	public static boolean isBeforeTime(String time, String starttime) {
		try {
			SimpleDateFormat simpleDateFormat = null;
			if (time.length() == 19) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			} else if (time.length() == 16) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			} else if (time.length() == 13) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
			} else if (time.length() == 10) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			}

			Date sysTime = simpleDateFormat.parse(time); // 指定时间
			Date startTime = simpleDateFormat.parse(starttime); // 开始时间
			// 如果处于开始和结束时间之间，则返回true
			if (sysTime.before(startTime)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 计算指定时间是否在结束时间之后 yyyy-MM-dd 到 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 *            指定时间
	 * @param endtime
	 *            结束时间
	 * @return boolean
	 */
	public static boolean isAfterTime(String time, String endtime) {
		try {
			SimpleDateFormat simpleDateFormat = null;
			if (time.length() == 19) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			} else if (time.length() == 16) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			} else if (time.length() == 13) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
			} else if (time.length() == 10) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			}

			Date sysTime = simpleDateFormat.parse(time); // 指定时间
			Date endTime = simpleDateFormat.parse(endtime); // 结束时间
			// 如果处于开始和结束时间之间，则返回true
			if (sysTime.after(endTime)) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 计算指定时间是否在开始和结束时间之间 yyyy-MM-dd 到 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param time
	 *            指定时间
	 * @param endtime
	 *            结束时间
	 * @param starttime
	 *            开始时间
	 * @return boolean
	 */
	public static boolean isBetweenTime(String time, String starttime,
			String endtime) {

		try {
			SimpleDateFormat simpleDateFormat = null;
			if (time.length() == 19) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			} else if (time.length() == 16) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			} else if (time.length() == 13) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
			} else if (time.length() == 10) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			}

			Date sysTime = simpleDateFormat.parse(time); // 指定时间
			Date startTime = simpleDateFormat.parse(starttime); // 开始时间
			Date endTime = simpleDateFormat.parse(endtime); // 结束时间
			// 如果处于开始和结束时间之间，则返回true
			if (sysTime.after(startTime) && sysTime.before(endTime)) {
				return true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 计算指定时间是否在开始和结束时间之间 字符串类型的比较 比如20120101 到20120101123040
	 * 
	 * @param time
	 *            指定时间
	 * @param endtime
	 *            结束时间
	 * @param starttime
	 *            开始时间
	 * @return boolean
	 */
	public static boolean isBetweenTimeStr(String time, String starttime,
			String endtime) {
		try {
			BigInteger timeInt = new BigInteger(time);
			BigInteger starttimeInt = new BigInteger(starttime);
			BigInteger endttimeInt = new BigInteger(endtime);
			int compareResult = timeInt.compareTo(starttimeInt);
			if (compareResult == -1) {
				return false;
			} else if (compareResult == 0) {
				return true;
			} else if (compareResult == 1) {
				compareResult = timeInt.compareTo(endttimeInt);
				if (compareResult >= 0) {
					return false;
				} else {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
