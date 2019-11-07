package com.patrol.common;

import java.util.ArrayList;
import java.util.List;

/***
 * 分页模板类
 *
 * @author WangSheng/2019-10-29
 *
 */
public class Pageable {

    /***默认第一页**/
    private Integer page = 1;
    /***默认分页大小**/
    private Integer pageSize;
    /***总量**/
    private Integer records = 0;
    /***总页数**/
    private Integer total = 0;
    /***结果集**/
    private List<?> rows = new ArrayList<>();

    private Pageable(){

    }

    public static Pageable success(List<?> list){
        Pageable pageable = new Pageable();
        if(list!=null){
            int total = list.size()%Constants.DEFAULT_PAGE_SIZE==0?list.size()/Constants.DEFAULT_PAGE_SIZE : list.size()/Constants.DEFAULT_PAGE_SIZE +1;
            pageable.setRecords(list.size());
            pageable.setTotal(total);
            pageable.setRows(list);
            pageable.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        }
        return pageable;
    }

    public static Pageable success(List<?> list,int total,int page ,int pageSize){
        Pageable pageable = new Pageable();
        if(list!=null){
            int totalPage = total%pageSize==0?total/pageSize : total/pageSize +1;
            pageable.setRecords(total);
            pageable.setTotal(totalPage);
            pageable.setRows(list);
            pageable.setPage(page);
            pageable.setPageSize(Constants.DEFAULT_PAGE_SIZE);
        }
        return pageable;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
