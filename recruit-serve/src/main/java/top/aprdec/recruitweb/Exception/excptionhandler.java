package top.aprdec.recruitweb.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.aprdec.recruitweb.pojo.ResultData;

import javax.xml.transform.Result;

@RestControllerAdvice
public class excptionhandler {

    @ExceptionHandler(Exception.class)
    public ResultData handleException(Exception e) {
        // 处理异常逻辑
        return ResultData.error(e.getMessage().isEmpty()?"系统异常":e.getMessage());
    }
}
