package com.stamina.stamina.entity.pft;

import java.math.BigInteger;
import java.util.Date;

/**
 * 模板编号：
 * 创建者: 壮壮
 * 创建时间: 2019/5/30
 * 修改编号：
 * 描述：体能批次查询entity
 */
public class PhysicalBatchQueryEntity {

    /**
     * 序号
     */
    private Long projectrawdataId;

    /**
     * 测试批次名
     */
    private String rawprojectBatchcode;

    /***
     * 测试人数
     */
    private BigInteger testNumber;

    /**
     * 批次上传时间
     */
    private String rawprojectTime;

    public Long getProjectrawdataId() {
        return projectrawdataId;
    }

    public void setProjectrawdataId(Long projectrawdataId) {
        this.projectrawdataId = projectrawdataId;
    }

    public String getRawprojectBatchcode() {
        return rawprojectBatchcode;
    }

    public void setRawprojectBatchcode(String rawprojectBatchcode) {
        this.rawprojectBatchcode = rawprojectBatchcode;
    }

    public BigInteger getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(BigInteger testNumber) {
        this.testNumber = testNumber;
    }

    public String getRawprojectTime() {
        return rawprojectTime;
    }

    public void setRawprojectTime(String rawprojectTime) {
        this.rawprojectTime = rawprojectTime;
    }
}
