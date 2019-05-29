package com.stamina.stamina.pojo.pft;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name = "t_pft_projectfraction")
public class ProjectFractionPojo {

    /****
     * 测试项目分数ID
     */
    @Id
    @Column(name = "PROJECTFRACTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectfractionId;

    /***
     * 项目名
     */
    @Column(name = "PROJECT_NAME")
    private String projectName;

    /***
     * 数值
     */
    @Column(name = "PROJECT_VALUE")
    private Long projectValue;

    /***
     * 单位
     */
    @Column(name = "PROJECT_COMPANY")
    private String projectCompany;

    /***
     *分数
     */
    @Column(name = "PROJECT_FRACTION")
    private Long projectFraction;

    /****
     * 测试时间
     */
    @Column(name = "PROJECT_TIME")
    private Date projectTime;

    /***
     *人员身份证code
     */
    @Column(name = "RAWPROJECT_PEOPLECODE")
    private String rawprojectPeoplecode;

    /***
     * 批次code
     */
    @Column(name = "PROJECT_BATCHCODE")
    private String projectBatchcode;

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
        this.projectName = projectName == null ? null : projectName.trim();
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
        this.projectCompany = projectCompany == null ? null : projectCompany.trim();
    }

    public Long getProjectFraction() {
        return projectFraction;
    }

    public void setProjectFraction(Long projectFraction) {
        this.projectFraction = projectFraction;
    }

    public Date getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(Date projectTime) {
        this.projectTime = projectTime;
    }

    public String getRawprojectPeoplecode() {
        return rawprojectPeoplecode;
    }

    public void setRawprojectPeoplecode(String rawprojectPeoplecode) {
        this.rawprojectPeoplecode = rawprojectPeoplecode == null ? null : rawprojectPeoplecode.trim();
    }

    public String getProjectBatchcode() {
        return projectBatchcode;
    }

    public void setProjectBatchcode(String projectBatchcode) {
        this.projectBatchcode = projectBatchcode == null ? null : projectBatchcode.trim();
    }
}