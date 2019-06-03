package com.stamina.stamina.service.serviceImpl.pft;

import com.stamina.stamina.dao.pft.ProjectFormRepository;
import com.stamina.stamina.dao.pft.ScoreConfigureRepository;
import com.stamina.stamina.entity.pft.ProjectSettingEntity;
import com.stamina.stamina.pojo.pft.ProjectFormPojo;
import com.stamina.stamina.pojo.pft.ScoreConfigurePojo;
import com.stamina.stamina.service.pft.ScoreConfigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/3
 * 修改编号：
 * 描述：
 */
@Service
public class ScoreConfigureServiceImpl implements ScoreConfigureService {

    @Autowired
    private ScoreConfigureRepository scoreConfigureRepository;

    @Autowired
    private ProjectFormRepository projectFormRepository;

    @Override
    public List<ProjectSettingEntity> getScoreListByProjectFormId(Long projectformId) {

        List<ProjectSettingEntity> projectSettingEntityList = new ArrayList<>();

        List<ScoreConfigurePojo> scoreConfigureList = scoreConfigureRepository.findByprojectFormId(projectformId);

        ProjectFormPojo projectFormPojo = projectFormRepository.findProjectFormPojoByProjectformId(projectformId);

        ProjectSettingEntity entity = new ProjectSettingEntity();
        entity.setProjectformId(projectformId);
        entity.setProjectName(projectFormPojo.getProjectName());
        entity.setScoreConfigurePojos(scoreConfigureList);

        projectSettingEntityList.add(entity);

        return projectSettingEntityList;
    }

    @Override
    public List<Map> getScoreListByProjectFormId2(Long projectformId) {

        List<Map> list = new ArrayList<>();
        List<ScoreConfigurePojo> scoreConfigureList = scoreConfigureRepository.findByprojectFormId(projectformId);
        for (ScoreConfigurePojo pojo : scoreConfigureList) {
            Map map = new HashMap();
            map.put("scoreconfigureLow", pojo.getScoreconfigureLow());
            map.put("scoreconfigureHigh", pojo.getScoreconfigureHigh());
            map.put("scoreconfigureFraction", pojo.getScoreconfigureFraction());
            list.add(map);
        }
        return list;
    }
}
