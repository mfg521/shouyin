package com.zhonghuilv.shouyin.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zhonghuilv.shouyin.enums.ErrorMsgEnum;
import com.zhonghuilv.shouyin.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;


@Data
@AllArgsConstructor
public class CallResult implements Serializable {

    private static final long serialVersionUID = -4421283742208745358L;

    public int code = 1;
    public String desc = "调用成功";

    public void setErrorMsg(ErrorMsgEnum errorMsg) {
        this.code = errorMsg.getErrorCode();
        this.desc = errorMsg.getErrorDesc();
    }

    public CallResult() {
    }

    public CallResult(ErrorMsgEnum errorMsgEnum) {
        this.code = errorMsgEnum.getErrorCode();
        this.desc = errorMsgEnum.getErrorDesc();
    }

    public void setErrorMsg(BusinessException e) {
        this.code = e.getErrCode();
        this.desc = e.getErrDesc();
    }

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Object results;


    @Override
    public String toString() {
        return String.format("CallBackMsg=====>code：%s,desc：%s", code, desc);
    }
}
