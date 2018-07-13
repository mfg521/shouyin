
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:48
 */
@ApiModel("库存退货表")
@Table(name = "stock_back")
@Data
public class StockBack {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockbackno;

    @ApiModelProperty(value = "操作员编号", required = true)
    private Integer operatorno;

    @ApiModelProperty(value = "供货商编号", required = true)
    private Integer supplierno;

    @ApiModelProperty(value = "创建日期", required = true)
    private java.time.LocalDateTime createdate;

}

