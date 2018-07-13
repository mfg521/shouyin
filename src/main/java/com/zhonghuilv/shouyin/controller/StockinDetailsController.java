package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.StockinDetailsMapper;
import com.zhonghuilv.shouyin.pojo.OrderDetails;
import com.zhonghuilv.shouyin.pojo.StockinDetails;
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
@RequestMapping("/stockin_details")
@Api(value = "StockinDetailsController", description = "库存入库详情表")
public class StockinDetailsController extends BasicController<StockinDetails> {

	private StockinDetailsMapper stockinDetailsMapper;

    @Autowired
    public StockinDetailsController(StockinDetailsMapper stockinDetailsMapper) {
        super(stockinDetailsMapper);
        this.stockinDetailsMapper =stockinDetailsMapper;
    }

    @Override
    @ApiOperation(value = "新增入库详情",notes = "新增入库详情",tags = "库存管理",response = StockinDetails.class)
    @PostMapping(value = "")
    public ApiResult<StockinDetails> save(@RequestBody StockinDetails model){
        return super.save(model);
    }

}

