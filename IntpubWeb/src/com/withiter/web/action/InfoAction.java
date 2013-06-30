/*
 * Created on 2012-7-22
 *
 * InfoAction.java
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
package com.withiter.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.withiter.web.dto.InfoDTO;
import com.withiter.web.service.InfoService;
import com.withiter.web.util.ConstantUtil.HtmlUrl;
import com.withiter.web.util.HtmlUtil;

public class InfoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 213758900077551456L;
	
	private String infoId;
	private String publishDate;
	private String flag;
	private String forwardHtmlUrl;
 	private InfoService infoService;
 	private InfoDTO info;
	public String view(){
		String strs[]= publishDate.split("-");
		publishDate=strs[0]+strs[1]+strs[2];
		if(flag.equals("1")){
			info=infoService.queryInfo(Integer.parseInt(infoId));
			return "view";
		}else{
			if(create()){
				forwardHtmlUrl="/"+publishDate+"/"+publishDate+infoId+".html";
				return "viewHtml";
			}else{
				info=infoService.queryInfo(Integer.parseInt(infoId));
				return "view";
			}
		}
		
	}
	
	public boolean create(){
		HtmlUtil htmlUtil=new HtmlUtil();
		String url=ServletActionContext.getRequest().getRequestURL()+"?flag=1&publishDate="+publishDate+"&infoId="+infoId;
		System.out.println(url);
		return htmlUtil.isExists(url,publishDate, infoId);
	}
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getForwardHtmlUrl() {
		return forwardHtmlUrl;
	}

	public void setForwardHtmlUrl(String forwardHtmlUrl) {
		this.forwardHtmlUrl = forwardHtmlUrl;
	}

	public InfoDTO getInfo() {
		return info;
	}

	public void setInfo(InfoDTO info) {
		this.info = info;
	}

	public InfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	public String getInfoId() {
		return infoId;
	}
	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	
}
