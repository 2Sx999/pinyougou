package cn.porkchop.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装
 *
 * @author porkchop
 * @date 2018/6/11 23:07
 */
public class PageResult<T> implements Serializable {
    //总记录数
    private long total;
    //当前页结果
    private List<T> rows;

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
