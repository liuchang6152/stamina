package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import com.stamina.stamina.entity.pft.TestersAttributeEntity;
import org.springframework.data.domain.Page;

import java.util.Map;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/3
 * 修改编号：
 * 描述：
 */
public interface TestersAttributeService {

    PaginationBean getTestersList(Map searchMap, int pageNum, int pageSize) throws Exception;

    PaginationBean<TestersAttributeEntity> getTestersList2(String rawprojectBatchcode, String testersName, String testersGender, Long beginScore, Long endScore, Pagination page) throws Exception;
}
