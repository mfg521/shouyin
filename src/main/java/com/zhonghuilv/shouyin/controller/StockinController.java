package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.StockinMapper;
import com.zhonghuilv.shouyin.pojo.OrderDetails;
import com.zhonghuilv.shouyin.pojo.Stockin;
import com.zhonghuilv.shouyin.requestForm.StockInForm;
import com.zhonghuilv.shouyin.result.ApiResult;
import com.zhonghuilv.shouyin.service.StockService;
import com.zhonghuilv.shouyin.service.StockinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mengfanguang  on 2018-07-04 17:13:47
 */
@RestController
@RequestMapping("/stockin")
@Api(value = "StockinController", description = "库存入库表")
public class StockinController extends BasicController<Stockin> {

	private StockinMapper stockinMapper;

	@Autowired
    private StockinService stockinService;

    @Autowired
    public StockinController(StockinMapper stockinMapper) {
        super(stockinMapper);
        this.stockinMapper =stockinMapper;
    }

    /**
     * 入库接口
     * @param model
     * @return
     */
    @ApiOperation(value = "新增库存入库",notes = "新增库存入库",tags = "库存管理",response = Stockin.class)
    @PostMapping(value = "/trans")
    public ApiResult<StockInForm> stockin(@RequestBody StockInForm model){
        StockInForm save = stockinService.save(model);
        return ApiResult.success(save);
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

