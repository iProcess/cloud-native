package com.naruto.common;

import lombok.Data;

import java.util.List;

/**
 * @author
 * @version V1.0
 * date 2019/12/10 4:19 PM
 * Description: TODO
 */
@Data
public class DataPageable<T> implements java.io.Serializable{
    /**
     * 每页大小
     */
    private int pageSize;
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 总共页码
     */
    private int totalPage;
    /**
     * 总数量
     */
    private int totalCount;
    /**
     * 页面里的数据
     */
    private List<T> items;
    /**
     * 排序自动
     */
    private String sort;
    /**
     * 排序规则
     */
    private String order;
}
