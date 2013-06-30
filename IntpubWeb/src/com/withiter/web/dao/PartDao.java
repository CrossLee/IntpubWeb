/*
 * Created on 2012-5-23
 *
 * PartDao.java
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
package com.withiter.web.dao;

import java.util.List;

import com.withiter.web.dto.InfoDTO;
import com.withiter.web.dto.PartDTO;

public interface PartDao {

	List<PartDTO> queryPartsModuleCode(String selectedModuleCode, List<Integer> status) throws Exception;

	List<InfoDTO> queryInfosByPartCode(String selectedPartCode, List<Integer> status) throws Exception;

	List<PartDTO> queryPartsByCondition(PartDTO part, List<Integer> status) throws Exception;
}
