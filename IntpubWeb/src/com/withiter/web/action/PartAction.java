/*
 * Created on 2012-7-19
 *
 * PartAction.java
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
 * 2012-7-19       Administrator                    1.0         New
 * ---------------------------------------------------------------------------------
 */
package com.withiter.web.action;

import java.util.ArrayList;
import java.util.List;

import com.withiter.web.dto.InfoDTO;
import com.withiter.web.dto.PartDTO;
import com.withiter.web.service.PartService;
import com.withiter.web.util.ConstantUtil;

public class PartAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3984379833985376413L;
	
	
	private PartService partService;
	
	private List<PartDTO> parts;
	
	private String selectedModuleCode;
	
	private String partState;
	
	private String selectedPartCode;
	
	private List<InfoDTO> infos;
	
	private PartDTO selectedPart;
	
	public String queryPartsByModuleCode()
	{
		
		try {
			List<Integer> status = new ArrayList<Integer>();
			status.add(ConstantUtil.Status.STATE_DISPLAY);
			parts = partService.queryPartsModuleCode(selectedModuleCode,status);
			partState = SUCCESS;
		} catch (Exception e) {
			partState = ERROR;
			return ERROR;
		}
		
		return "partObj";
	}

	public String queryInfosByPartCode()
	{
		
		try {
			List<Integer> status = new ArrayList<Integer>();
			status.add(ConstantUtil.Status.STATE_DISPLAY);
			infos = partService.queryInfosByPartCode(selectedPartCode,status);
			selectedPart = partService.queryPartById(selectedPartCode);
			partState = SUCCESS;
		} catch (Exception e) {
			partState = ERROR;
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	public PartService getPartService() {
		return partService;
	}

	public void setPartService(PartService partService) {
		this.partService = partService;
	}

	public List<PartDTO> getParts() {
		return parts;
	}

	public void setParts(List<PartDTO> parts) {
		this.parts = parts;
	}

	public String getSelectedModuleCode() {
		return selectedModuleCode;
	}

	public void setSelectedModuleCode(String selectedModuleCode) {
		this.selectedModuleCode = selectedModuleCode;
	}

	public String getPartState() {
		return partState;
	}

	public void setPartState(String partState) {
		this.partState = partState;
	}

	public String getSelectedPartCode() {
		return selectedPartCode;
	}

	public void setSelectedPartCode(String selectedPartCode) {
		this.selectedPartCode = selectedPartCode;
	}

	public List<InfoDTO> getInfos() {
		return infos;
	}

	public void setInfos(List<InfoDTO> infos) {
		this.infos = infos;
	}

	public PartDTO getSelectedPart() {
		return selectedPart;
	}

	public void setSelectedPart(PartDTO selectedPart) {
		this.selectedPart = selectedPart;
	}
}
