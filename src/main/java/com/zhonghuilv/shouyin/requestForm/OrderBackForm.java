package com.zhonghuilv.shouyin.requestForm;

import com.zhonghuilv.shouyin.pojo.OrderBack;
import com.zhonghuilv.shouyin.pojo.OrderBackDetails;
import lombok.Data;

import java.util.List;

@Data
public class OrderBackForm {

    private OrderBack orderBack;
    private List<OrderBackDetails> orderBackDetailsList;
}
