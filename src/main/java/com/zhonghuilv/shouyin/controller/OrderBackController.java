package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.OrderBackMapper;
import com.zhonghuilv.shouyin.pojo.OrderBack;
import com.zhonghuilv.shouyin.result.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by mengfanguang  on 2018-07-04 17:13:47
 */
@RestController
@RequestMapping("/order_back")
@Api(value = "OrderBackController", description = "订单退货表")
public class OrderBackController extends BasicController<OrderBack> {

	private OrderBackMapper orderBackMapper;

    @Autowired
    public OrderBackController(OrderBackMapper orderBackMapper) {
        super(orderBackMapper);
        this.orderBackMapper =orderBackMapper;
    }


    @Override
    @ApiOperation(value="新增退款单",notes = "新增退款单",tags = "订单管理",response = OrderBack.class)
    @PostMapping(value = "")
    public ApiResult<OrderBack> save(@RequestBody OrderBack model){
        return super.save(model);
    }
}

