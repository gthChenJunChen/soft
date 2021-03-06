package sh.cjc.fm.model;


import java.util.List;

public class LayuiTable<T> {
    private Long code;
    private Long count;
    private String msg;
    private List<T> data;

    public LayuiTable() {
        super();
    }

    public LayuiTable(Long code, Long count, String msg, List<T> data) {
        super();
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiTable{" +
                "code=" + code +
                ", count=" + count +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
