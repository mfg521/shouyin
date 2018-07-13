
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by mengfanguang  on 2018-07-12 16:27:56
 */
@ApiModel("库存表")
@Table(name = "stock")
@Data
public class Stock {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockno;

    @ApiModelProperty(value = "商品条形码", required = true)
    private String articleBarcode;

    @ApiModelProperty(value = "库存数量", required = true)
    private Integer num;

    @ApiModelProperty(value = "有效期")
    private java.time.LocalDateTime expridate;

}

