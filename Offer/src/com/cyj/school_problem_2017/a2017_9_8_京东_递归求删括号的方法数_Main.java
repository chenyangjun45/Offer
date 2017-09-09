package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Scanner;

public class a2017_9_8_京东_递归求删括号的方法数_Main {
/*
 * aa
(((())))

()()


 */
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
		while(sr.hasNext()){
			String seq = sr.nextLine();
			//int count=0;//结果计数
			char[] ch = seq.toCharArray();
			int n = ch.length;
			if(n==2){
				count=1;
				System.out.println(1);
			}
			else{
				deal(ch);
				System.out.println(count);
			}
			count=0;
		}
	}
	public static char[] del(char[] ch,int i) {
		int n = ch.length;
		char[] ch2 = new char[n-1];
		for(int x=0;x<n;x++){
			if(x<i){
				ch2[x]=ch[x];
			}
			if(x>i){
				ch2[x-1]=ch[x];
			}
		}
		return ch2;
	}
	public static void deal(char[] ch){
		//递归返回条件
//		if(ch.length==0){
//			count++;
//			return;
//		}
		int n=ch.length;
		//删除左括号
		char []ch2 = new char[n-1];
		for(int i=0;i<n;i++){
			if(ch[i]=='('){
				char []chTmp = del(ch,i);
				for(int j=0;j<ch2.length;j++){
					ch2[j]=chTmp[j];
					//System.out.print(ch2[j]);
				}
				break;
			}
		}
		//System.out.println();
		//不断删除右括号，合法则递归
		for(int x=0;x<ch2.length;x++){
			if(ch2[x]==')'){
				//System.out.println("右括号"+x);
				if(ch2.length==1){
					count++;
					//System.out.println("count");
					return;
				}
				else{
					char []chTmp2 = del(ch2,x);
					//System.out.println(new String(chTmp2));
					if(isValid(new String(chTmp2))){
						//System.out.println("递归");
						deal(chTmp2);
					}
					else{
						return;
					}
				}
			}
		}
		return ;
	}
	public static boolean isValid(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		char[] chas = str.toCharArray();
		int stat = 0;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ')' && chas[i] != '(') {
				return false;
			}
			if (chas[i] == ')' && --stat < 0) {
				return false;
			}
			if (chas[i] == '(') {
				stat++;
			}
		}
		return stat == 0;
	}
}
