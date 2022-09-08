package code.wjf.servicebase.exception;

import code.wjf.commonutils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /*
    全局异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        //将错误日志输出到文件
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message(e.getLocalizedMessage());
    }

    /*
    自定义异常处理
     */
    @ExceptionHandler(CustomizeException.class)
    @ResponseBody
    public R error(CustomizeException e){
        e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
