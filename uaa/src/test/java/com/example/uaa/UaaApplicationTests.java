package com.example.uaa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UaaApplicationTests {

    @Test
    void contextLoads() {

    }

    public static void main(String[] args) {
        String aa = new BCryptPasswordEncoder().encode("111111");
        System.out.println(aa);
    }
}
