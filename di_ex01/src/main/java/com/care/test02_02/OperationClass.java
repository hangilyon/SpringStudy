package com.care.test02_02;

public class OperationClass {
	public int operation(int n1, int n2, String op) {
		if(op.equals("+")) {
			return n1+n2;
		}else {
			return n1-n2;
		}
	}
}
