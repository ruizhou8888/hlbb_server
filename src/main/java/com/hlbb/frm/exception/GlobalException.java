package com.hlbb.frm.exception;

import com.hlbb.frm.enums.ResultEnum;

/**
 * Created by Rui.Zhou on 2017/3/20.
 * 签名错误exception
 */
public class GlobalException extends RuntimeException {
    private Integer code;
    public GlobalException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
