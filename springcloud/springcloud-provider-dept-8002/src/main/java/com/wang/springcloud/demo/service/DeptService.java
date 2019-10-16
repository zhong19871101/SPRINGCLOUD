package com.wang.springcloud.demo.service;

import java.util.List;

import com.springcloud.demo.entity.Dept;

public interface DeptService {

	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
