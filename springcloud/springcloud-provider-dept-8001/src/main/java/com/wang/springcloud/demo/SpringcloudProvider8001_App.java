package com.wang.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
public class SpringcloudProvider8001_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(SpringcloudProvider8001_App.class, args);
	}

}
