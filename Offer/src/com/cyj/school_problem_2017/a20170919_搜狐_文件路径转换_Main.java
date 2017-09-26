package com.cyj.school_problem_2017;

import java.util.Scanner;
import java.util.Stack;

public class a20170919_搜狐_文件路径转换_Main {

/*
/a/./b/../../c/

*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in );
		while(sc.hasNext()){
			String str = sc.nextLine();
			String result = path(str);
			System.out.println(result);
		}
	}
	public static String path(String str){
		String []tmp = str.split("/");
//		for(int i=0;i<tmp.length;i++){
//			System.out.println(tmp[i]);
//		}
		Stack<String> st = new Stack<String>();
		String result = "";
		for(int i=0;i<tmp.length;i++){
			if((!tmp[i].equals(""))
					&&(!tmp[i].equals("."))
					&&(!tmp[i].equals(".."))){
				st.push(tmp[i]);
			}
			if(!st.isEmpty()&&tmp[i].equals("..")){
				st.pop();
			}
		}
		if(st.isEmpty()){
			result="/";
			return result;
		}
		for(String strIt:st){
			result = result+"/"+strIt;
		}
		return result;
	}
}
