package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class a20170827_吉比特_字符串和数字排序_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HashMap<Integer,Character> hs = new HashMap<Integer,Character>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		while(sc.hasNext()){
			String str = sc.nextLine();
			char []ch = str.toCharArray();
			for(int i=0;i<ch.length;i++){
				hs.put(ch[i]-'a', ch[i]);
				if((ch[i]-'a')>=0&&(ch[i]-'z')<=0){
					list.add(ch[i]-'a');
				}
				else{
					list2.add(ch[i]-'a');
				}
			}
			Collections.sort(list);
			Collections.sort(list2);
			for(Integer it:list){
				System.out.print(hs.get(it));
			}
			for(Integer it:list2){
				System.out.print(hs.get(it));
			}
			System.out.println();
		}
	}

}