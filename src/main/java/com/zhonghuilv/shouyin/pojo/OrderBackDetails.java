
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:48
 */
@ApiModel("订单退货详情表")
@Table(name = "order_back_details")
@Data
public class OrderBackDetails {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderbackdetailsno;

    @ApiModelProperty(value = "订单退货UUID", required = true)
    private String orderbackuuid;

    @ApiModelProperty(value = "商品编号", required = true)
    private String articleBarcode;

    @ApiModelProperty(value = "退货数量", required = true)
    private Integer num;

    @ApiModelProperty(value = "退货价格", required = true)
    private java.math.BigDecimal price;

    @ApiModelProperty(value = "退货总额", required = true)
    private Integer amout;

}

