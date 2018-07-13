package com.cloud.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.ons.api.Action;
import com.aliyun.openservices.ons.api.ConsumeContext;
import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.MessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.nio.charset.Charset;

/***
 *  @Author dengwei
 *  @Description: TODO
 *  @Date 2018/7/12 14:57
 */
@Component
public class MyMessageListener2 implements MessageListener {
    private static CloudClientController cloudClientController = ApplicationContextUtil.getBean("cloudClientController",CloudClientController.class);

    @Override
    public Action consume(Message message, ConsumeContext consumeContext) {
        byte[] body = message.getBody();
        String content = new String(body, Charset.forName("UTF-8"));

        JSONObject jsonObject = JSON.parseObject(content);
        System.out.println("消息消费：" + jsonObject.toJSONString());

        String client = cloudClientController.cloudClient();
        System.out.println(client);
        return Action.CommitMessage;
    }
}
