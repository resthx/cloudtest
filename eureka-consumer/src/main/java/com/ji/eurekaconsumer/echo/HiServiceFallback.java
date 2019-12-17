package com.ji.eurekaconsumer.echo;

import org.springframework.stereotype.Component;

@Component
public class HiServiceFallback implements HiService{
    @Override
    public String hi() {
        return "3213213213213211";
    }
}
