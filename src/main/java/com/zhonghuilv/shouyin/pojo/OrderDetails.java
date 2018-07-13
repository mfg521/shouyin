
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:49
 */
@ApiModel("订单详情表")
@Table(name = "order_details")
@Data
public class OrderDetails {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderdetailno;

    @ApiModelProperty(value = "对应订单UUID", required = true)
    private String orderinfouuid;

    @ApiModelProperty(value = "商品条形码", required = true)
    private String articleBarcode;

    @ApiModelProperty(value = "商品数量", required = true)
    private Integer num;

    @ApiModelProperty(value = "商品价格", required = true)
    private java.math.BigDecimal price;

    @ApiModelProperty(value = "订单详情总价", required = true)
    private java.math.BigDecimal amount;

}

