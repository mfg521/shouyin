package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.StockMapper;
import com.zhonghuilv.shouyin.pojo.Stock;
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
@RequestMapping("/stock")
@Api(value = "StockController", description = "库存表")
public class StockController extends BasicController<Stock> {

	private StockMapper stockMapper;

    @Autowired
    public StockController(StockMapper stockMapper) {
        super(stockMapper);
        this.stockMapper =stockMapper;
    }


    @Override
    @ApiOperation(value = "新增库存",notes = "新增库存",tags = "库存管理",response = Stock.class)
    @PostMapping(value = "")
    public ApiResult<Stock> save(@RequestBody Stock model){
        return super.save(model);
    }
}

