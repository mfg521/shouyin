package com.zhonghuilv.shouyin.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.zhonghuilv.shouyin.mapper.OrderDetailsMapper;
import com.zhonghuilv.shouyin.mapper.OrderInfoMapper;
import com.zhonghuilv.shouyin.mapper.StockMapper;
import com.zhonghuilv.shouyin.pay.alipay.AliPayController;
import com.zhonghuilv.shouyin.pay.wxpay.WXPayTest;
import com.zhonghuilv.shouyin.pojo.OrderDetails;
import com.zhonghuilv.shouyin.pojo.OrderInfo;
import com.zhonghuilv.shouyin.pojo.Stock;
import com.zhonghuilv.shouyin.requestForm.OrderForm;
import com.zhonghuilv.shouyin.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mengfanguang  on 2018-07-06 11:24:14
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;


    /**
     * 生成订单
     *
     * @param model
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderForm save(OrderForm model) throws AlipayApiException {
        //生成orderInfoUUID并将orderInfo插入数据库。

        String orderInfoUUID = getOrderUUId();
        model.getOrderInfo().setOrderinfouuid(orderInfoUUID);

        Integer paystate = model.getOrderInfo().getPaystate();
        String OrderState = "";

        if (paystate == 1) {
            AliPayController aliPayController = new AliPayController();
            AlipayTradePayResponse apipay = aliPayController.Apipay(orderInfoUUID, model.getAuthCode(), model.getTotalAmount());
            OrderState = apipay.getMsg().toUpperCase();
        }

        if (paystate == 2) {
            WXPayTest wxPayTest = new WXPayTest();
            Map<String, String> wXpay = wxPayTest.getWXpay(orderInfoUUID, model.getAuthCode(), model.getTotalAmount());
            OrderState = wXpay.get("result_code").toUpperCase();

        }

        //这里不管是不是支付成功都会插入数据，查询支付状态时只需要修改状态就可以。
        if ("SUCCESS".equalsIgnoreCase(OrderState)) {
            model.getOrderInfo().setOrderstate(0);
        } else {
            model.getOrderInfo().setOrderstate(1);
        }

        //先将订单插入表中
        orderInfoMapper.insertUseGeneratedKeys(model.getOrderInfo());

        //循环orderDetailsList 并插入到表，每一个orderDetails对应的orderInfoUUID都是之前生成的
        List<OrderDetails> orderDetailsList = model.getOrderDetailsList();
        for (OrderDetails orderDetails : orderDetailsList) {
            orderDetails.setOrderinfouuid(orderInfoUUID);
            orderDetailsMapper.insertUseGeneratedKeys(orderDetails);

            //获取商品条码，销售数量，在库存表中对应减去销售的数量
            String articleBarcode = orderDetails.getArticleBarcode();
            Integer num = orderDetails.getNum();
            Stock stock = stockMapper.selectByArticleCode(articleBarcode);
            stock.setNum(stock.getNum() - num);
            stockMapper.updateStock(stock);
        }
        return model;
    }

    /**
     * 查询微信订单
     *
     * @param model
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderForm queryWXpay(OrderForm model)  {
        //生成orderInfoUUID并将orderInfo插入数据库。
        OrderInfo orderInfo = model.getOrderInfo();

        String orderInfoUUID = orderInfo.getOrderinfouuid();
        String orderState = "";

        WXPayTest wxPayTest = new WXPayTest();
        Map<String, String> wXpay = wxPayTest.getWXpayOrder(orderInfoUUID);
        orderState = wXpay.get("result_code").toUpperCase();
        if ("SUCCESS".equalsIgnoreCase(orderState)) {
            model.getOrderInfo().setOrderstate(0);
            orderInfoMapper.updateOrderInfo(model.getOrderInfo());

        } else {
            //这里主要针对的是微信支付输入密码的情况，如果需要用户输入密码，则不做任何操作。直接将信息全返回。
        }
        return model;
    }


    /**
     * 查询支付宝订单
     *
     * @param model
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderForm queryAlipay(OrderForm model) throws AlipayApiException {
        //生成orderInfoUUID并将orderInfo插入数据库。
        OrderInfo orderInfo = model.getOrderInfo();

        String orderInfoUUID = orderInfo.getOrderinfouuid();
        String orderState = "";

        WXPayTest wxPayTest = new WXPayTest();
        AliPayController aliPayController = new AliPayController();
        AlipayTradeQueryResponse alipayTradeQueryResponse = aliPayController.AlipayQuery(orderInfoUUID);
        orderState = alipayTradeQueryResponse.getTradeStatus();
        if ("TRADE_SUCCESS".equalsIgnoreCase(orderState)) {
            model.getOrderInfo().setOrderstate(0);
            orderInfoMapper.updateOrderInfo(model.getOrderInfo());
        } else {

        }
        return model;
    }

    /**
     * 根据时间生成订单号
     *
     * @return
     */
    public static String getOrderUUId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String nowStr = simpleDateFormat.format(date);
        return nowStr;
    }
}