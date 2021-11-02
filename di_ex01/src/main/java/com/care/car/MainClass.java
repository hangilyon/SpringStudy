package com.care.car;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//Car car = new Controller_v1_1();
		String path = "classpath:applicationCAR.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		Car car = ctx.getBean("car",Car.class);
		
		System.out.println("메인 실행");
		car.speed();
		SubClass sc = new SubClass();
		sc.func();
	}
}
