package com.zhonghuilv.shouyin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: lsh.
 * @create: 2018-06-21 09:45
 * @description: 票务订单状态
 **/
@Getter
@AllArgsConstructor
public enum OrderStatusEnmu {
    CANCELED(-1,"已取消"),
    UNAUTHORIZED(0,"未验证"),
    AUTHENTICATED(1,"已验证"),
    HAVE_EXPIRED (2,"已过期"),
    AUDIT(3,"退票审核中"),
    ABNORMAL_ORDERS(4,"异常订单"),
    PARTIAL_VALIDATION(5,"部分验证"),
    REFUNDED(6,"已退款"),

    ;
    private Integer code;
    private String desc;
}

