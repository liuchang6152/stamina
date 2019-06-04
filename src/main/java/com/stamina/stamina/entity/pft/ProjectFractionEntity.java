package com.stamina.stamina.entity.pft;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：测试项目分数entity
 */
public class ProjectFractionEntity {

    /**
     * 序号
     */
    private Long projectfractionId;

    /**
     *测试项目名称
     */
    private String projectName;

    /**
     * 测试成绩
     */
    private Long projectValue;

    /**
     * 单位
     */
    private String projectCompany;

    /**
     * 分数
     */
    private Long projectFraction;

    public Long getProjectfractionId() {
        return projectfractionId;
    }

    public void setProjectfractionId(Long projectfractionId) {
        this.projectfractionId = projectfractionId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(Long projectValue) {
        this.projectValue = projectValue;
    }

    public String getProjectCompany() {
        return projectCompany;
    }

    public void setProjectCompany(String projectCompany) {
        this.projectCompany = projectCompany;
    }

    public Long getProjectFraction() {
        return projectFraction;
    }

    public void setProjectFraction(Long projectFraction) {
        this.projectFraction = projectFraction;
    }
}
