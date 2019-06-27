package com.stamina.stamina.entity.pft;



import java.util.List;

public class ProjectFormEntityPage {
    /**
     * 查询出的测试项目清单 内容
     */
    private List<ProjectFormEntity> projectFormPojoList;

    /**
     * 总的条数
     */
    private long totalElements;

    public List<ProjectFormEntity> getProjectFormPojoList() {
        return projectFormPojoList;
    }

    public void setProjectFormPojoList(List<ProjectFormEntity> projectFormPojoList) {
        this.projectFormPojoList = projectFormPojoList;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
