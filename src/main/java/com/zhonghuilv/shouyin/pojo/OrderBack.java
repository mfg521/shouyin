
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:47
 */
@ApiModel("订单退货表")
@Table(name = "order_back")
@Data
public class OrderBack{

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderbackno;

    @ApiModelProperty(value = "订单退货UUID", required = true)
    private String orderbackuuid;

    @ApiModelProperty(value = "操作员编号", required = true)
    private Integer opetatorno;

    @ApiModelProperty(value = "操作日期", required = true)
    private java.time.LocalDateTime createdate;

}

