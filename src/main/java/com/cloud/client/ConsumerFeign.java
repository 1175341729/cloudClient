package com.cloud.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "dynamic",fallback = ConsumerFeignFallBack.class)
public interface ConsumerFeign {

    @GetMapping("/dynamic/student")
    String consumeActive();
}
