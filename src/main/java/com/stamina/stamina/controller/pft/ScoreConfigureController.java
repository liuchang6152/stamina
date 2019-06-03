package com.stamina.stamina.controller.pft;

import com.stamina.stamina.entity.pft.ProjectSettingEntity;
import com.stamina.stamina.service.pft.ScoreConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/3
 * 修改编号：
 * 描述：项目评分配置
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/fpt/scoreConfigure", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ScoreConfigureController {

    @Autowired
    private ScoreConfigureService scoreConfigureService;

    /*@GetMapping(value = "/{projectformId}")
    public List<ProjectSettingEntity> getScoreListByProjectFormId(@PathVariable Long projectformId) {

        List<ProjectSettingEntity> list = scoreConfigureService.getScoreListByProjectFormId(projectformId);
        return list;
    }*/

    @GetMapping(value = "/{projectformId}")
    public List<Map> getScoreListByProjectFormId2(@PathVariable Long projectformId) {

        List list = scoreConfigureService.getScoreListByProjectFormId2(projectformId);
        return list;
    }

}
