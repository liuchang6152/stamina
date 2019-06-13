package com.stamina.stamina.dao.pft;

import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import org.hibernate.mapping.List;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/13
 * 修改编号：
 * 描述：
 */
public interface TestersAttributeRepositoryCustom {
    PaginationBean<List> getTestersList2(String rawprojectBatchcode, String testersName, String testersGender, Long beginScore, Long endScore, Pagination page) throws Exception;
}
