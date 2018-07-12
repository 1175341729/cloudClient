package com.cloud.client;

import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;

import java.nio.charset.Charset;

/***
 *  @Author dengwei
 *  @Description: TODO
 *  @Date 2018/7/12 14:57
 */
public class MyMessageListener implements MessageListener {
    private static CloudClientController cloudClientController = ApplicationContextUtil.getBean("cloudClientController",CloudClientController.class);
    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        byte[] body = message.getBody();
        String content = new String(body, Charset.forName("UTF-8"));
        System.out.println("消息消费：" + content);

        String client = cloudClientController.cloudClient();
        System.out.println(client);
        return Action.CommitMessage;
    }
}
