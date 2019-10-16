package com.wang.springcloud.consumer.contorller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.demo.entity.Dept;
import com.springcloud.demo.service.DeptClientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DeptController_Consumer {


	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return this.service.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}
	
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		log.info("进来了");
		return this.service.list();	
	}


}
