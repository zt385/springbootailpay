package com.zt.ailpayzt.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101800714786";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPtqOopKqq3yrOOe9MgveD8sXK9XKDz+a/w1NVZVUm6df5qtIU4WfEsmWuwkcdwGScLCx+xZFtdVXXxH2DjFzq2Eu44409HanyBefuyor6+21MHrSNuqM3TJGqR/QYY274dBEiv7dMM0WZdr36pgtyUut5KJVxm6kJUNyhPFwGgcouEpBRHSwl/kH0EG/W+RE806Ay+piYSW1IjowCT3Txq2gBJqu/BX0rPxmHrYqXbTVvxS4KimstxmpRavzBa6lr7GWE/CdFmw3pO8YVwz02wCA/zGgGh9pmjcVbPPEc6ALB71vYwSuhgHBCL2o4q5UAE6Av/aEsLrNDxsmly3UJAgMBAAECggEAWX/WoDoch1mAIPp3iuCtIKFaiLEe5fPdsmMETNRUmW1cMYIuXw6ZPygSpykafO7KOXBRLYoArXg7Q6p8uCX7381gKv6bgQouQilnbZD5yKA4SwV8UB+BcfjfZnp1C5MxEs3FtixLDMuJdq86VRR/YG0/dC7QEvZr6P9Qx6D9dpcB8TbxtiXOw2zY2hE7ojs5zB7yHTsi3eyZ4z5FjYryAPchhJ1u+wS8M3iAbUUY1Q8lEfMSUpoDTg1Ns+TqRDVaCN3Pw/plglep49WHf1nohnCP3TslEhbek0RjB84bm+hHNCV+x+sL2GzzkZbOJyBnB1yhqQEPerdUcqWkmPSLmQKBgQDROm0I2GHFLwztLR2Z2QKx19NrE3xqk/TvXTJ/P6eWgF074YkC1hBvXR2kFa8wm1Qvuts8dba8uNYdfz1JUbxk30/LGC2pv3gAm2/+2uDvJk5VjEaFQkwa6tDyZlp52v4x3hwoomZji4ESProm5MADF9k5402+ugl5lwKXs3OTxwKBgQCv1vnzBe0CxljPjx/CqfuQ4zViEdLn+R5P+0pU6zJ3PN+2jleTNG2TbiJWaT2GqwV6EIogHJvYdMJc5VSWqghSOL0deyGz4CaDSkMVKjDStboSkjxL7wYXDqFS/Jrjrm0DoXJPt7RKI+rLP9790WbIfZzbTnBUeo7OjkHPYQsQrwKBgQC9JbOSjoN8zndCJ0oeXmgoPLQdleUhOJbyme9fyD0KOwuOaesCDGGZO7XjM9NH/vRRnfw6oTRNUlAHJJNUKDdHffZV5YrKbZTf/6V04Yz9xkSE5CaQrAm/P88bhFqA1PB+RoxwU7h6f5B03Q5OwPexFCtGQO504RxVtqYaXJm82wKBgBB0iL2CX3S0BRmfZjR8XctoR9Wen2MQABMyC/m4bOeVrcXSukVPUbXLR7FYdeaFWKTcqWBp7PerrYit+WWEEfVH1ALPRA8mOdRtfaucYCdH1FrqjnP4sVQ1DUnL097cstz1HdJx+ZA6nj1ZA9Ay6XB3uNcZFxAAzB5uV6BFj5iHAoGAP2kjWOehi6bYqIk7TBA7zBk1AXb0B/RU0GTKDvAhXPbGpO5bwNGD2iAhsAl3xY7GHC6qiDXF+hHcC2Po3Iz1yn9u4RTuW6u/zk/bcuZAX6nDrj215/REuYtXEvhpWwdSIYcfUO2mnPW2gWMRSkRZg2k3ajAp4iEKIA1ShKSH7GE=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
    // 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAj7ajqKSqqt8qzjnvTIL3g/LFyvVyg8/mv8NTVWVVJunX+arSFOFnxLJlrsJHHcBknCwsfsWRbXVV18R9g4xc6thLuOONPR2p8gXn7sqK+vttTB60jbqjN0yRqkf0GGNu+HQRIr+3TDNFmXa9+qYLclLreSiVcZupCVDcoTxcBoHKLhKQUR0sJf5B9BBv1vkRPNOgMvqYmEltSI6MAk908atoASarvwV9Kz8Zh62Kl201b8UuCoprLcZqUWr8wWupa+xlhPwnRZsN6TvGFcM9NsAgP8xoBofaZo3FWzzxHOgCwe9b2MEroYBwQi9qOKuVABOgL/2hLC6zQ8bJpct1CQIDAQAB";

    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

