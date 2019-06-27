package com.stamina.stamina.pojo.pft;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

@Entity
@DynamicUpdate
@Table(name = "t_pft_projectrawdata")
public class ProjectRawDataPojo {

    /**
     * 测试项目原始属性ID
     */
    @Id
    @Column(name = "PROJECTRAWDATA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectrawdataId;

    /**
     *项目名
     */
    @Column(name = "RAWPROJECT_NAME")
    private String rawprojectName;

    /**
     *数值
     */
    @Column(name = "RAWPROJECT_VALUE")
    private Long rawprojectValue;

    /**
     *单位
     */
    @Column(name = "RAWPROJECT_COMPANY")
    private String rawprojectCompany;

    /**
     *测试时间
     */
    @Column(name = "RAWPROJECT_TIME")
    private Date rawprojectTime;

    /**
     * 人员身份证code
     */
    @Column(name = "RAWPROJECT_PROPLECODE")
    private String rawprojectProplecode;

    /**
     *批次code
     */
    @Column(name = "RAWPROJECT_BATCHCODE")
    private String rawprojectBatchcode;

    /**
     *重复数据判定
     */
    @Column(name = "RAWPROJECT_REPEATDATA")
    private String rawprojectRepeatdata;

    /**
     * 批次时间
     * @return
     */
    @Column(name = "RAWPROJECT_BATCHTIME")
    private Date rawprojectBatchTime;

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
        this.rawprojectName = rawprojectName == null ? null : rawprojectName.trim();
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
        this.rawprojectCompany = rawprojectCompany == null ? null : rawprojectCompany.trim();
    }

    public Date getRawprojectTime() {
        return rawprojectTime;
    }

    public void setRawprojectTime(Date rawprojectTime) {
        this.rawprojectTime = rawprojectTime;
    }

    public String getRawprojectProplecode() {
        return rawprojectProplecode;
    }

    public void setRawprojectProplecode(String rawprojectProplecode) {
        this.rawprojectProplecode = rawprojectProplecode == null ? null : rawprojectProplecode.trim();
    }

    public String getRawprojectBatchcode() {
        return rawprojectBatchcode;
    }

    public void setRawprojectBatchcode(String rawprojectBatchcode) {
        this.rawprojectBatchcode = rawprojectBatchcode == null ? null : rawprojectBatchcode.trim();
    }

    public String getRawprojectRepeatdata() {
        return rawprojectRepeatdata;
    }

    public void setRawprojectRepeatdata(String rawprojectRepeatdata) {
        this.rawprojectRepeatdata = rawprojectRepeatdata == null ? null : rawprojectRepeatdata.trim();
    }

    public Date getRawprojectBatchTime() {
        return rawprojectBatchTime;
    }

    public void setRawprojectBatchTime(Date rawprojectBatchTime) {
        this.rawprojectBatchTime = rawprojectBatchTime;
    }
}