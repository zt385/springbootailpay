package com.zt.ailpayzt.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zt.ailpayzt.config.AlipayConfig;
import com.zt.ailpayzt.mapper.CompetitionMapper;
import com.zt.ailpayzt.mapper.OrderMapper;
import com.zt.ailpayzt.pojo.Competition;
import com.zt.ailpayzt.pojo.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class AilpayController {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private CompetitionMapper competitionMapper;

    @RequestMapping("index")


    @PostMapping("/AliPay")
    public String goPay(HttpServletRequest request){
        String clientId = request.getParameter("cID");
        Competition current = competitionMapper.selectById(clientId);
        System.out.println(clientId);
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        //商户订单号，商户网站订单系统中唯一订单号，必填
        Date date = new Date();
        String out_trade_no = Long.toString(date.getTime());
        //付款金额，必填
        String total_amount = String.valueOf(current.getGoodmoney());
        //订单名称，必填
        String subject = current.getGoodName();
        //商品描述，可空
        String body = current.getGoodDesc();
        // 该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
        String timeout_express = "1c";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\""+ timeout_express +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        try {
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            System.out.println(result);
            Order order = new Order();
            order.setOrderTiem(out_trade_no);
            order.setOrderMoney(Float.valueOf(total_amount));
            order.setOrderGoodId(clientId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            order.setOrderCreatTime(sdf.format(new Date()));
            int flag = orderMapper.insert(order);
            if (flag==0){
                return "创建订单失败";
            }
            return result;
        }catch (Exception e){
            System.out.println("订单请求错误");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("status",500);
            return "fail";
        }


    }

}
