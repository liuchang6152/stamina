package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.common.util.CommonEnum;
import com.stamina.stamina.common.util.CommonResult;
import com.stamina.stamina.common.util.Pagination;
import com.stamina.stamina.dao.pft.ProjectFormRepository;
import com.stamina.stamina.dao.pft.ScoreConfigureRepository;
import com.stamina.stamina.entity.pft.ProjectFormEntity;
import com.stamina.stamina.entity.pft.ProjectSettingEntity;
import com.stamina.stamina.pojo.pft.ProjectFormPojo;
import com.stamina.stamina.pojo.pft.ScoreConfigurePojo;
import com.stamina.stamina.service.pft.ProjectFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.*;

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

    @Autowired
    private ScoreConfigureRepository scoreConfigureRepository;

    /**
     * 获取清单列表
     * @param page
     * @return
     */
    @Override
    public List<ProjectFormEntity> getProjectFormList(Pagination page) {
        List<ProjectFormEntity> entities = new ArrayList<>();
        List<ProjectFormPojo> all = projectFormRepository.findAll();
        for (ProjectFormPojo formPojo : all) {
            ProjectFormEntity projectFormEntity = new ProjectFormEntity();
            projectFormEntity.setAbroadNameCode(formPojo.getAbroadNameCode());
            projectFormEntity.setProjectCompanyName(CommonEnum.Unit.getName(formPojo.getProjectCompany()));
            projectFormEntity.setProjectformId(formPojo.getProjectformId());
            projectFormEntity.setProjectName(formPojo.getProjectName());
            projectFormEntity.setProjectCompany(formPojo.getProjectCompany());
            if (formPojo.getScoreconfigureMany() != null) {
                projectFormEntity.setScoreconfigureManyName(CommonEnum.ScoreTypeEnum.getName(formPojo.getScoreconfigureMany()));
            }
            entities.add(projectFormEntity);
        }
        return entities;
    }

    @Override
    public CommonResult addProjectInfo(ProjectFormEntity entity) {
        CommonResult commonResult = new CommonResult();
        try {
//            formPojo = ObjectConverter.entityConverter(entity, ProjectFormPojo.class);
            CommonResult check = check(entity);
            if(check.getIsSuccess()==false){
                return  check;
            }
            ProjectFormPojo formPojo = new ProjectFormPojo();
            formPojo.setAbroadNameCode(entity.getAbroadNameCode());
            formPojo.setProjectCompany(entity.getProjectCompany());
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

        try {
//            formPojo = ObjectConverter.entityConverter(entity, ProjectFormPojo.class);
            CommonResult check = check(entity);
            if(check.getIsSuccess()==false){
                return  check;
            }
            ProjectFormPojo formPojo = new ProjectFormPojo();
            formPojo.setAbroadNameCode(entity.getAbroadNameCode());
            formPojo.setProjectCompany(entity.getProjectCompany());
            formPojo.setProjectformId(entity.getProjectformId());
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
        try {
            for (int i = 0; i < projectFormIds.length; i++) {
                Long projectFormId = projectFormIds[i];
                scoreConfigureRepository.deleteByProjectFormId(projectFormId);
                projectFormRepository.delete(projectFormId);
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
            ProjectFormPojo formPojo = projectFormRepository.findOne(projectFormId);
            ProjectFormEntity projectFormEntity = new ProjectFormEntity();
            projectFormEntity.setAbroadNameCode(formPojo.getAbroadNameCode());
            projectFormEntity.setProjectCompany(formPojo.getProjectCompany());
            projectFormEntity.setProjectCompanyName(CommonEnum.Unit.getName(formPojo.getProjectCompany()));
            projectFormEntity.setProjectformId(formPojo.getProjectformId());
            projectFormEntity.setProjectName(formPojo.getProjectName());
            projectFormEntity.setProjectCompany(formPojo.getProjectCompany());
            if (formPojo.getScoreconfigureMany() != null) {
                projectFormEntity.setScoreconfigureManyName(CommonEnum.ScoreTypeEnum.getName(formPojo.getScoreconfigureMany()));
            }
            commonResult.setResult(projectFormEntity);
            commonResult.setIsSuccess(true);
        }catch (Exception ex){
            commonResult.setMessage("获取失败！");
            commonResult.setIsSuccess(false);
        }
        return commonResult;
    }

    @Override
    public List<Map> getUnit() {
        List<Map> list = new ArrayList<>();
        Map map = new HashMap();
        map.put("key","");
        map.put("value","请选择");
        list.add(map);
        for (int i = 0; i < 5; i++) {
            Map map1 = new HashMap();
            map1.put("key",i);
            map1.put("value",CommonEnum.Unit.getName(i));
            list.add(map1);
        }
        return list;
    }

    @Override
    public List<ProjectSettingEntity> getProjectSetting() {
        List<ProjectSettingEntity> list = new ArrayList<>();
        List<ProjectFormPojo> all = projectFormRepository.findAll();
        for (ProjectFormPojo formPojo : all) {
            ProjectSettingEntity projectSettingEntity = new ProjectSettingEntity();
            projectSettingEntity.setProjectformId(formPojo.getProjectformId());
            projectSettingEntity.setProjectName(formPojo.getProjectName());
            projectSettingEntity.setScoreconfigureMany(formPojo.getScoreconfigureMany());
            List<ScoreConfigurePojo> scoreConfigurePojos = scoreConfigureRepository.findByprojectFormId(formPojo.getProjectformId());
            projectSettingEntity.setScoreConfigurePojos(scoreConfigurePojos);
            list.add(projectSettingEntity);
        }
        return list;
    }

    @Override
    public CommonResult updProjectSetting(ProjectSettingEntity entity) {
        CommonResult commonResult = new CommonResult();
        try {
            ProjectFormPojo one = projectFormRepository.findOne(entity.getProjectformId());
            one.setScoreconfigureMany(entity.getScoreconfigureMany());
            projectFormRepository.save(one);
            List<ScoreConfigurePojo> byprojectFormId = scoreConfigureRepository.findByprojectFormId(entity.getProjectformId());
            for (ScoreConfigurePojo scoreConfigurePojo : byprojectFormId) {
                scoreConfigureRepository.delete(scoreConfigurePojo);
            }
            for (ScoreConfigurePojo scoreConfigurePojo : entity.getScoreConfigurePojos()) {
                scoreConfigureRepository.save(scoreConfigurePojo);
            }
            commonResult.setMessage("修改成功");
            commonResult.setIsSuccess(true);
        } catch (Exception ex){
            commonResult.setMessage("修改失败！");
            commonResult.setIsSuccess(false);
        }
        return commonResult;
    }


    /**
     * 校验项目名
     */
    public CommonResult check(ProjectFormEntity entity){
        CommonResult commonResult = new CommonResult();
        List<ProjectFormPojo> byprojectName = projectFormRepository.findByprojectName(entity.getProjectName());
        if(byprojectName.size()>0){
            commonResult.setMessage("项目名称重复！");
            commonResult.setIsSuccess(false);
            return commonResult;
        }
        return commonResult;
    }

}
