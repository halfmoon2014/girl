package gril.demo.utils;

import gril.demo.domain.Result;

public class ResultUtil {
    public  static Result success(Object object ){
        Result result= new Result();
        result.setCode(0);
        result.setData(object);
        result.setMsg("成功");
        return result;
    }

    public  static Result success( ){
      return   success(null);
    }

    public  static Result error(Integer code,String msg){
        Result result= new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
