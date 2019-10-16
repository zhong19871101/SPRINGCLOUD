package com.wang.springcloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableDiscoveryClient //服务发现
@EnableEurekaClient
public class SpringcloudConsumer80_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringcloudConsumer80_App.class, args);
	}

}
