package com.zhonghuilv.shouyin.requestForm;

import com.zhonghuilv.shouyin.pojo.OrderDetails;
import com.zhonghuilv.shouyin.pojo.OrderInfo;
import lombok.Data;

import java.util.List;

@Data
public class OrderForm {

    private OrderInfo orderInfo;

    private List<OrderDetails> orderDetailsList;

    private String authCode;

    private String totalAmount;


}
