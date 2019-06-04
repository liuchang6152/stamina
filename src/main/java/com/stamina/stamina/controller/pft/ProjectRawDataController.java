package com.stamina.stamina.controller.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.entity.pft.ProjectRawDataEntity;
import com.stamina.stamina.service.pft.ProjectRawDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/fpt/projectRawData", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectRawDataController {

    @Autowired
    private ProjectRawDataService projectRawDataService;

    @GetMapping("/getProjectRawData/{rawprojectBatchcode}/{rawprojectProplecode}")
    public CommonResult getProjectRawData(@PathVariable String rawprojectBatchcode, @PathVariable String rawprojectProplecode) {

        return projectRawDataService.getProjectRawData(rawprojectBatchcode, rawprojectProplecode);
    }

    /***
     * 体能批次查询
     * @return
     */
    @GetMapping
    public CommonResult physicalBatchQuery() {

        return projectRawDataService.physicalBatchQuery();
    }
}
