package com.frame.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

/**
 * @Title: zShellUtils.java
 * @Package com.frame.utils
 * @Description: linux命令行工具类
 * @author Kelvin
 * @date: 2014年6月12日 下午2:51:17
 * @version 1.0
 */
public class zShellUtils {
	
	public static final String COMMAND_SU       = "su";
    public static final String COMMAND_SH       = "sh";
    public static final String COMMAND_EXIT     = "exit\n";
    public static final String COMMAND_LINE_END = "\n";

	public static class CommandResult {
		public int result;
		
		public String successMsg;
		
		public String errorMsg;
		
		public CommandResult(int result) {
			this.result=result;
		}
		
		public CommandResult(int result,String successMsg,String errorMsg) {
			this.result=result;
			this.successMsg=successMsg;
			this.errorMsg=errorMsg;
		}
	}
	
	/**
	 * 
	* @Title: execCommand 
	* @Description: 命令行执行命令。
	* @param @param commands
	* @param @param isRoot true表示在root用户下执行
	* @param @param isNeedResultMsg true表示需要执行结果
	* @param @return    设定文件 
	* @return CommandResult    返回类型 
	* @throws
	 */
	public static CommandResult execCommand(String[] commands, boolean isRoot,boolean isNeedResultMsg) {
		int result = -1;
		if(zStringUtils.isEmpty(commands)) {
			return new CommandResult(result);
		}else {
			Process process=null;
			BufferedReader successResult = null;
			BufferedReader errorResult = null;
			StringBuilder successMsg = null;
			StringBuilder errorMsg = null;
			DataOutputStream dos = null;
			try {
				process = Runtime.getRuntime().exec(isRoot ? COMMAND_SU : COMMAND_SH);
				dos = new DataOutputStream(process.getOutputStream());
				for (String command : commands) {
	                if (command == null) {
	                    continue;
	                }
	                dos.write(command.getBytes());
	                dos.writeBytes(COMMAND_LINE_END);
	                dos.flush();
	            }
	            dos.writeBytes(COMMAND_EXIT);
	            dos.flush();
	            result = process.waitFor();
	            if (isNeedResultMsg) {
	            	successMsg = new StringBuilder();
	            	errorMsg = new StringBuilder();
	            	successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
	                errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
	                String s;
	                while ((s = successResult.readLine()) != null) {
	                    successMsg.append(s);
	                }
	                while ((s = errorResult.readLine()) != null) {
	                    errorMsg.append(s);
	                }
	            }
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (dos != null) {
	                    dos.close();
	                }
	                if (successResult != null) {
	                    successResult.close();
	                }
	                if (errorResult != null) {
	                    errorResult.close();
	                }
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				if(process != null) {
					process.destroy();
				}
			}
			return new CommandResult(result, successMsg == null ? null : successMsg.toString(), errorMsg == null ? null
		            : errorMsg.toString());
		}
	}
	
	/**
	 * 
	* @Title: checkRootPermission 
	* @Description: 判断是否能在root用户下执行命令
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean checkRootPermission() {
        return execCommand("echo root", true, false).result == 0;
    }
	
	public static CommandResult execCommand(String command, boolean isRoot,boolean isNeedResultMsg) {
        return execCommand(new String[] { command }, isRoot, isNeedResultMsg);
    }
}
