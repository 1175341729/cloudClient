package com.cloud.client;

import org.springframework.stereotype.Component;

@Component
public class ConsumerFeignFallBack implements ConsumerFeign {
    @Override
    public String consumeActive() {
        return "服务器异常请稍后重试...";
    }
}
