package com.cyj.real_test;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String str="";
		while(sc.hasNext()){
			n = sc.nextInt();
			System.out.println((float)(n*(n+1)/2));
			str = sc.nextLine();
		}
	}

}
