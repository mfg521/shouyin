package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.OperatorMapper;
import com.zhonghuilv.shouyin.pojo.Operator;
import com.zhonghuilv.shouyin.result.ApiResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;


import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by mengfanguang  on 2018-07-04 17:13:49
 */
@RestController
@RequestMapping("/operator")
@Api(value = "OperatorController", description = "操作员表")
public class OperatorController extends BasicController<Operator> {

	private OperatorMapper operatorMapper;

    @Autowired
    public OperatorController(OperatorMapper operatorMapper) {
        super(operatorMapper);
        this.operatorMapper =operatorMapper;
    }


    @Override
    @ApiOperation(value="新增操作员",notes="新增操作员",tags = "用户管理",response = Operator.class)
    @PostMapping(value="")
    public ApiResult<Operator> save(@RequestBody Operator model){
        return super.save(model);
    }
}

