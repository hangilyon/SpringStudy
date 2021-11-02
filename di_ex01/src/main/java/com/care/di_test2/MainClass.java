package com.care.di_test2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path="classpath:application_test01.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		PrintBean p = ctx.getBean("pb",PrintBean.class);
		p.sp();
	}
}
