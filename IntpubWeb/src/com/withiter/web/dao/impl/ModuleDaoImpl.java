/*
 * Created on 2012-7-14
 *
 * ModuleDaoImpl.java
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
package com.withiter.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.withiter.web.dao.ModuleDao;
import com.withiter.web.dto.ModuleDTO;
import com.withiter.web.util.FetchData;

public class ModuleDaoImpl implements ModuleDao {

	public List<ModuleDTO> queryModulesByCondition(ModuleDTO condition,
			List<Integer> status) throws Exception {
		
		List<ModuleDTO> modules = new ArrayList<ModuleDTO>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select m.moduleCode,m.moduleName,m.status,m.profile,m.amount,m.displayLen,m.createby,m.createdate,m.updateby,m.updatedate from intpub_module m where 1=1 ");
		
		if (null != condition.getModuleCode() && !"".equals(condition.getModuleCode())) {
			sql.append("and m.moduleCode = '" + condition.getModuleCode() + "' ");
		}
		
		if (null != condition.getModuleName() && !"".equals(condition.getModuleName())) {
			sql.append("and m.moduleName like '%" + condition.getModuleName() + "%' ");
		}
		if (null != condition.getDescription() && !"".equals(condition.getDescription())) {
			sql.append("and m.profile like '%" + condition.getDescription() + "%' ");
		}
		
		if (null != status && !status.isEmpty()) {
			sql.append(" and m.status in (");
			
			for (int i = 0; i < status.size(); i++) {
				if (i == status.size()-1) {
					sql.append(status.get(i));
				}
				else
				{
					sql.append(status.get(i) + ",");
				}
			}
			
			sql.append(")");
		}
		
		List<List<String>> moduleData = FetchData.getListData(sql.toString());
		ModuleDTO module = null;
		if(null != moduleData && !moduleData.isEmpty())
		{
			for(List<String> list : moduleData)
			{
				module = new ModuleDTO();
				module.setModuleCode(list.get(0));
				module.setModuleName(list.get(1));
				module.setStatus(Integer.valueOf(list.get(2)));
				module.setDescription(list.get(3));
				module.setAmount(Integer.valueOf(list.get(4)));
				module.setDisplayLen(Integer.valueOf(list.get(5)));
				module.setCreatedBy(list.get(6));
				module.setCreatedDate(list.get(7));
				module.setUpdatedBy(list.get(8));
				module.setUpdatedDate(list.get(9));
				modules.add(module);
			}
		}
	
		return modules;
	}

	
}
