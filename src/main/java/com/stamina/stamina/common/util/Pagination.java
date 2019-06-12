package com.stamina.stamina.common.util;

import pcitc.imp.common.ettool.baseresrep.BaseResRep;

import java.io.Serializable;

/*
 * 翻页实现类
 * 模块编号：pcitc_ecs_common_class_Pagination
 * 作    者：pcitc
 * 创建时间：2017/09/21
 * 修改编号：1
 * 描    述：翻页实现类
 */
public class Pagination extends BaseResRep implements Serializable {

    /**
     * 总记录数
     */
    private long total;

    /**
     * 页面条数算
     */
    private int pageSize;

    /**
     * 当前页数
     */
    private int pageNumber;
    private int pageIndex;

    private  boolean isBaseZero;

    public Long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {

        this.pageIndex = pageIndex;
        this.pageNumber=this.pageIndex;
        this.isBaseZero=true;
    }

    public int getPageNumber() {

        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        this.pageIndex=this.pageNumber;
        this.isBaseZero=false;
    }

    public boolean getIsBaseZero() {
        return isBaseZero;
    }

	/**
	 * @param pageSize
	 * @param pageNumber
	 */
	public Pagination(int pageSize, int pageNumber) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	/**
	 * 
	 */
	public Pagination() {
		super();
	}

}