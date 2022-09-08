package code.wjf.servicebase.exception;

import code.wjf.commonutils.ResultCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomizeException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    @ApiModelProperty(value = "返回信息")
    private String msg;

    public CustomizeException(ResultCodeEnum resultCodeEnum){
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

}