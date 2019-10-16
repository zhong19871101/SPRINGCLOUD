package com.springcloud.demo.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
//@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7338848899605278971L;
	private Long 	deptno; // ����
	private String 	dname; // ��������
	private String 	db_source;// �����Ǹ����ݿ⣬��Ϊ΢����ܹ�����һ�������Ӧһ�����ݿ⣬ͬһ����Ϣ���洢����ͬ���ݿ�
	
	public Dept(String dname)
	{
		super();
		this.dname = dname;
	}
}
