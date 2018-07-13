package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.StockBackDetailsMapper;
import com.zhonghuilv.shouyin.pojo.StockBackDetails;
import com.zhonghuilv.shouyin.result.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by llk2014  on 2018-07-04 17:13:48
 */
@RestController
@RequestMapping("/stock_back_details")
@Api(value = "StockBackDetailsController", description = "库存退货详情表")
public class StockBackDetailsController extends BasicController<StockBackDetails> {

	private StockBackDetailsMapper stockBackDetailsMapper;

    @Autowired
    public StockBackDetailsController(StockBackDetailsMapper stockBackDetailsMapper) {
        super(stockBackDetailsMapper);
        this.stockBackDetailsMapper =stockBackDetailsMapper;
    }


    @Override
    @ApiOperation(value = "新增库存退货详情",notes = "新增库存退货详情",tags = "库存管理",response = StockBackDetails.class)
    @PostMapping(value = "")
    public ApiResult<StockBackDetails> save(@RequestBody StockBackDetails model){
        return super.save(model);
    }
}

