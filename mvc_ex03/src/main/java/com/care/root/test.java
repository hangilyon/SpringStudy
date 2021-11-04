package com.care.root;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int [] arr = new int[10];
		for(int i=0;i<10;i++) {
			int n = sc.nextInt();
			arr[i] = n%42;
			for(int j=1; j<10; j++) {
				if(arr[i]==arr[j]) {
					
				}
			}
		}
	}
}
