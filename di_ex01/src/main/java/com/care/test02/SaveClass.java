package com.care.test02;

public class SaveClass {
	private int num1, num2, result;
	private String op;
	private PrintClass pc;
	private OperationClass oc;
	
	public void operationClass() {
		this.result = getOc().operation(this.num1,this.num2,this.op);
	}
	public void printClass() {
		getPc().printFunc(this.num1,this.op,this.num2,this.result);
	}
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
	public PrintClass getPc() {
		return pc;
	}
	public void setPc(PrintClass pc) {
		this.pc = pc;
	}
	public OperationClass getOc() {
		return oc;
	}
	public void setOc(OperationClass oc) {
		this.oc = oc;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}

	
}
