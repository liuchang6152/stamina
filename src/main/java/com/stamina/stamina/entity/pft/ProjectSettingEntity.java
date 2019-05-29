package com.stamina.stamina.entity.pft;

import com.stamina.stamina.pojo.pft.ScoreConfigurePojo;

import java.util.List;

public class ProjectSettingEntity {

    /**
     * 测试项目清单ID
     */
    private Long projectformId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目清单配置信息
     */
    private List<ScoreConfigurePojo> scoreConfigurePojos;

    public Long getProjectformId() {
        return projectformId;
    }

    public void setProjectformId(Long projectformId) {
        this.projectformId = projectformId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<ScoreConfigurePojo> getScoreConfigurePojos() {
        return scoreConfigurePojos;
    }

    public void setScoreConfigurePojos(List<ScoreConfigurePojo> scoreConfigurePojos) {
        this.scoreConfigurePojos = scoreConfigurePojos;
    }
}
