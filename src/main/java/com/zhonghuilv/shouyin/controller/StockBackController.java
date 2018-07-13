package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.StockBackMapper;
import com.zhonghuilv.shouyin.pojo.StockBack;
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
@RequestMapping("/stock_back")
@Api(value = "StockBackController", description = "库存退货表")
public class StockBackController extends BasicController<StockBack> {

	private StockBackMapper stockBackMapper;

    @Autowired
    public StockBackController(StockBackMapper stockBackMapper) {
        super(stockBackMapper);
        this.stockBackMapper =stockBackMapper;
    }

    @Override
    @ApiOperation(value = "新增库存退货单",notes = "新增库存退货单",tags = "库存管理",response = StockBack.class)
    @PostMapping(value = "")
    public ApiResult<StockBack> save(@RequestBody StockBack model){
        return super.save(model);
    }

}

