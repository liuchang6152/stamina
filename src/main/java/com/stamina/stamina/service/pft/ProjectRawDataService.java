package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;

import java.util.Map;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：
 */
public interface ProjectRawDataService {
    CommonResult getProjectRawData(String rawprojectBatchcode, String rawprojectProplecode);

    CommonResult physicalBatchQuery();
}
