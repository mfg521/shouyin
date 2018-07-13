
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:48
 */
@ApiModel("库存退货详情表")
@Table(name = "stock_back_details")
@Data
public class StockBackDetails {

    @ApiModelProperty(value = "仓库退货详情编号", required = true)
    private Integer stockbackdetailsno;

    @ApiModelProperty(value = "仓库退货编号", required = true)
    private Integer stockbackno;

    @ApiModelProperty(value = "商品编号", required = true)
    private String articleBarcode;

    @ApiModelProperty(value = "退货数量", required = true)
    private Integer num;

    @ApiModelProperty(value = "退货单价", required = true)
    private java.math.BigDecimal price;

    @ApiModelProperty(value = "退货总价", required = true)
    private java.math.BigDecimal amout;

}

