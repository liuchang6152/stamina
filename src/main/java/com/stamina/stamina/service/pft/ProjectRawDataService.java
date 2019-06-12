package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import com.stamina.stamina.entity.pft.PhysicalBatchQueryEntity;
import com.stamina.stamina.entity.pft.ProjectRawDataEntity;

import java.util.List;
import java.util.Map;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：
 */
public interface ProjectRawDataService {
    List<ProjectRawDataEntity> getProjectRawData(String rawprojectBatchcode, String rawprojectProplecode);

    List<PhysicalBatchQueryEntity> physicalBatchQuery();

    PaginationBean<PhysicalBatchQueryEntity> physicalBatchQuery2(String rawprojectBatchcode, String beginTime, String endTime, Pagination page) throws Exception;
}
