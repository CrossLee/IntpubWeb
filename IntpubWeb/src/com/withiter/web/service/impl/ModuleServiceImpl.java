/*
 * Created on 2012-7-14
 *
 * ModuleServiceImpl.java
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
package com.withiter.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.withiter.web.dao.ModuleDao;
import com.withiter.web.dao.PartDao;
import com.withiter.web.dto.ModuleDTO;
import com.withiter.web.dto.PartDTO;
import com.withiter.web.service.ModuleService;
import com.withiter.web.util.ConstantUtil;

public class ModuleServiceImpl implements ModuleService {

	private ModuleDao moduleDao;
	
	private PartDao partDao;

	public List<ModuleDTO> queryAllModules() throws Exception {
		
		ModuleDTO condition  = new ModuleDTO();
//		module.setStatus(ConstantUtil.Status.STATE_DISPLAY);
		List<Integer> status = new ArrayList<Integer>();
		status.add(ConstantUtil.Status.STATE_DISPLAY);
		
		List<ModuleDTO> modules = moduleDao.queryModulesByCondition(condition,status);
		
		return modules;
	}
	
	public ModuleDao getModuleDao() {
		return moduleDao;
	}

	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	public PartDao getPartDao() {
		return partDao;
	}

	public void setPartDao(PartDao partDao) {
		this.partDao = partDao;
	}
}
