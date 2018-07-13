package com.zhonghuilv.shouyin.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author: mengfanguang
 * @create: 2018-06-23 11:25
 * @description: 商品表
 **/
@ApiModel("商品表")
@Table(name = "article")
@Data
public class Article {

    @Id
    @OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Integer articleno;

    @ApiModelProperty(value = "商品名称", required = true)
    private java.lang.String articleName;

    @ApiModelProperty(value = "商品条码", required = true)
    private java.lang.String articleBarcode;

    @ApiModelProperty(value = "商品零售价")
    private BigDecimal articlePrice;

    @ApiModelProperty(value = "商品类别", required = true)
    private java.lang.String articleType;

}
