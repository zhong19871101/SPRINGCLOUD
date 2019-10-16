package com.wang.springcloud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.demo.entity.Dept;
import com.wang.springcloud.demo.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DeptController {
	@Autowired
	private DeptService service;
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept =  this.service.get(id);

		if(null == dept)
		   {
		     throw new RuntimeException("该ID："+id+"没有没有对应的信息");
		   }

		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id)
		           .setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
		           .setDb_source("no this database in MySQL");

	}
	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	@HystrixCommand
	public List<Dept> list()
	{
		Dept dept = new  Dept();
		dept.setDeptno(8001L);
		dept.setDname("8001");
		dept.setDb_source("8001");
		log.info("这里访问的是8001");
		List<Dept> list = service.list();
		list.add(dept);
		return list;
	}

	
//	@Autowired
//	private DiscoveryClient client;
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

}