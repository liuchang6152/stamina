package com.stamina.stamina.dao.pft;

import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import org.hibernate.mapping.List;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/12
 * 修改编号：
 * 描述：
 */
public interface ProjectRawDataRepositoryCustom {

    PaginationBean<List> physicalBatchQuery2(String rawprojectBatchcode, String beginTime, String endTime, Pagination page) throws Exception;
}
