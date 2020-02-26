package com.ji.servicehi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @PreAuthorize("hasAnyAuthority('p1')")
    @RequestMapping("hi")
    public String hi(){
        return "hi";
    }
}
