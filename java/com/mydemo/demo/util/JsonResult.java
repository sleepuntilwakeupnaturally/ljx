package com.mydemo.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Json格式的数据响应
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class JsonResult<E> implements Serializable {

    /**状态码*/
    private  Integer state;
    /**描述信息*/
    private String message;
    /**数据*/
    private E data;



    public JsonResult(Integer state){
        this.state = state;
    }

    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

}
