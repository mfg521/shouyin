package com.zhonghuilv.shouyin.pay.wxpay;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;




public class WXPayTest {
	/**
	 * 订单交易
	 * @return
	 */
	public  Map<String, String> getWXpay(String outTradeNo, String authCode, String totalAmount) {
		try {
			String nonce_str = CommonUtils.getUUID();
			Map<String, String> signParams = new HashMap<String, String>();
			signParams.put("appid","wxeb98d5d9b1f45c0d");
			signParams.put("mch_id", "1280850401");
			signParams.put("nonce_str", nonce_str);
			signParams.put("body", "石燕湖微信测试");
			signParams.put("out_trade_no", outTradeNo);
			signParams.put("fee_type", "CNY");
			signParams.put("total_fee", totalAmount); // 金额
			signParams.put("auth_code", authCode);
			String sign_1 = WXPayUtil.generateSignedXml(signParams,"gsk4lkds9sdadsm7m3mhnn23h43jjk23");
			String xml = new String(sign_1.getBytes(), "utf-8");//解决中文签名错误
			String returnXml = WXPayUtil.post("https://api.mch.weixin.qq.com/pay/micropay", xml);
			Map<String, String> xmlToMap = WXPayUtil.xmlToMap(returnXml);
			return  xmlToMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 查询订单
	 * @return
	 */
	public  Map<String, String> getWXpayOrder(String outTradeNo) {
		try {
			String nonce_str = CommonUtils.getUUID();
			Map<String, String> signParams = new HashMap<String, String>();
			signParams.put("appid","wxeb98d5d9b1f45c0d");
			signParams.put("mch_id", "1280850401");
			signParams.put("nonce_str", nonce_str);
			signParams.put("out_trade_no", outTradeNo);
			String sign_1 = WXPayUtil.generateSignedXml(signParams,"gsk4lkds9sdadsm7m3mhnn23h43jjk23");
			String xml = new String(sign_1.getBytes(), "utf-8");//解决中文签名错误
			String returnXml = WXPayUtil.post("https://api.mch.weixin.qq.com/pay/orderquery", xml);
			Map<String, String> xmlToMap = WXPayUtil.xmlToMap(returnXml);
			return  xmlToMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
