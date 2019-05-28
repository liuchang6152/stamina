package com.stamina.stamina.pojo.pft;

import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

/*
 * 测试项目清单
 * 模块编号：pcitc_entity_class_ProjectForm
 * 作    者：weijian.hou
 * 创建时间：2019-5.28
 * 修改编号：1
 * 描    述：测试项目清单pojo
 */

@Entity
@DynamicUpdate
@Table(name = "t_pft_projectform")
public class ProjectFormPojo {

    /**
     * 测试项目清单ID
     */
    @Id
    @Column(name = "PROJECTFORM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectformId;

    /**
     * 项目名称
     */
    @Column(name = "PROJECT_NAME")
    private String projectName;

    /**
     * 外部项目名code
     */
    @Column(name = "ABROAD_NAMECODE")
    private String abroadNameCode;
    /**
     * 单位(0秒,1厘米,2公斤,3个,4毫升)
     */
    @Column(name = "PROJECT_COMPANY")
    private Integer projectCompany;

    /**
     *（0取最大值，1取最小值，2取平均值）
     */
    @Column(name = "SCORECONFIGURE_MANY")
    private Integer scoreconfigure_many;


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

    public Integer getScoreconfigure_many() {
        return scoreconfigure_many;
    }

    public void setScoreconfigure_many(Integer scoreconfigure_many) {
        this.scoreconfigure_many = scoreconfigure_many;
    }
}
