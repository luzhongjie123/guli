package com.guli.edu.common.entity.vo;

import com.guli.edu.common.constant.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@ApiModel("全局统一返回类")
public class ResultEntity {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data=new HashMap<>();

    private ResultEntity(){

    }



    public static ResultEntity ok(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        resultEntity.setCode(ResultCodeEnum.SUCCESS.getCode());
        resultEntity.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        return resultEntity;
    }

    public static ResultEntity error(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setMessage(ResultCodeEnum.UNKNOWN_REASON.getMessage());
        resultEntity.setCode(ResultCodeEnum.UNKNOWN_REASON.getCode());
        resultEntity.setSuccess(ResultCodeEnum.UNKNOWN_REASON.getSuccess());
        return resultEntity;
    }

    /**
     * 传入一个枚举,自定义返回结果
     * @param resultCodeEnum
     * @return
     */
    public static ResultEntity setResultEntity(ResultCodeEnum resultCodeEnum){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity.setMessage(resultCodeEnum.getMessage());
        resultEntity.setCode(resultCodeEnum.getCode());
        resultEntity.setSuccess(resultCodeEnum.getSuccess());
        return resultEntity;
    }

    public ResultEntity success(boolean success){
       this.setSuccess(success);
       return this;
    }

    public ResultEntity code(Integer code){
        this.setCode(code);
        return this;
    }

    public ResultEntity message(String message){
        this.setMessage(message);
        return this;
    }

    /**
     * 传入KV,map封装
     * @param key
     * @param value
     * @return
     */
    public ResultEntity data(String key,Object value){
        Map<String, Object> map = new HashMap<>();
        map.put(key,value);
        this.setData(map);
        return this;
    }

    /**
     * 传入一个map
     * @param map
     * @return
     */
    public ResultEntity data(Map<String,Object> map){
        this.setData(map);
        return this;
    }



}
