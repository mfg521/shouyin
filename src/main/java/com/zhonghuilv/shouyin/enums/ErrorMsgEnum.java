package com.zhonghuilv.shouyin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Andy on 2017/12/8.
 * 错误信息封装
 */
@Getter
@AllArgsConstructor
public enum ErrorMsgEnum {
    SYSTEM_ERROR(-1, "系统异常"),
    PARAM_ERROE(-2,"参数错误"),
    ;


    private int errorCode;
    private String errorDesc;


}
