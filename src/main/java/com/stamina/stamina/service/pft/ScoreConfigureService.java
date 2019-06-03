package com.stamina.stamina.service.pft;

import com.stamina.stamina.entity.pft.ProjectSettingEntity;

import java.util.List;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/6/3
 * 修改编号：
 * 描述：
 */
public interface ScoreConfigureService {
    List<ProjectSettingEntity> getScoreListByProjectFormId(Long projectformId);
}
