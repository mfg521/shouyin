package com.zhonghuilv.shouyin.service.impl;

import com.zhonghuilv.shouyin.mapper.StockMapper;
import com.zhonghuilv.shouyin.mapper.StockinDetailsMapper;
import com.zhonghuilv.shouyin.mapper.StockinMapper;
import com.zhonghuilv.shouyin.pojo.Stock;
import com.zhonghuilv.shouyin.pojo.Stockin;
import com.zhonghuilv.shouyin.pojo.StockinDetails;
import com.zhonghuilv.shouyin.requestForm.StockInForm;
import com.zhonghuilv.shouyin.service.StockinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by llk2014  on 2018-07-04 17:13:47
 */
@Service
public class StockinServiceImpl  implements StockinService {

    @Autowired
    private StockinMapper stockinMapper;

    @Autowired
    private StockinDetailsMapper stockinDetailsMapper;

    @Autowired
    private StockMapper stockMapper;


    /**
     * 入库
     * @param stockInForm
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public StockInForm save(StockInForm stockInForm){
        Stockin stockin = stockInForm.getStockin();
        String stockinuuid=getUUId();
        stockin.setStockinuuid(stockinuuid);
        stockinMapper.insertUseGeneratedKeys(stockin);
        List<StockinDetails> stockinDetailsList=stockInForm.getStockinDetailsList();
        for(StockinDetails stockinDetails:stockinDetailsList){

            stockinDetails.setStockinuuid(stockinuuid);
            stockinDetailsMapper.insertUseGeneratedKeys(stockinDetails);
            String artitleBarcode=stockinDetails.getArticleBarcode();
            Stock stock = stockMapper.selectByArticleCode(artitleBarcode);

            Integer num=stock.getNum();
            stock.setNum(num+=stockinDetails.getNum());
            stockMapper.updateStock(stock);

            return stockInForm;
        }


        return stockInForm;
    }

    /**
     * 根据时间生成订单号
     *
     * @return
     */
    public static String getUUId() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String nowStr = simpleDateFormat.format(date);
        return nowStr;
    }
}
