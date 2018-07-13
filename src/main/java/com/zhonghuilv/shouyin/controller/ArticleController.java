package com.zhonghuilv.shouyin.controller;

import com.zhonghuilv.shouyin.common.BasicController;
import com.zhonghuilv.shouyin.mapper.ArticleMapper;
import com.zhonghuilv.shouyin.pojo.Article;
import com.zhonghuilv.shouyin.result.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengfanguang
 * @create:
 * @description: article controller
 */

@RestController
@RequestMapping("/article")
@Api(value = "ArticleController")
public class ArticleController extends BasicController<Article> {


    @Autowired
    private ArticleMapper articleMapper;


    public ArticleController(ArticleMapper articleMapper){
        super(articleMapper);
        this.articleMapper=articleMapper;
    }


    @Override
    @ApiOperation(value = "商品新增", notes = "新增商品", tags = "商品管理", response = Article.class)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ApiResult<Article> save(@RequestBody Article model) {

        return super.save(model);
    }

}
