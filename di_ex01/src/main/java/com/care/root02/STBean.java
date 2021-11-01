package com.care.root02;

// 저장을 담당
public class STBean {
	private String name;
	private int age;
	private Student st;
	
	public void nP() {
		st.namePrint(name);
	}
	public void aP() {
		st.agePrint(age);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student st) {
		this.st = st;
	}
	
}
