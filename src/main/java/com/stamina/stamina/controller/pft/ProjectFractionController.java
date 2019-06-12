package com.stamina.stamina.controller.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.entity.pft.ProjectFractionEntity;
import com.stamina.stamina.service.pft.ProjectFractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/4
 * 修改编号：
 * 描述：测试项目分数
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/fpt/projectFraction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectFractionController {

    @Autowired
    private ProjectFractionService projectFractionService;

    /***
     * 根据批次Code和人员Code初始化
     * 初始化测试项目分数表
     */
    @GetMapping("/getProjectFractioList/{projectBatchcode}/{rawprojectPeoplecode}")
    public List<ProjectFractionEntity> getProjectFractioList(@PathVariable String projectBatchcode, @PathVariable String rawprojectPeoplecode) throws Exception {

        return projectFractionService.getProjectFractioList(projectBatchcode, rawprojectPeoplecode);
    }

}
