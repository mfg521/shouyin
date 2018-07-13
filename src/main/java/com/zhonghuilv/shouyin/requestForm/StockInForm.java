package com.zhonghuilv.shouyin.requestForm;

import com.zhonghuilv.shouyin.pojo.Stockin;
import com.zhonghuilv.shouyin.pojo.StockinDetails;
import lombok.Data;

import java.util.List;

@Data
public class StockInForm {

    private Stockin stockin;

    private List<StockinDetails> stockinDetailsList;

}
