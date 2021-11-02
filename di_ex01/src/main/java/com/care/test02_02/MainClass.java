package com.care.test02_02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String path="classpath:application_test02_02.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		SaveClass sc = ctx.getBean("sc",SaveClass.class);
		
		Scanner input = new Scanner(System.in);
		System.out.println("연산할 값 입력");
		sc.setNum1(input.nextInt());
		sc.setOp(input.next());
		sc.setNum2(input.nextInt());
		
		sc.operationClass(); sc.printClass();
	}
}
