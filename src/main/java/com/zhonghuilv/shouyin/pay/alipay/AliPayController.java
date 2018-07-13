package com.zhonghuilv.shouyin.pay.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;

import java.math.BigDecimal;

public class AliPayController {

	/**
	 * 支付宝下单
	 * @param outTradeNo 订单编号
	 * @param authCode 条形码
	 * @param totalAmount 订单总额
	 * @return
	 * @throws AlipayApiException
	 */
	public  AlipayTradePayResponse Apipay(String outTradeNo, String authCode, String totalAmount) throws AlipayApiException {
		String  APP_PRIVATE_KEY=Const.APP_PRIVATE_KEY;
		String appid=Const.APP_ID;
		String ALIPAY_PUBLIC_KEY=Const.alipay_public_key;
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","2017012605433955",
				APP_PRIVATE_KEY, "JSON", "utf-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
		AlipayTradePayRequest request = new AlipayTradePayRequest();
		AlipayTradePayModel model = new AlipayTradePayModel();
		request.setBizModel(model);
		model.setOutTradeNo(outTradeNo);
		model.setSubject("Iphone6 16G");
		model.setTotalAmount(totalAmount.toString());
		model.setAuthCode(authCode);
		model.setScene("bar_code");
		AlipayTradePayResponse response = null;
		try {
			response = alipayClient.execute(request);
			return response;

		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 阿里交易查询接口
	 * @param outTradeNo 查询订单号，对应订单表里面的orderinfoUUID
	 * @return
	 * @throws AlipayApiException
	 */
	public  AlipayTradeQueryResponse AlipayQuery(String outTradeNo) throws AlipayApiException {
		String  APP_PRIVATE_KEY=Const.APP_PRIVATE_KEY;
		String appid=Const.APP_ID;
		String ALIPAY_PUBLIC_KEY=Const.alipay_public_key;
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","2017012605433955",
				APP_PRIVATE_KEY, "JSON", "utf-8", ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
		AlipayTradeQueryModel model=new AlipayTradeQueryModel();
		model.setOutTradeNo(outTradeNo);
		//model.setOutTradeNo(outTradeNo);
		request.setBizModel(model);
		AlipayTradeQueryResponse response = alipayClient.execute(request);
		if(response.isSuccess()){
			return response;
		} else {
			System.out.println("调用失败");
		}
		return null;
	}
}
