package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.OrderBackDetailsMapper;
import com.zhonghuilv.shouyin.pojo.OrderBackDetails;
import com.zhonghuilv.shouyin.result.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;


import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by mengfanguang  on 2018-07-04 17:13:48
 */
@RestController
@RequestMapping("/order_back_details")
@Api(value = "OrderBackDetailsController", description = "订单退货详情表")
public class OrderBackDetailsController extends BasicController<OrderBackDetails> {

	private OrderBackDetailsMapper orderBackDetailsMapper;

    @Autowired
    public OrderBackDetailsController(OrderBackDetailsMapper orderBackDetailsMapper) {
        super(orderBackDetailsMapper);
        this.orderBackDetailsMapper =orderBackDetailsMapper;
    }

    @Override
    @ApiOperation(value="订单退款详情",notes = "订单退款详情",tags = "订单管理",response = OrderBackDetails.class)
    @PostMapping(value = "")
    public ApiResult<OrderBackDetails> save(@RequestBody OrderBackDetails model){
        return super.save(model);
    }

}

