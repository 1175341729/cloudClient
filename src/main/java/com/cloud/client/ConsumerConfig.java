package com.cloud.client;

import com.aliyun.openservices.ons.api.Consumer;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

/***
 *  @Author dengwei
 *  @Description: TODO
 *  @Date 2018/7/12 14:46
 */
@Configuration
public class ConsumerConfig {

    private static Consumer consumer;

    @PostConstruct
    public void init(){
        Properties consumerProperties = new Properties();
        consumerProperties.setProperty(PropertyKeyConst.ConsumerId, "CID_dengwei_topic_consumer");
        consumerProperties.setProperty(PropertyKeyConst.AccessKey, "LTAI7CdTu6sOsvQ4");
        consumerProperties.setProperty(PropertyKeyConst.SecretKey, "9z1h1SqL9zjdRHb4tZh9ZkOkZqBhgY");
        //consumerProperties.setProperty(PropertyKeyConst.ConsumeThreadNums,MqConfig.THREAD_NUM);
        consumerProperties.setProperty(PropertyKeyConst.ONSAddr, "http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet");
        consumer = ONSFactory.createConsumer(consumerProperties);
    }

    @Bean
    public Consumer consumerFactory(){
        consumer.subscribe("dengwei_topic", "*", new MyMessageListener());//对应的消费者监听器
        consumer.start();
        return consumer;
    }

    @Bean
    public Consumer consumerFactory2(){
        consumer.subscribe("dengwei_topic2", "*", new MyMessageListener2());//对应的消费者监听器
        consumer.start();
        return consumer;
    }
}
