package com.zhiyou100.rabbitmqapi.com.zhiyou100.quickstart;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Procuder {
    public static void main(String[] args) throws Exception{
        //创建一个ConnectionFactory,并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.126.131");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        //通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //通过connection创建一个channel
        Channel channel = connection.createChannel();

        //通过channel 发送数据
        //参数1:exchange  生产者发消息 需要exchange+routingkey
        //2:routingkey
        //3:props 附加属性
        //4:body 内容(消息的实体)
        for (int i = 0; i < 5; i++) {
            String msg ="Hello RabbitMQ";
            channel.basicPublish("","test001",null,msg.getBytes());//需要传递字节数组
        }

        //记得关闭连接
        channel.close();
        connection.close();
    }
}
