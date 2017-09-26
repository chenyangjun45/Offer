package com.cyj.school_problem_2017;

import java.util.Scanner;

public class a20170910_爱奇艺_判断平方根之和的平方为整数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int count = 0;
			for(int i=1;i<=n;i++){
				for(int j=1;j<=m;j++){
					double re = Math.pow((Math.sqrt(i)+Math.sqrt(j)), 2);
					if(i==j){
							count++;
						}
					else if(isIntegerForDouble(re)){
						//System.out.print(i+",");
						//System.out.println(j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	//判断double是否为整数
	public static boolean isIntegerForDouble(double obj) {  
	    double eps = 1e-10;  // 精度范围  
	    return obj-Math.floor(obj) < eps;  
	}  
}
