package com.zhonghuilv.shouyin.controller;

import com.alipay.api.AlipayApiException;
import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.OrderInfoMapper;
import com.zhonghuilv.shouyin.pojo.OrderInfo;
import com.zhonghuilv.shouyin.requestForm.OrderForm;
import com.zhonghuilv.shouyin.result.ApiResult;
import com.zhonghuilv.shouyin.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mengfanguang  on 2018-07-06 11:24:14
 */
@RestController
@RequestMapping("/order")
@Api(value = "OrderController", description = "订单表")
public class OrderInfoController extends BasicController<OrderInfo> {

    @Autowired
    private OrderInfoService orderInfoService;

	private OrderInfoMapper orderInfoMapper;

    @Autowired
    public OrderInfoController(OrderInfoMapper orderInfoMapper) {
        super(orderInfoMapper);
        this.orderInfoMapper =orderInfoMapper;
    }

    @Override
    @ApiOperation(value = "新增订单",notes = "新增订单",tags = "订单管理",response = OrderInfo.class)
    @PostMapping(value = "")
    public ApiResult<OrderInfo> save(@RequestBody OrderInfo orderInfo){
       return super.save(orderInfo) ;
    }

    @ApiOperation(value = "新增订单t",notes = "新增订单t",tags = "订单管理",response = OrderInfo.class)
    @PostMapping(value = "/trans")
    public ApiResult<OrderForm> saveTrans(@RequestBody OrderForm model) throws AlipayApiException {
        OrderForm save = orderInfoService.save(model);
        return ApiResult.success(save);
    }


    @ApiOperation(value = "查询微信支付并新增订单",notes = "查询微信支付并新增订单",tags = "订单管理",response = OrderInfo.class)
    @PostMapping(value = "/transQuery")
    public ApiResult<OrderForm> queryWXpay(@RequestBody OrderForm model) throws AlipayApiException {
        OrderForm save = orderInfoService.queryWXpay(model);
        return ApiResult.success(save);
    }

}

