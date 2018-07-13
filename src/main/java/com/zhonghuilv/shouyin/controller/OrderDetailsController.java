package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.OrderDetailsMapper;
import com.zhonghuilv.shouyin.pojo.OrderDetails;
import com.zhonghuilv.shouyin.result.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by llk2014  on 2018-07-04 17:13:49
 */
@RestController
@RequestMapping("/order_details")
@Api(value = "OrderDetailsController", description = "订单详情表")
public class OrderDetailsController extends BasicController<OrderDetails> {

	private OrderDetailsMapper orderDetailsMapper;

    @Autowired
    public OrderDetailsController(OrderDetailsMapper orderDetailsMapper) {
        super(orderDetailsMapper);
        this.orderDetailsMapper =orderDetailsMapper;
    }


    @Override
    @ApiOperation(value = "新增订单详情",notes = "新增订单详情",tags = "订单管理",response = OrderDetails.class)
    @PostMapping(value = "")
    public ApiResult<OrderDetails> save(@RequestBody OrderDetails model){
        return super.save(model);
    }
}

