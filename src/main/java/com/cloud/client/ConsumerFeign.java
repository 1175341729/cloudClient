package com.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "consume",fallback = ConsumerFeignFallBack.class)
public interface ConsumerFeign {

    @GetMapping("/consumeActive")
    String consumeActive();
}
