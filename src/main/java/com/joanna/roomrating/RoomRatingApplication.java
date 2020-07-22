package com.joanna.roomrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableDiscoveryClient
@EnableResourceServer
@SpringBootApplication
public class RoomRatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomRatingApplication.class, args);
    }

}
