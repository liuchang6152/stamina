package com.stamina.stamina.controller.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.common.util.PaginationBean;
import com.stamina.stamina.service.pft.TestersAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/3
 * 修改编号：
 * 描述：测试人员
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/fpt/testersAttribute", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TestersAttributeController {

    @Autowired
    private TestersAttributeService testersAttributeService;

    /**
     * 体能人员查询
     * @param
     * @param
     * @return
     */

    @GetMapping(value = "/search")
    private PaginationBean getTestersList(String testersName, String testersGender,
                                          Long beginScore, Long endScore, String rawprojectBatchcode, Pagination page) throws Exception {
        int pageNum = page.getPageIndex();
        int pageSize = page.getPageSize();
        Map searchMap = new HashMap();
        searchMap.put("testersName", testersName);
        searchMap.put("testersGender", testersGender);
        searchMap.put("beginScore", beginScore);
        searchMap.put("endScore", endScore);
        searchMap.put("rawprojectBatchcode", rawprojectBatchcode);
        return testersAttributeService.getTestersList(searchMap, pageNum+1, pageSize);
    }

}
