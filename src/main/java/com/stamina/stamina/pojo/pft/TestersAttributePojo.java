package com.stamina.stamina.pojo.pft;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name = "t_pft_testersattribute")
public class TestersAttributePojo {

    /**
     * 测试人员表ID
     */
    @Id
    @Column(name = "TESTERSATTRIBUTE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testersattributeId;

    /**
     *姓名
     */
    @Column(name = "TESTERS_NAME")
    private String testersName;

    /**
     *性别（0男、1女）
     */
    @Column(name = "TESTERS_GENDER")
    private String testersGender;

    /**
     *身高
     */
    @Column(name = "TESTERS_HEIGHT")
    private String testersHeight;

    /**
     *体重
     */
    @Column(name = "TESTERS_WEIGHT")
    private String testersWeight;

    /**
     *身份证（验证位数）
     */
    @Column(name = "USER_IDCARD")
    private String userIdcard;

    /**
     *人员身份证code
     */
    @Column(name = "RAWPROJECT_PEOPLECODE")
    private String rawprojectPeoplecode;

    /**
     *总分
     */
    @Column(name = "TESTERS_TOTALSCORE")
    private Long testersTotalscore;

    /**
     *批次code
     */
    @Column(name = "RAWPROJECT_BATCHCODE")
    private String rawprojectBatchcode;

    public Integer getTestersattributeId() {
        return testersattributeId;
    }

    public void setTestersattributeId(Integer testersattributeId) {
        this.testersattributeId = testersattributeId;
    }

    public String getTestersName() {
        return testersName;
    }

    public void setTestersName(String testersName) {
        this.testersName = testersName == null ? null : testersName.trim();
    }

    public String getTestersGender() {
        return testersGender;
    }

    public void setTestersGender(String testersGender) {
        this.testersGender = testersGender == null ? null : testersGender.trim();
    }

    public String getTestersHeight() {
        return testersHeight;
    }

    public void setTestersHeight(String testersHeight) {
        this.testersHeight = testersHeight == null ? null : testersHeight.trim();
    }

    public String getTestersWeight() {
        return testersWeight;
    }

    public void setTestersWeight(String testersWeight) {
        this.testersWeight = testersWeight == null ? null : testersWeight.trim();
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard == null ? null : userIdcard.trim();
    }

    public String getRawprojectPeoplecode() {
        return rawprojectPeoplecode;
    }

    public void setRawprojectPeoplecode(String rawprojectPeoplecode) {
        this.rawprojectPeoplecode = rawprojectPeoplecode == null ? null : rawprojectPeoplecode.trim();
    }

    public Long getTestersTotalscore() {
        return testersTotalscore;
    }

    public void setTestersTotalscore(Long testersTotalscore) {
        this.testersTotalscore = testersTotalscore;
    }

    public String getRawprojectBatchcode() {
        return rawprojectBatchcode;
    }

    public void setRawprojectBatchcode(String rawprojectBatchcode) {
        this.rawprojectBatchcode = rawprojectBatchcode == null ? null : rawprojectBatchcode.trim();
    }
}