package com.hlbb.frm.kit;

import com.hlbb.frm.config.Result;
import com.hlbb.frm.enums.ResultEnum;

/**
 * Created by Rui.Zhou on 2017/3/20.
 * 返回设置工具类
 */
public class ResultKit {
    public static Result success(Object data){
        Result result = new Result(0,"请求成功");
        result.setData(data);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code,String msg){
        Result result = new Result(code,msg);
        return result;
    }
    
    public static Result error(ResultEnum re){
        Result result = new Result(re.getCode(),re.getMsg());
        return result;
    }
}
