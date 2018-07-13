package com.zhonghuilv.shouyin.mapper;

import com.zhonghuilv.shouyin.common.CommonMapper;
import com.zhonghuilv.shouyin.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface StockMapper extends CommonMapper<Stock> {

     public void updateStock(Stock stock);
     public Stock selectByArticleCode(String articleBarcode);

}