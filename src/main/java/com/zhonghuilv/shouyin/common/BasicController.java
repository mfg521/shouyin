package com.zhonghuilv.shouyin.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhonghuilv.shouyin.result.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Create By zhengjing on 2018/3/15 10:43
 */
public abstract class BasicController<T> /*implements BasicClient<T>*/ {

    private CommonMapper<T> commonMapper;

    private Class<T> clazz;

    @Autowired
    ObjectMapper objectMapper;

    public BasicController(CommonMapper<T> commonMapper) {

        this.commonMapper = commonMapper;
    }

    /**
     * 新增
     *
     * @return
     */
//    @Override
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ApiResult save(@RequestBody T model) {
        commonMapper.insertUseGeneratedKeys(model);
        return ApiResult.success(model);
    }

    @RequestMapping(value = "/_batch_add", method = RequestMethod.POST)
    public List<T> saveList(@RequestBody List<T> model) {
        commonMapper.insertList(model);
        return model;
    }



}
