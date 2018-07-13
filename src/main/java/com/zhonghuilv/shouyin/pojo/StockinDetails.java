
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:48
 */
@ApiModel("库存入库详情表")
@Table(name = "stockin_details")
@Data
public class StockinDetails {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockindetailsno;

    @ApiModelProperty(value = "入库编号", required = true)
    private String stockinuuid;

    @ApiModelProperty(value = "商品编号", required = true)
    private String articleBarcode;

    @ApiModelProperty(value = "入库数量", required = true)
    private Integer num;

    @ApiModelProperty(value = "入库价格", required = true)
    private java.math.BigDecimal price;

    @ApiModelProperty(value = "总金额", required = true)
    private java.math.BigDecimal amount;

}

