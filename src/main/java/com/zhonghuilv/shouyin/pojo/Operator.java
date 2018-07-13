
package com.zhonghuilv.shouyin.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

/**
 * Created by llk2014  on 2018-07-04 17:13:49
 */
@ApiModel("操作员表")
@Table(name = "operator")
@Data
public class Operator {

    @Id
	@OrderBy("desc")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer operatorno;

    @ApiModelProperty(value = "操作员姓名")
    private String operatorname;

    @ApiModelProperty(value = "操作员电话号码")
    private Integer telephone;

    @ApiModelProperty(value = "操作员登陆密码", required = true)
    private String password;

    @ApiModelProperty(value = "操作员权限 1；超级管理员，2:操作员", required = true)
    private Integer opetatorauthority;

}

