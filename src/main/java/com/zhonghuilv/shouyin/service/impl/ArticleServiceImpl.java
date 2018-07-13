package com.zhonghuilv.shouyin.service.impl;

import com.zhonghuilv.shouyin.mapper.ArticleMapper;
import com.zhonghuilv.shouyin.pojo.Article;
import com.zhonghuilv.shouyin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public Article insertUseGeneratedKeys(Article article) {
        articleMapper.insertUseGeneratedKeys(article);
        return article;
    }
}
