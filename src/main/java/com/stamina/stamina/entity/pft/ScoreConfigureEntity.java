package com.stamina.stamina.entity.pft;

public class ScoreConfigureEntity {
    /**
     * 项目评分配置ID
     */
    private Long scoreconfigureId;

    /**
     * 低值
     */
    private String scoreconfigureLow;

    /**
     * 高值
     */
    private String scoreconfigureHigh;

    /**
     * 分数
     */
    private String scoreconfigureFraction;

    /**
     * 测试项目清单ID
     */
    private Long projectFormId;

    public Long getScoreconfigureId() {
        return scoreconfigureId;
    }

    public void setScoreconfigureId(Long scoreconfigureId) {
        this.scoreconfigureId = scoreconfigureId;
    }

    public String getScoreconfigureLow() {
        return scoreconfigureLow;
    }

    public void setScoreconfigureLow(String scoreconfigureLow) {
        this.scoreconfigureLow = scoreconfigureLow;
    }

    public String getScoreconfigureHigh() {
        return scoreconfigureHigh;
    }

    public void setScoreconfigureHigh(String scoreconfigureHigh) {
        this.scoreconfigureHigh = scoreconfigureHigh;
    }

    public String getScoreconfigureFraction() {
        return scoreconfigureFraction;
    }

    public void setScoreconfigureFraction(String scoreconfigureFraction) {
        this.scoreconfigureFraction = scoreconfigureFraction;
    }

    public Long getProjectFormId() {
        return projectFormId;
    }

    public void setProjectFormId(Long projectFormId) {
        this.projectFormId = projectFormId;
    }
}
