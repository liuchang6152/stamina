package com.stamina.stamina.entity.pft;

import java.util.Date;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：项目原始属性entity
 */
public class ProjectRawDataEntity {

    /**
     * 序号
     */
    private Long projectrawdataId;

    /**
     * 测试项目名称
     */
    private String rawprojectName;

    /**
     * 测试成绩
     */
    private Long rawprojectValue;

    /**
     * 单位
     */
    private String rawprojectCompany;

    /**
     * 测试时间
     */
    private String rawprojectTime;

    public Long getProjectrawdataId() {
        return projectrawdataId;
    }

    public void setProjectrawdataId(Long projectrawdataId) {
        this.projectrawdataId = projectrawdataId;
    }

    public String getRawprojectName() {
        return rawprojectName;
    }

    public void setRawprojectName(String rawprojectName) {
        this.rawprojectName = rawprojectName;
    }

    public Long getRawprojectValue() {
        return rawprojectValue;
    }

    public void setRawprojectValue(Long rawprojectValue) {
        this.rawprojectValue = rawprojectValue;
    }

    public String getRawprojectCompany() {
        return rawprojectCompany;
    }

    public void setRawprojectCompany(String rawprojectCompany) {
        this.rawprojectCompany = rawprojectCompany;
    }

    public String getRawprojectTime() {
        return rawprojectTime;
    }

    public void setRawprojectTime(String rawprojectTime) {
        this.rawprojectTime = rawprojectTime;
    }
}
