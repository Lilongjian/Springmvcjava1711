package com.situ.ssm.entity;

import java.util.List;

public class StudentBean {
	private List<Student> list;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "StudentBean [list=" + list + "]";
	}
	

}
