package com.stamina.stamina.pojo.pft;
/*
 * 测试项目清单
 * 模块编号：pcitc_entity_class_ProjectForm
 * 作    者：weijian.hou
 * 创建时间：2019-5.28
 * 修改编号：1
 * 描    述：测试项目配置pojo
 */

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "t_pft_scoreconfigure")
public class ScoreConfigurePojo {

    /**
     * 项目评分配置ID
     */
    @Id
    @Column(name = "SCORECONFIGURE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scoreconfigureId;

    /**
     * 低值
     */
    @Column(name = "SCORECONFIGURE_LOW")
    private Long scoreconfigureLow;

    /**
     * 高值
     */
    @Column(name = "SCORECONFIGURE_HIGH")
    private Long scoreconfigureHigh;

    /**
     * 分数
     */
    @Column(name = "SCORECONFIGURE_FRACTION")
    private Long scoreconfigureFraction;

    /**
     * 测试项目清单ID
     */
    @Column(name = "PROJECTFORM_ID")
    private Long projectFormId;

    /**
     * 测试项目清单
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECTFORM_ID",referencedColumnName = "PROJECTFORM_ID", insertable = false, updatable = false)
    private ProjectFormPojo projectFormPojo;

    public Long getScoreconfigureId() {
        return scoreconfigureId;
    }

    public void setScoreconfigureId(Long scoreconfigureId) {
        this.scoreconfigureId = scoreconfigureId;
    }

    public Long getScoreconfigureLow() {
        return scoreconfigureLow;
    }

    public void setScoreconfigureLow(Long scoreconfigureLow) {
        this.scoreconfigureLow = scoreconfigureLow;
    }

    public Long getScoreconfigureHigh() {
        return scoreconfigureHigh;
    }

    public void setScoreconfigureHigh(Long scoreconfigureHigh) {
        this.scoreconfigureHigh = scoreconfigureHigh;
    }

    public Long getScoreconfigureFraction() {
        return scoreconfigureFraction;
    }

    public void setScoreconfigureFraction(Long scoreconfigureFraction) {
        this.scoreconfigureFraction = scoreconfigureFraction;
    }

    public Long getProjectFormId() {
        return projectFormId;
    }

    public void setProjectFormId(Long projectFormId) {
        this.projectFormId = projectFormId;
    }

    public ProjectFormPojo getProjectFormPojo() {
        return projectFormPojo;
    }

    public void setProjectFormPojo(ProjectFormPojo projectFormPojo) {
        this.projectFormPojo = projectFormPojo;
    }
}
