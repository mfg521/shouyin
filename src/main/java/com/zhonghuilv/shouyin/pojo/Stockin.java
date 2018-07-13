
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:47
 */
@ApiModel("库存入库表")
@Table(name = "stockin")
@Data
public class Stockin {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockinno;

    @ApiModelProperty(value = "入库的编号UUID", required = true)
    private String stockinuuid;

    @ApiModelProperty(value = "供货商编号", required = true)
    private Integer supplierno;

    @ApiModelProperty(value = "操作员编号", required = true)
    private Integer operatorno;

    @ApiModelProperty(value = "入库时间", required = true)
    private java.time.LocalDateTime stockindate;

}

