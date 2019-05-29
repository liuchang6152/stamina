package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.dao.pft.ProjectFormRepository;
import com.stamina.stamina.entity.pft.ProjectFormEntity;
import com.stamina.stamina.pojo.pft.ProjectFormPojo;
import com.stamina.stamina.service.pft.ProjectFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 *
 * 模块编号：pcitc_ecs_bll_bc_AddressBookServiceImpl
 * 作       者：t-weijian.hou
 * 创建时间：2019年5月28日
 * 修改编号：1
 * 描       述：通讯录业务逻辑层实现类
 */
@Service
public class ProjectFormServiceImpl implements ProjectFormService {
    @Autowired
    private ProjectFormRepository projectFormRepository;
    @Override
    public List<ProjectFormPojo> getProjectFormList() {
        return projectFormRepository.findAll();
    }

    @Override
    public CommonResult addProjectInfo(ProjectFormEntity entity) {
        CommonResult commonResult = new CommonResult();
        ProjectFormPojo formPojo = null;
        try {
//            formPojo = ObjectConverter.entityConverter(entity, ProjectFormPojo.class);
            formPojo.setAbroadNameCode(entity.getAbroadNameCode());
            formPojo.setProjectCompany(entity.getProjectCompany());
            formPojo.setScoreconfigureMany(entity.getScoreconfigureMany());
            formPojo.setProjectName(entity.getProjectName());
            projectFormRepository.save(formPojo);
            commonResult.setIsSuccess(true);
            commonResult.setMessage("添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setIsSuccess(false);
            commonResult.setMessage("添加失败！");
        }
        return commonResult;
    }

    @Override
    public CommonResult updateProjectInfo(ProjectFormEntity entity) {
        CommonResult commonResult = new CommonResult();
        ProjectFormPojo formPojo = null;
        try {
//            formPojo = ObjectConverter.entityConverter(entity, ProjectFormPojo.class);
            formPojo.setAbroadNameCode(entity.getAbroadNameCode());
            formPojo.setProjectCompany(entity.getProjectCompany());
            formPojo.setProjectformId(entity.getProjectformId());
            formPojo.setScoreconfigureMany(entity.getScoreconfigureMany());
            formPojo.setProjectName(entity.getProjectName());
            projectFormRepository.save(formPojo);
            commonResult.setIsSuccess(true);
            commonResult.setMessage("修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setIsSuccess(false);
            commonResult.setMessage("修改失败！");
        }
        return commonResult;
    }


    @Override
    @Transactional
    public CommonResult delProjectInfo(Long[] projectFormIds) {
        CommonResult commonResult = new CommonResult();
        ProjectFormPojo formPojo = null;
        try {
            for (int i = 0; i < projectFormIds.length; i++) {
                Long projectFormId = projectFormIds[i];
                projectFormRepository.deleteById(projectFormId);
            }
            commonResult.setIsSuccess(true);
            commonResult.setMessage("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            commonResult.setIsSuccess(false);
            commonResult.setMessage("删除失败！");
        }
        return commonResult;
    }

    @Override
    public CommonResult getProjectById(Long projectFormId) {
        CommonResult commonResult = new CommonResult();
        try {
            Optional<ProjectFormPojo> byId = projectFormRepository.findById(projectFormId);
            ProjectFormPojo formPojo = byId.get();
            commonResult.setResult(formPojo);
            commonResult.setIsSuccess(true);
        }catch (Exception ex){
            commonResult.setMessage("获取失败！");
            commonResult.setIsSuccess(false);
        }
        return commonResult;
    }
}
