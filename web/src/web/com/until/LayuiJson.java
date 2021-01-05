package web.com.until;

import java.util.ArrayList;
import java.util.List;
/**
 * layui 前端table 接受格式json封装工具类
 * @author Administrator
 *
 * @param <T>
 */
public class LayuiJson<T> {
        private int code=0;
        private String msg;
        private Long count; //总条数
        private List<T> data = new ArrayList(); //装前台当前页的数据
        //getter/setter方法...


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
