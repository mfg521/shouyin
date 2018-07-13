package com.zhonghuilv.shouyin.exception;

import com.zhonghuilv.shouyin.enums.ErrorMsgEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


@Data
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private int errCode;
    private String errDesc;


    public BusinessException(ErrorMsgEnum msg) {
        super(msg.getErrorDesc());
        this.errCode = msg.getErrorCode();
        this.errDesc = msg.getErrorDesc();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
