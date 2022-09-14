package code.wjf.commonutils;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    PARAM_ERROR( 202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    CODE_ERROR(210, "验证码错误"),
    //    LOGIN_MOBLE_ERROR(211, "账号不正确"),
    LOGIN_DISABLED_ERROR(212, "改用户已被禁用"),
    REGISTER_MOBLE_ERROR(213, "手机号已被使用"),
    LOGIN_AURH(214, "需要登录"),
    LOGIN_ACL(215, "没有权限"),

    NoData(440, "数据不存在"),

    ByZero(460,"除数为0"),

    FILE_UPLOAD_ERROR(461, "文件上传错误"),
    ADD_SUBJECT_ERROR(462, "添加课程分类失败"),
    ADD_ERROR(463,"添加失败"),
    ADD_COURSE_INFO_ERROR(464,"课程信息保存失败"),

    ADD_COURSE_DETAIL_INFO_ERROR(465,"课程详情信息保存失败"),

    UPDATE_COURSE_INFO_ERROR(466,"课程信息更新失败"),

    UPDATE_COURSE_DETAIL_INFO_ERROR(467,"课程详情信息更新失败"),

    ;
    private Integer code;
    private String message;


    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
