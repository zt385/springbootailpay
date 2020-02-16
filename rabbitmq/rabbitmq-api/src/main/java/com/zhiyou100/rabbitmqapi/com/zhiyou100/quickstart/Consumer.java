package com.zhiyou100.rabbitmqapi.com.zhiyou100.quickstart;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class Consumer {
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

        //创建(声明)一个队列
        //参数1:queue
            //2 durable 是否持久化
            //3.exclusive 独占  (这个队列只有我一个channel 能连接)
            //4.autoDelete ]如果脱离了 exchange 就会自动删除
            //5.arguments 扩展分数
        String queueName="test001";
        channel.queueDeclare(queueName,true,false,false,null);

        //创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //设置channel
        //参数1:queue
            //2:autoAck  是否自动签收
            //3.callback    具体得消费者对象
        channel.basicConsume(queueName,true,queueingConsumer);

        while (true){
            //获取消息
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();//参数:设置超时时间
            String msg = new String(delivery.getBody());
            System.out.println("消费段"+msg);
        }

    }
}
