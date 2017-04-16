package com.hlbb.frm.enums;

/**
 * Created by Rui.Zhou on 2017/3/20.
 * 返回参数统一配置枚举类型 方便维护
 */
public enum ResultEnum {

    UNKOWN_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    SIGN_PARAM_ERROR(103,"缺少签名参数"),
    SIGN_ERROR(101,"签名参数错误"),
    NOTFOUND_USER(1001,"用户名或密码错误"),
    NOTEXSIS_USER(1002,"用户名不存在"),
    EXSIS_USER(1003,"邮箱已注册"),
    PWD_NOSAME(1005,"两次输入密码不一致"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
