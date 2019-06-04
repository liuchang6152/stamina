package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/4
 * 修改编号：
 * 描述：
 */
public interface ProjectFractionService {
    CommonResult getProjectFractioList(String projectBatchcode, String rawprojectPeoplecode) throws Exception;
}
