package com.care.test02;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String path="classpath:application_test02.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(path);
		SaveClass sc = ctx.getBean("SC",SaveClass.class);
		System.out.print("연산 숫자 1 입력 : ");
		sc.setNum1(input.nextInt());
		System.out.print("연산 숫자 2 입력 : ");
		sc.setNum2(input.nextInt());
		System.out.print("연산 부호 입력 : ");
		sc.setOp(input.next());
		sc.operationClass(); sc.printClass();
	}
}
