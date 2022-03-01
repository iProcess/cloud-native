package com.naruto.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@NoArgsConstructor
public class Pageable {

    public Pageable(Integer pageNumber, Integer pageSize, String sortField, String sortOrder){
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
        this.toOffset();
    }

    /**
     * 当前页码
     */
    private Integer pageNumber = 1;
    /**
     * 每页条数
     */
    private Integer pageSize = 10;
    /**
     * 排序字段
     */
    private String sortField;
    /**
     * 排序方式 (asc, desc)
     */
    private String sortOrder;
    /**
     * 分页记录开始
     */
    private Integer startRow = 0;

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.toOffset();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.toOffset();
    }

    /**
     * 生成分页记录开始
     */
    private void toOffset() {
        if(this.pageNumber == null){
            this.pageNumber = 1;
        }
        if(this.pageSize == null){
            this.pageSize = 10;
        }
        this.startRow = (this.pageNumber - 1) * this.pageSize;
    }

}
