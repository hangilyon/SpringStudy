package com.care.di_test2;

import com.care.di_test.PrintString;

public class PrintBean {
	private String print;
	private PrintString ps;
	
	public void sp() {
		ps.printString(print);
	}
	public String getPrint() {
		return print;
	}
	public void setPrint(String print) {
		this.print = print;
	}
	public PrintString getPs() {
		return ps;
	}
	public void setPs(PrintString ps) {
		this.ps = ps;
	}
	
}