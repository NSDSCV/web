package web.com.until;

import java.util.List;
/**
 * 分页工具类
 * @author Administrator
 *
 * @param <T>
 */
public class PageData<T> {
    //页码
    private int pageNum;
    //总数
    private int totalCount;
    //当前页的数据个数
    private int pageSize;
    //总页数
    private int totalPage;

    //存储在list中
    private List<T> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //总页数 = 总数 除以 每页大小
    public int getTotalPage() {
        totalPage = totalCount/pageSize;
        if ((totalCount % pageSize)!=0){
            totalPage = totalPage + 1;
        }
        return totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageData{" +
                "pageNum=" + pageNum +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
