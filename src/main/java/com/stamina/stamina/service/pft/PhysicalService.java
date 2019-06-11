package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;

import java.text.ParseException;

/**
 *
 * 模块编号：pcitc_ecs_bll_bc_AddressBookService
 * 作       者：t-weijian.hou
 * 创建时间：2019年5月30日
 * 修改编号：1
 * 描       述：体能服务
 */
public interface PhysicalService {
    CommonResult physicalServiceinfo(String json) throws ParseException;
}
