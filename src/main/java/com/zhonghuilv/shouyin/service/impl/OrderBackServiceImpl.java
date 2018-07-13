package com.zhonghuilv.shouyin.service.impl;

import com.zhonghuilv.shouyin.mapper.OrderBackDetailsMapper;
import com.zhonghuilv.shouyin.mapper.OrderBackMapper;
import com.zhonghuilv.shouyin.mapper.StockMapper;
import com.zhonghuilv.shouyin.pojo.OrderBack;
import com.zhonghuilv.shouyin.pojo.OrderBackDetails;
import com.zhonghuilv.shouyin.pojo.Stock;
import com.zhonghuilv.shouyin.requestForm.OrderBackForm;
import com.zhonghuilv.shouyin.service.OrderBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by mengfanguang  on 2018-07-04 17:13:47
 */
@Service
public class OrderBackServiceImpl  implements OrderBackService {

    @Autowired
    private OrderBackMapper orderBackMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private OrderBackDetailsMapper orderBackDetailsMapper;

    /**
     * 退款
     * @param model
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderBack orderback(OrderBackForm model){
        //生成orderbackUUID并将orderBack插入数据库。
        OrderBack orderBack = model.getOrderBack();
        String orderBackUUID=getOrderUUId();
        orderBack.setOrderbackuuid(orderBackUUID);
        orderBackMapper.insertUseGeneratedKeys(orderBack);

        //循环orderBackDetailsList 并插入到表，每一个orderBackDetails对应的orderBackUUID都是之前生成的
        List<OrderBackDetails> orderBackDetails = model.getOrderBackDetailsList();
        for(OrderBackDetails orderBackDetail: orderBackDetails){
            orderBackDetail.setOrderbackuuid(orderBackUUID);
            orderBackDetailsMapper.insertUseGeneratedKeys(orderBackDetail);

            //获取商品条码，销售数量，在库存表中对应减去销售的数量
            String articleCode = orderBackDetail.getArticleBarcode();
            Integer num = orderBackDetail.getNum();
            Stock stock=stockMapper.selectByArticleCode(articleCode);
            stock.setNum(stock.getNum()+num);
            stockMapper.updateStock(stock);
        }
        return orderBack;
    }

    /**
     * 根据时间生成订单号
     * @return
     */
    public static String getOrderUUId(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        Date date=new Date();
        String nowStr=simpleDateFormat.format(date);
        return nowStr;
    }
}
