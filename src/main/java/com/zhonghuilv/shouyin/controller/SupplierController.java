package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.SupplierMapper;
import com.zhonghuilv.shouyin.pojo.OrderDetails;
import com.zhonghuilv.shouyin.pojo.Supplier;
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
@RequestMapping("/supplier")
@Api(value = "SupplierController", description = "供应商表")
public class SupplierController extends BasicController<Supplier> {

	private SupplierMapper supplierMapper;

    @Autowired
    public SupplierController(SupplierMapper supplierMapper) {
        super(supplierMapper);
        this.supplierMapper =supplierMapper;
    }


    @Override
    @ApiOperation(value = "新增供货商",notes = "新增供货商",tags = "供货商管理",response = Supplier.class)
    @PostMapping(value = "")
    public ApiResult<Supplier> save(@RequestBody Supplier model){
        return super.save(model);
    }
}

