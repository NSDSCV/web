package web.com.until;

import java.util.List;
/**
 * ��ҳ������
 * @author Administrator
 *
 * @param <T>
 */
public class PageData<T> {
    //ҳ��
    private int pageNum;
    //����
    private int totalCount;
    //��ǰҳ�����ݸ���
    private int pageSize;
    //��ҳ��
    private int totalPage;

    //�洢��list��
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

    //��ҳ�� = ���� ���� ÿҳ��С
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
