package com.ji.eurekaconsumer.echo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-hi",fallback = HiServiceFallback.class)
public interface HiService {
    @GetMapping("hi")
    public String hi();
}
