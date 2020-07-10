package com.joanna.roomrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RoomRatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomRatingApplication.class, args);
    }

}
