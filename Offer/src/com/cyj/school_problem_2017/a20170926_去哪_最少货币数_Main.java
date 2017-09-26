package com.cyj.school_problem_2017;

import java.util.Scanner;
/*
3 2 1 3 0 2 620

*/
public class a20170926_去哪_最少货币数_Main {

	public static void main(String[] args) {
		int money[] = { 1, 5, 10, 50, 100, 500 };
		int[] c = new int[6];
		int A = 0;
		int count=0;
		Scanner sc = new Scanner(System.in );
		while (sc.hasNext()) {
			for (int i = 0; i < c.length; i++) {
				c[i] = sc.nextInt();
			}
			A = sc.nextInt();
			for(int i=5;i>=0;i--){
				int t=A/money[i]>c[i]?c[i]:A/money[i];
				A=A-money[i]*t;
				count=t+count;
			}
			if(A==0){
				System.out.println(count);
			}else {
				System.out.println("NOWAY");
			}
		}
	}

}