package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.ArticleTypeMapper;
import com.zhonghuilv.shouyin.pojo.ArticleType;
import com.zhonghuilv.shouyin.result.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mengfanguang  on 2018-07-04 17:13:47
 */
@RestController
@RequestMapping("/article_type")
@Api(value = "ArticleTypeController", description = "商品类别表")
public class ArticleTypeController extends BasicController<ArticleType> {

	private ArticleTypeMapper articleTypeMapper;

    @Autowired
    public ArticleTypeController(ArticleTypeMapper articleTypeMapper) {
        super(articleTypeMapper);
        this.articleTypeMapper =articleTypeMapper;
    }

    @Override
    @ApiOperation(value = "商品类别新增", notes = "新增商品类别", tags = "商品管理", response = ArticleType.class)
    @PostMapping
    public ApiResult<ArticleType> save(@RequestBody ArticleType model ){
        return super.save(model);
    }

}

