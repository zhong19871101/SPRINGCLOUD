package com.wang.springcloud.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard9001_App {

	public static void main(String[] args)
	  {
	   SpringApplication.run(ConsumerHystrixDashboard9001_App.class,args);
	  }

}
