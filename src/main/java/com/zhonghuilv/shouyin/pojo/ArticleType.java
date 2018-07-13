
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:47
 */
@ApiModel("商品类别表")
@Table(name = "article_type")
@Data
public class ArticleType{

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeid;

    @ApiModelProperty(value = "商品类别名称", required = true)
    private String typename;

}

