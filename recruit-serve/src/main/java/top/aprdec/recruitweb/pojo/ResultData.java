package top.aprdec.recruitweb.pojo;

import lombok.Data;

@Data
public class ResultData<T>{
    private int code;
    private String msg;
    private T data;

    public static <T> ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(200);
        resultData.setMsg("success");
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> error(String msg){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(500);
        resultData.setMsg(msg);
        resultData.setData(null);
        return resultData;
    }
}
