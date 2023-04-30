package com.backendlist.ListTools;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kj
 * @date 2023/3/4
 * @apiNote 统一返回类
 */
@Data
public class R<T> implements Serializable {
    private Integer code;//状态码
    private String message;//信息
    private String token;
    private T data;//数据

    public static <T> R<T> success(Integer code,T data) {
        R<T> r = new R<T>();
        r.code=code;
        r.data=data;
        return r;
    }

    public static <T> R<T> success(Integer code,T data,String token) {
        R<T> r = new R<T>();
        r.code=code;
        r.data=data;
        r.token=token;
        return r;
    }

    public static <T> R<T> error(Integer code,String message){
        R<T> r = new R<T>();
        r.code=code;
        r.message=message;
        return r;
    }
}
