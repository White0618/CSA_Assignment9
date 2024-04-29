package com.lcx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T>{
    private int code;
    private String msg;
    private T data;

    public static Result success(){
        return new Result<>(0,"success",null);
    }

    public static <E> Result<E> success(E data){
        return new Result<>(0,"success",data);
    }

    public static Result error(String msg){
        return new Result<>(1,msg,null);
    }

    public static <E> Result<E> error(String msg,E data){
        return new Result<>(1,msg,null);
    }
}
