package net.evercodig.helloblog.pojo;

import java.util.List;

public class PageBean<T> {
    private int page;//当前页数           前端给的
    private int totalCount; //总记录数    查出来的
    private int totalPage;//总页数        算出来的
    private int limit;//每页显示记录数     前端给的
    private List<T> list;//记录集合 查出来的

    public int getPage() {
        return page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getLimit() {
        return limit;
    }

    public List<T> getList() {
        return list;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
