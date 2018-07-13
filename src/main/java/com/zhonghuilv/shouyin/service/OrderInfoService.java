package com.zhonghuilv.shouyin.service;


import com.alipay.api.AlipayApiException;
import com.zhonghuilv.shouyin.pojo.OrderInfo;
import com.zhonghuilv.shouyin.requestForm.OrderForm;

/**
 * Created by mengfanguang  on 2018-07-06 11:24:14
 */

public interface OrderInfoService {

    public OrderForm save(OrderForm model) throws AlipayApiException;

    public OrderForm queryWXpay(OrderForm model) throws AlipayApiException;

    public OrderForm queryAlipay(OrderForm model) throws AlipayApiException;

}
