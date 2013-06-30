/*
 * Created on 2012-7-14
 *
 * ModuleAction.java
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
 * 2012-7-14       Administrator                    1.0         New
 * ---------------------------------------------------------------------------------
 */
package com.withiter.web.action;

import java.util.List;

import com.withiter.web.dto.ModuleDTO;
import com.withiter.web.service.ModuleService;

public class ModuleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 373445311595497440L;
	
	private ModuleService moduleService;
	
	private List<ModuleDTO> modules;
	
	private String moduleState;
	
	public String initIndexPage()
	{
		
		try {
			modules = moduleService.queryAllModules();
			moduleState = SUCCESS;
		} catch (Exception e) {
			moduleState = ERROR;
			return "moduleObj";
		}
		
		return "moduleObj";
	}

	public List<ModuleDTO> getModules() {
		return modules;
	}

	public void setModules(List<ModuleDTO> modules) {
		this.modules = modules;
	}

	public String getModuleState() {
		return moduleState;
	}

	public void setModuleState(String moduleState) {
		this.moduleState = moduleState;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
}
