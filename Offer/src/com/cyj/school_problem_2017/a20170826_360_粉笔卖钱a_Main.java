package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class a20170826_360_粉笔卖钱a_Main {
/*
5 5
1 2 3 3
2 1 3


5 15
1 2 3 6
2 1 3


*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();//彩色
			int m=sc.nextInt();//白色
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int d=sc.nextInt();
			int x=sc.nextInt();
			int y=sc.nextInt();
			int z=sc.nextInt();
			//每种最大的个数
			int max1 = Math.min(n/a, m/b);
			int max2 = m/c;
			int max3 = n/d;
			ArrayList<Integer> result = new ArrayList<Integer>();
			//枚举所有结果
			int curBig = 0;
			for(int i=0;i<=max1;i++){
				for(int j=0;j<=max2;j++){
					for(int x1=0;x1<=max3;x1++){
						if(((i*b+j*c)<=n)
								&&(i*a+x1*d)<=m){
							int curResult = x*i+y*j+z*x1;
							//result.add(curResult);
							if(curResult>=curBig){
								curBig=curResult;
							}
						}
					}
				}
			}
			//Collections.sort(result);
			System.out.println(curBig);
		}
	}

}
