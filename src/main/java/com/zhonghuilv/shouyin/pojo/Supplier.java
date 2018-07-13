
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:48
 */
@ApiModel("供应商表")
@Table(name = "supplier")
@Data
public class Supplier {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierno;

    @ApiModelProperty(value = "供货商名称", required = true)
    private String suppliername;

    @ApiModelProperty(value = "联系人姓名", required = true)
    private String connecperson;

    @ApiModelProperty(value = "联系电话")
    private Integer telephone;

    @ApiModelProperty(value = "地址")
    private String address;

}

