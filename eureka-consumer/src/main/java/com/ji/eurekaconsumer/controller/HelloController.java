package com.ji.eurekaconsumer.controller;


import com.ji.eurekaconsumer.echo.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @Autowired
    private LoadBalancerClient client;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HiService hiService;
    @GetMapping("test")
    public String test(@RequestParam String name){
        ServiceInstance choose = client.choose("service-hi");
        name += "!";
        String url = "http://" + choose.getHost() + ":" + choose.getPort() + "/hi";
        return restTemplate.getForObject(url,String.class);
    }
    @GetMapping("test1")
    public String test1(){
        return hiService.hi();
    }
}
