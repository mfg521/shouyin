
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-06 11:24:14
 */
@ApiModel("订单表")
@Table(name = "orderInfo")
@Data
public class OrderInfo {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private java.lang.Integer orderno;

    @ApiModelProperty(value = "order实际使用外建,前端不需要传过来", required = true)
    private java.lang.String orderinfouuid;

    @ApiModelProperty(value = "操作员编号", required = true)
    private java.lang.Integer operatorno;

    @ApiModelProperty(value = "订单状态 0:已出，1:未出，2:挂单", required = true)
    private java.lang.Integer orderstate;

    @ApiModelProperty(value = "支付类型 0:现金，1:支付宝，2:微信", required = true)
    private java.lang.Integer paystate;

    @ApiModelProperty(value = "订单创建日期", required = true)
    private java.time.LocalDateTime createdate;

}

