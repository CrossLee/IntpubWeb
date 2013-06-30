/*
 * Created on 2012-5-23
 *
 * PartDaoImpl.java
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
 * 2012-5-23       Administrator                    1.0         New
 * ---------------------------------------------------------------------------------
 */
package com.withiter.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.withiter.web.dao.PartDao;
import com.withiter.web.dto.InfoDTO;
import com.withiter.web.dto.PartDTO;
import com.withiter.web.util.FetchData;

public class PartDaoImpl implements PartDao {


	@Override
	public List<PartDTO> queryPartsModuleCode(String selectedModuleCode, List<Integer> status)
			throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select ip.* from intpub_part ip, intpub_module_part imp where 1=1 ");
		if (null != selectedModuleCode && !"".equals(selectedModuleCode)) {
			sql.append(" and ip.partCode=imp.PARTCODE and imp.MODULECODE = '").append(selectedModuleCode).append("'");
		}
		
		if (null != status && !status.isEmpty()) {
			sql.append(" and ip.status in (");
			
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
		
		List<PartDTO> parts = new ArrayList<PartDTO>();
		List<List<String>> partData = FetchData.getListData(sql.toString());
		PartDTO part = null;
		for(List<String> list : partData)
		{
			part = new PartDTO();
			part.setPartCode(list.get(0));
			part.setPartName(String.valueOf(list.get(1)));
			part.setStatus(Integer.valueOf(list.get(2)));
			part.setBackup(String.valueOf(list.get(3)));
			part.setSort(Integer.valueOf(list.get(4)));
			part.setCreatedBy(String.valueOf(list.get(5)));
			part.setCreatedDate(String.valueOf(list.get(6)));
			part.setUpdatedBy(String.valueOf(list.get(7)));
			part.setUpdatedDate(String.valueOf(list.get(8)));
			parts.add(part);
		}
		
		return parts;
	}

	@Override
	public List<InfoDTO> queryInfosByPartCode(String selectedPartCode, List<Integer> status)
			throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select ii.infoId, ii.code, ii.title, ii.content, ii.publishTime, ii.status, ii.createby, ii.createdate, ii.updateby, ii.updatedate from intpub_info ii where 1=1 ");
		if (null != selectedPartCode && !"".equals(selectedPartCode)) {
			sql.append(" and ii.code = ").append(selectedPartCode);
		}
		
		if (null != status && !status.isEmpty()) {
			sql.append(" and ii.status in (");
			
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
		
		List<InfoDTO> infos = new ArrayList<InfoDTO>();
		List<List<String>> partData = FetchData.getListData(sql.toString());
		InfoDTO info = null;
		for(List<String> list : partData)
		{
			info = new InfoDTO();
			//select ii.infoId, ii.code, ii.title, ii.content, ii.publishTime, ii.status, ii.createby, 
			//ii.createdate, ii.updateby, ii.updatedate from intpub_info ii where 1=1 
			info.setInfoId(Integer.valueOf(list.get(0)));
			info.setCode(list.get(1));
			info.setTitle(list.get(2));
			info.setContent(list.get(3));
			info.setPublishTime(list.get(4));
			info.setStatus(Integer.valueOf(list.get(5)));
			info.setCreateBy(list.get(6));
			info.setCreateDate(list.get(7));
			info.setUpdateDate(list.get(9));
			infos.add(info);
		}
		
		return infos;
	}

	@Override
	public List<PartDTO> queryPartsByCondition(PartDTO condition, List<Integer> status) throws Exception {
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from intpub_part ip where 1=1 ");
		if (null != condition.getPartCode() && !"".equals(condition.getPartCode())) {
			sql.append(" and ip.partCode='").append(condition.getPartCode()).append("'");
		}
		
		if (null != condition.getPartName() && !"".equals(condition.getPartName())) {
			sql.append(" and ip.partName like '%").append(condition.getPartName()).append("%'");
		}
		
		if (0 != condition.getStatus()) {
			sql.append(" and ip.status = ").append(condition.getStatus());
		}
		
		if (null != condition.getBackup() && !"".equals(condition.getBackup())) {
			sql.append(" and ip.backup like '%").append(condition.getBackup()).append("%'");
		}
		
		if (0 != condition.getSort()) {
			sql.append(" and ip.backup like =").append(condition.getSort());
		}
		
		if (null != status && !status.isEmpty()) {
			sql.append(" and ip.status in (");
			
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
		
		List<PartDTO> parts = new ArrayList<PartDTO>();
		List<List<String>> partData = FetchData.getListData(sql.toString());
		PartDTO part = null;
		for(List<String> list : partData)
		{
			part = new PartDTO();
			part.setPartCode(list.get(0));
			part.setPartName(String.valueOf(list.get(1)));
			part.setStatus(Integer.valueOf(list.get(2)));
			part.setBackup(String.valueOf(list.get(3)));
			part.setSort(Integer.valueOf(list.get(4)));
			part.setCreatedBy(String.valueOf(list.get(5)));
			part.setCreatedDate(String.valueOf(list.get(6)));
			part.setUpdatedBy(String.valueOf(list.get(7)));
			part.setUpdatedDate(String.valueOf(list.get(8)));
			parts.add(part);
		}
		
		return parts;
	}
}
