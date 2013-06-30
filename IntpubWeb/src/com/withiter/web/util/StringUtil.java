/*
 * Created on 2012-4-20
 *
 * StringUtil.java
 *
 * Copyright (C) 2012 by Withiter Software & Technology Services (Shanghai) Limited.
 * All rights reserved. Withiter Software & Technology Services (Shanghai) Limited 
 * claims copyright in this computer program as an unpublished work. Claim of copyright 
 * does not imply waiver of other rights.
 *
 * NOTICE OF PROPRIETARY RIGHTS
 *
 * This program is a confidential trade secret and the property of 
 * Withiter Software & Technology Services (Shanghai) Limited. Use, examination, 
 * reproduction, disassembly, decompiling, transfer and/or disclosure to others of 
 * all or any part of this software program are strictly prohibited except by express 
 * written agreement with Withiter Software & Technology Services (Shanghai) Limited.
 */
/*
 * ---------------------------------------------------------------------------------
 * Modification History
 * Date               Author                     Version     Description
 * 2012-4-20       Administrator                    1.0         New
 * ---------------------------------------------------------------------------------
 */
package com.withiter.web.util;

public class StringUtil {
	/**
	 * @param str
	 * @return 处理为null的字符串
	 */
	public static String emptyToString(String str){
		if(str==null){
			str="";
		}
		
		return str;
	}
	/**
	 * @param str 字符�?
	 * @param defaultValue 默认�?
	 * @return 处理空字符串
	 */
	public static String toParameterStr(String str,String defaultValue){
		if(str==null){
			return str;
		}else{
			return defaultValue;
		}
	}
	
	/**
	 * @param obj 对象类型
	 * @param defaultValue
	 * @return 对象不为空则转为字符串否则返回默认�?
	 */
	public static String toParameterStr(Object obj,String defaultValue){
		if(obj!=null){
			return obj.toString();
		}else{
			return defaultValue;
		}
	}
}
