/*
 * Created on 2012-7-22
 *
 * HtmlUtil.java
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
 * 2012-7-22       Administrator                    1.0         New
 * ---------------------------------------------------------------------------------
 */
package com.withiter.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HtmlUtil {
  
	public boolean isExists(String jspUrl,String dateStr,String id){
		String savePath=ConstantUtil.HtmlUrl.HTML_URL+"/"+dateStr;
		String htmlName=dateStr+id+".html";
		File file=new File(savePath);
		if(file.exists()){
			file=new File(savePath+"/"+htmlName);
			if(file.exists()){
				return true;
			}else{
				
				return createHtml(jspUrl,"UTF-8",savePath,htmlName);
			}
		}else{
			file.mkdir();
			return createHtml(jspUrl,"UTF-8",savePath,htmlName);
		}
		
	}
	
	
	private  boolean createHtml(String sUrl, String charset, String savePath, String htmlFile){
		int responseCode;
		try {
			URL url=new URL(sUrl);
			//URLConnection urlConn=url.openConnection();
			//urlConn.connect();
		    //HttpURLConnection httpConn = (HttpURLConnection) urlConn;
		    
		    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		    httpConn.setRequestMethod("POST");
		    httpConn.setDoOutput(true);
		    
		    responseCode=httpConn.getResponseCode();
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		    	 	InputStreamReader inReader = new InputStreamReader(httpConn.getInputStream(),charset);
		    	    BufferedReader in = new BufferedReader(inReader);
		    	    String inputLine;
		    	    if (!savePath.endsWith("/")) {
		    	        savePath += "/";
		    	    }
		    	    FileOutputStream out = new FileOutputStream(savePath + htmlFile);
		    	    while((inputLine = in.readLine()) != null) {
		    	        
		    	    	out.write(( inputLine).getBytes(charset));
		    	    }
		    	      
		    	    in.close();
		    	    out.close();
		    	    
		    	    return true;
		    }else{
		    	return false;
		    }
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		new HtmlUtil().isExists("","20120720", "20");
	}
}
