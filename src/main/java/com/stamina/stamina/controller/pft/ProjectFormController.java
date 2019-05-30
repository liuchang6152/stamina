package com.stamina.stamina.controller.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.entity.pft.ProjectFormEntity;
import com.stamina.stamina.entity.pft.ProjectSettingEntity;
import com.stamina.stamina.pojo.pft.ProjectFormPojo;
import com.stamina.stamina.service.pft.ProjectFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
/*
 *
 * 模块编号：
 * 作       者：weijian.hou
 * 创建时间：2019年5月28日
 * 修改编号：1
 * 描       述：测试项目清单controller
 */

@CrossOrigin
@RestController
@RequestMapping(value = "api/fpt/projectform", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectFormController {

    @Autowired
    private ProjectFormService projectFormService;

    /**
     * 获取项目清单
     */
    @GetMapping()
    public List<ProjectFormEntity> getProjectFormList(){
        return projectFormService.getProjectFormList();
    }

    /**
     * 新增项目清单信息
     * @param entity
     * @return
     */
    @PostMapping()
    public CommonResult addProjectInfo(@RequestBody ProjectFormEntity entity){
        return projectFormService.addProjectInfo(entity);
    }

    /**
     * 修改项目清单信息
     * @param entity
     * @return
     */
    @PutMapping()
    public CommonResult updateProjectInfo(@RequestBody ProjectFormEntity entity){
        return projectFormService.updateProjectInfo(entity);
    }

    /**
     * 删除项目清单信息
     * @param projectFormIds
     * @return
     */
    @DeleteMapping()
    public CommonResult delProjectInfo(Long [] projectFormIds){
        return projectFormService.delProjectInfo(projectFormIds);
    }

    /**
     * 根据项目ID获取项目信息
     * @param projectFormId
     * @return
     */
    @GetMapping("getProjectById")
    public CommonResult getProjectById(Long projectFormId){
        return projectFormService.getProjectById(projectFormId);
    }

    /**
     * 获取单位下拉框
     */
    @GetMapping("getUnit")
    public List<Map> getUnit(){
        return projectFormService.getUnit();
    }

    /**
     * 获取项目清单配置信息
     */
    @GetMapping("getProjectSetting")
    public List<ProjectSettingEntity> getProjectSetting(){
        return projectFormService.getProjectSetting();
    }

    /**
     * 修改项目清单配置信息
     */
    @GetMapping("updProjectSetting")
    public CommonResult updProjectSetting(ProjectSettingEntity entity){
        return projectFormService.updProjectSetting(entity);
    }

}
