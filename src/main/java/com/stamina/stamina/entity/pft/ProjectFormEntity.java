package com.stamina.stamina.entity.pft;

/*
 * 测试项目清单
 * 模块编号：pcitc_entity_class_ProjectForm
 * 作    者：weijian.hou
 * 创建时间：2019-5.28
 * 修改编号：1
 * 描    述：测试项目清单entity
 */

public class ProjectFormEntity {

    /**
     * 测试项目清单ID
     */
    private Long projectformId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 外部项目名code
     */
    private String abroadNameCode;
    /**
     * 单位(0秒,1厘米,2公斤,3个,4毫升)
     */
    private Integer projectCompany;

    /**
     *（0取最大值，1取最小值，2取平均值）
     */
    private Integer scoreconfigureMany;

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

    public String getAbroadNameCode() {
        return abroadNameCode;
    }

    public void setAbroadNameCode(String abroadNameCode) {
        this.abroadNameCode = abroadNameCode;
    }

    public Integer getProjectCompany() {
        return projectCompany;
    }

    public void setProjectCompany(Integer projectCompany) {
        this.projectCompany = projectCompany;
    }

    public Integer getScoreconfigureMany() {
        return scoreconfigureMany;
    }

    public void setScoreconfigureMany(Integer scoreconfigureMany) {
        this.scoreconfigureMany = scoreconfigureMany;
    }
}
