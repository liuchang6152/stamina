package com.stamina.stamina.service.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.entity.pft.ProjectFormEntity;
import com.stamina.stamina.pojo.pft.ProjectFormPojo;

import java.util.List;

/**
 *
 * 模块编号：pcitc_ecs_bll_bc_AddressBookService
 * 作       者：t-weijian.hou
 * 创建时间：2019年5月28日
 * 修改编号：1
 * 描       述：测试项目清单逻辑层接口
 */
public interface ProjectFormService {
    /**
     * 获取项目清单
     */
    List<ProjectFormPojo> getProjectFormList();
    /**
     * 新增项目清单信息
     * @param entity
     * @return
     */
    CommonResult addProjectInfo(ProjectFormEntity entity);
    /**
     * 修改项目清单信息
     * @param entity
     * @return
     */
    CommonResult updateProjectInfo(ProjectFormEntity entity);
    /**
     * 删除项目清单信息
     * @param projectFormIds
     * @return
     */
    CommonResult delProjectInfo(Long[] projectFormIds);
}