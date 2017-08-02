package com.cyj.school_problem_2016;

import java.util.Scanner;

public class a2_懂二进制 {

	/*	题目描述
	世界上有10种人，一种懂二进制，一种不懂。那么
	你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
	
	输入
	1999 2299
	
	输出
	7
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x1=0;
		int x2=0;
		int count=0;
		while(sc.hasNext()){
			x1 = sc.nextInt();
			x2 = sc.nextInt();
			//方法一
//			char []ch1 = Integer.toBinaryString(x1).toCharArray();
//			char []ch2 = Integer.toBinaryString(x2).toCharArray();
//			System.out.println(ch1);
//			System.out.println(ch2);
//			int length1 = ch1.length;
//			int length2 = ch2.length;
//			int minLength = Math.min(length1, length2);
//			System.out.println(minLength);
//			for(int k=1;k<=minLength;k++){
//				if(ch1[k]!=ch2[k]){
//					count++;
//				}
//			}
//			System.out.println(count);
			
			//方法二
			//亦或运算，相同为0，不同为1
			int dif=x1^x2;
			System.out.println(dif);
			int count2=0;
			while(dif!=0){
				dif = dif&(dif-1);
				count2++;
			}
			System.out.println(count2);
			//方法3
			int dif2=x1^x2;
			System.out.println(dif2);
			int count3=0;
			char []chDif = Integer.toBinaryString(dif2).toCharArray();
			for(char chTmp:chDif){
				if(chTmp=='1'){
					count3++;
				}
			}
			System.out.println(count3);
		}
	}

}
