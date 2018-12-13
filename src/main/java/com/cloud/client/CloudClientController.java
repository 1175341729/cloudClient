package com.cloud.client;

import com.cloud.client.mapper.UserMapper;
import com.cloud.client.model.User;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class CloudClientController {
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancerClient loadBalancerClient;
    @Resource
    private ConsumerFeign consumerFeign;
    @Resource
    private UserMapper userMapper;

    @GetMapping("/cloudClient")
    public String cloudClient(){
        List<String> services = discoveryClient.getServices();
        services.forEach(str -> System.out.println(str));
        return "cloudClient";
    }

    @GetMapping("/consume")
    public String consume(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("consume");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/consumeActive";
        return restTemplate.getForObject(url,String.class);

    }

    @GetMapping("/consumerFeign")
    public String consumer() throws InterruptedException {
        return consumerFeign.consumeActive();
    }

    @PostMapping("/post")
    public String post(@RequestBody Map<String,Object> param){
        return "1234";
    }

    @GetMapping("/insertUser")
    public Integer insertUser(){
        User user = new User();
        user.setName("XXX");
        user.setAge(26);
        int id = userMapper.insert(user);

        return 0;
    }
}
