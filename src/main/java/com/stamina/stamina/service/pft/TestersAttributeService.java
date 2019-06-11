package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;
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

    CommonResult getTestersList(Map searchMap, int pageNum, int pageSize) throws Exception;

}
