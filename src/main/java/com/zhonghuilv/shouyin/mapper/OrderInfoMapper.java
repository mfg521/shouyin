package com.zhonghuilv.shouyin.mapper;

import com.zhonghuilv.shouyin.common.CommonMapper;
import com.zhonghuilv.shouyin.pojo.OrderInfo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderInfoMapper extends CommonMapper<OrderInfo> {

    public void updateOrderInfo(OrderInfo orderInfo);
}