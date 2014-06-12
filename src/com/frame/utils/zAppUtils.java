package com.frame.utils;

import java.io.File;

import com.frame.utils.zShellUtils.CommandResult;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;


/**   
 * @Title: AppUtils.java 
 * @Package com.cary.app 
 * @Description: 应用程序的工具类
 * @author zhzhg 
 * @version V1.0   
 */

public class zAppUtils {

	/**
	 * 
	* @Title: installApp 
	* @Description: 安装APP
	* @param @param filePath
	* @param @param context
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean installApp(String filePath,Context context) {
		if(isSystemApplication(context) || zShellUtils.checkRootPermission()) {
			return installSilent(context, filePath);
		}else {
			return installNormal(context, filePath);
		}
	}
	
	/**
	 * 
	* @Title: installNormal 
	* @Description: 正常安装APP
	* @param @param context
	* @param @param filePath
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean installNormal(Context context,String filePath) {
		Intent intent=new Intent(Intent.ACTION_VIEW);
		File file = new File(filePath);
		if (file == null || !file.exists() || !file.isFile() || file.length() <= 0) {
            return false;
        }else {
        	intent.setDataAndType(Uri.parse("file://" + filePath), "application/vnd.android.package-archive");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
        }
	}
	
	/**
	 * 
	* @Title: installSilent 
	* @Description: 静默安装
	* @param @param context
	* @param @param filePath
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean installSilent(Context context,String filePath) {
		if (filePath == null || filePath.length() == 0) {
            return false;
        }else {
        	File file = new File(filePath);
            if (file == null || file.length() <= 0 || !file.exists() || !file.isFile()) {
                return false;
            }else {
            	StringBuilder command = new StringBuilder().append("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm install -r ").append(filePath.replace(" ", "\\ "));
            	CommandResult commandResult = zShellUtils.execCommand(command.toString(), !isSystemApplication(context), true);
            	if (commandResult.successMsg != null && (commandResult.successMsg.contains("Success") || commandResult.successMsg.contains("success"))) {
                      return true;
                 }else {
                	 return false;
                 }
            }
        }
	}
	
	/**
	 * 
	* @Title: isSystemApplication 
	* @Description: 判断当前应用是否是系统应用。
	* @param @param context
	* @param @return    设定文件 
	* @return boolean    true表示系统应用，
	* @throws
	 */
	public static boolean isSystemApplication(Context context) {
		PackageManager packageManager=context.getPackageManager();
		String packageName=context.getPackageName();
		if(packageManager == null || zStringUtils.isEmpty(packageName)) {
			return false;
		}else {
			try {
				ApplicationInfo app = packageManager.getApplicationInfo(packageName, 0);
				return (app != null && (app.flags & ApplicationInfo.FLAG_SYSTEM) > 0);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean uninstall(Context context,String packageName,boolean isKeepData) {
		if(isSystemApplication(context) || zShellUtils.checkRootPermission()) {
			return uninstallSilent(context, packageName, isKeepData);
		}else {
			return uninstallNormal(context, packageName);
		}
	}
	
	
	public static boolean uninstallNormal(Context context,String packageName) {
		if(zStringUtils.isEmpty(packageName)) {
			return false;
		}else {
			Intent intent = new Intent(Intent.ACTION_DELETE, Uri.parse(new StringBuilder(32).append("package:").append(packageName).toString()));
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);
			return true;
		}
	}
	
	/**
	 * 
	* @Title: uninstallSilent 
	* @Description: 静默卸载
	* @param @param context
	* @param @param packageName
	* @param @param isKeepData
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean uninstallSilent(Context context,String packageName,boolean isKeepData) {
		if(zStringUtils.isEmpty(packageName)) {
			return false;
		}else {
			StringBuilder command = new StringBuilder().append("LD_LIBRARY_PATH=/vendor/lib:/system/lib pm uninstall")
                    .append(isKeepData ? " -k " : " ")
                    .append(packageName.replace(" ", "\\ "));
			CommandResult commandResult = zShellUtils.execCommand(command.toString(), !isSystemApplication(context), true);
	        if (commandResult.successMsg != null
	            && (commandResult.successMsg.contains("Success") || commandResult.successMsg.contains("success"))) {
	            return true;
	        }else {
	        	return false;
	        }
		}
	}
}
