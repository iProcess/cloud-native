package com.naruto.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;


/**
 * 分页参数
 * @param <T>
 */
@AllArgsConstructor
@Data
public class PageInfo<T> {

    public PageInfo(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    /**
     * 总页数
     */
    private Long pageCount = 0L;
    /**
     * 总条数
     */
    private Long totalCount = 0L;
    /**
     * 当前页码
     */
    private Integer pageNumber = 1;
    /**
     * 每页条数
     */
    private Integer pageSize = 10;
    /**
     * 数据
     */
    private List<T> list;

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
        this.repaginate();
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        this.repaginate();
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
        this.repaginate();
    }

    /**
     * 重新计算分页
     */
    private void repaginate() {

        if (this.pageSize < 1) {
            this.pageSize = 10;
        }

        if (this.pageNumber < 1) {
            this.pageNumber = 1;
        }

        if (Objects.nonNull(this.totalCount) && this.totalCount > 0) {
            this.pageCount = this.totalCount / this.pageSize + (this.totalCount % this.pageSize > 0 ? 1 : 0);
        }
    }

}
