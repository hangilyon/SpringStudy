package com.care.car;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SubClass {
	public void func() {
		//Car car = new Controller_v1_1();
		String path = "classpath:applicationCAR.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		Car car = ctx.getBean("car",Car.class);
		
		System.out.println("서브 실행");
		car.speed();
	}
}
