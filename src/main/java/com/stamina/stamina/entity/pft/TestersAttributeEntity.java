package com.stamina.stamina.entity.pft;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：测试人员表entity
 */
public class TestersAttributeEntity {

    /**
     * 序号
     */
    private Integer testersattributeId;

    /**
     * 姓名
     */
    private String testersName;

    /**
     * 性别
     */
    private String testersGender;

    /**
     * 身高
     */
    private String testersHeight;

    /**
     * 体重
     */
    private String testersWeight;

    /**
     * 身份证号
     */
    private String userIdCard;

    /**
     * 总分
     */
    private Long testersTotalScore;

    //人员身份证code
    private String rawprojectPeoplecode;

    //批次code
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
        this.testersName = testersName;
    }

    public String getTestersGender() {
        return testersGender;
    }

    public void setTestersGender(String testersGender) {
        this.testersGender = testersGender;
    }

    public String getTestersHeight() {
        return testersHeight;
    }

    public void setTestersHeight(String testersHeight) {
        this.testersHeight = testersHeight;
    }

    public String getTestersWeight() {
        return testersWeight;
    }

    public void setTestersWeight(String testersWeight) {
        this.testersWeight = testersWeight;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public Long getTestersTotalScore() {
        return testersTotalScore;
    }

    public void setTestersTotalScore(Long testersTotalScore) {
        this.testersTotalScore = testersTotalScore;
    }

    public String getRawprojectPeoplecode() {
        return rawprojectPeoplecode;
    }

    public void setRawprojectPeoplecode(String rawprojectPeoplecode) {
        this.rawprojectPeoplecode = rawprojectPeoplecode;
    }

    public String getRawprojectBatchcode() {
        return rawprojectBatchcode;
    }

    public void setRawprojectBatchcode(String rawprojectBatchcode) {
        this.rawprojectBatchcode = rawprojectBatchcode;
    }
}
