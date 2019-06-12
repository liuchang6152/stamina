package com.stamina.stamina.common.util;

import java.util.ArrayList;
import java.util.List;

/*
 * 分页实现类
 * 模块编号：pcitc_ecs_common_class_PaginationBean
 * 作    者：pcitc
 * 创建时间：2017/09/21
 * 修改编号：1
 * 描    述：分页实现类
 */
public class PaginationBean<T> {

    /**
     * 是否还有上一页
     */
    private boolean hasPrePage;
    /**
     * 是否有下一页
     */
    private boolean hasNextPage;
    private String id;
    /**
     * 分页状态
     */
    private int status = 0;
    /**
     * 总条数
     */
    private long total;
    private long totalCount;
    /**
     * 数据列表
     */
    private List<T> pageList;
    private List<T> data;
    /**
     * 每页条数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     *
     */
    private int pageNumber;

    private int pageIndex;

    /**
     * 位移的数
     */
    private int beginIndex;
    private boolean isBaseZero;

    public PaginationBean(Pagination page, Long totalRecords) {
        pageSize = 0;
        totalPage = 0;
        pageNumber = 0;
        pageIndex = 0;
        init(page, totalRecords);
    }

    public PaginationBean() {
        pageSize = 0;
        totalPage = 0;
        pageNumber = 0;
        pageIndex = 0;
    }

    public void init() {
        pageList = new ArrayList<T>();
        data = new ArrayList<T>();
        createPage(pageNumber, total, pageSize);
    }

    public static int getIntParameter(Object object, int i) {
        if (object == null) {
            return i;
        }
        try {
            String s1 = ((String[]) object)[0];
            return Integer.parseInt(s1);
        } catch (Exception e) {
            try {
                return Integer.parseInt((String) object);
            } catch (Exception e1) {
                return (Integer) object;
            }
        }
    }

    private void init(Pagination page, long totalRecords) {
        pageNumber = page.getPageNumber();
        this.pageIndex = this.pageNumber;
        this.isBaseZero=page.getIsBaseZero();
        pageSize = page.getPageSize();
        this.total = totalRecords;
        this.totalCount=this.total;
        pageList = new ArrayList<T>();
        data = new ArrayList<T>();
        createPage(pageNumber, totalRecords, pageSize);
    }

    public boolean getIsBaseZero() {
        return isBaseZero;
    }

    public void createPage(int pageNumber, long totalRecords, int pageSize) {

        this.pageNumber = getCurrentPage(pageNumber, totalPage,this.isBaseZero);
        this.pageIndex = this.pageNumber;

        beginIndex = getBeginIndex(pageSize, this.pageNumber);

        totalPage = getTotalPage(pageSize, totalRecords);

        hasNextPage = hasNextPage(this.pageNumber, totalPage);

        hasPrePage = hasPrePage(this.pageNumber);
    }

    private static int getCurrentPage(int pageNumber, int totalPage,boolean isBaseZero) {
        if (isBaseZero)
        {
            return  pageNumber+1;
        }
        return pageNumber == 0 ? 1 : pageNumber;
    }

    private static int getBeginIndex(int everyPage, int pageNumber) {

        return (pageNumber - 1) * everyPage;
    }

    private static int getTotalPage(int everyPage, long totalRecords) {
        int totalPage = 0;

        if (totalRecords % everyPage == 0) {
            totalPage = (int) (totalRecords / everyPage);
        }
        else {
            totalPage = (int) (totalRecords / everyPage + 1);
        }

        return totalPage;
    }

    private static boolean hasPrePage(int pageNumber) {
        return pageNumber == 1 ? false : true;
    }

    private static boolean hasNextPage(int pageNumber, int totalPage) {
        return pageNumber == totalPage || totalPage == 0 ? false : true;
    }

    public List<T> getData() {
        return pageList;
    }

    public void setData(List<T> data) {
        this.data = data;
        this.pageList = this.data;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> list) {
        pageList = list;
        this.data = this.pageList;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int i) {
        pageSize = i;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
        this.totalCount=this.total;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        this.total=this.totalCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        this.pageNumber = this.pageIndex;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int i) {
        pageNumber = i;
        this.pageIndex = this.pageNumber;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int i) {
        totalPage = i;
    }

    public String getId() {
        return id;
    }

    public void setId(String s) {
        id = s;
    }

    public int getBeginIndex() {
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public boolean isHasPrePage() {
        return hasPrePage;
    }

    public void setHasPrePage(boolean hasPrePage) {
        this.hasPrePage = hasPrePage;
    }

    public int getStatus() {
        return status;
    }
}
