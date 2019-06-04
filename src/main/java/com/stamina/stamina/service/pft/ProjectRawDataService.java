package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.entity.pft.ProjectRawDataEntity;

import java.util.List;

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
