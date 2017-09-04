package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Scanner;

public class a20170831_老师改卷子序列 {
/*
4
2 3 3 1


2
10 20


*/
	//获得全排列，然后对每个序列进行判断
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in );
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scanner.nextInt();
			}
			if(n==1){
				System.out.println("No");
			}
			if(judg(arr)){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
		}
	}
	public static boolean judg(int arr[]){
		int k = 0;
		ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
		getAll(arr,k,allList);
		ArrayList<String> together = new ArrayList<String>();
		for(ArrayList<Integer> list:allList){
			String str="";
			for(Integer intNum:list){
				//System.out.print(intNum);
				str=str+intNum.toString()+",";
			}
			//System.out.println(str);
			//together.add(str);
			if(judg2(list)){
				return true;
			}
		}
/*		for(String it:together){
			System.out.println(it);
		}*/
		return false;
	}
	public static boolean judg2(ArrayList<Integer> list){
		int x=0;
		x=list.get(0);
		int count=1;
		int sum=0;
		boolean bl1=true;
		boolean bl2=true;
		for(Integer it:list){
			if(count==1){
				count++;
				continue;
			}
			x=x-it;
			//System.out.println(count+","+x);
			if(x<0){
				bl1 = false;
				break;
			}
			x=x+it;
			sum = it+sum;
			count++;
		}
		if(x>sum){
			bl2=false;
		}
		if(bl1&bl2){
			return true;
		}
		return false;
	}
	public static void getAll(int []numbers,int k,ArrayList<ArrayList<Integer>> allList){
		if(k==numbers.length){
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<numbers.length;i++){
				list.add(numbers[i]);
			}
			allList.add(list);
			return;
		}
		for(int i=k;i<numbers.length;i++){
			swap(numbers,i,k);
			getAll(numbers,k+1,allList);
			swap(numbers,i,k);
		}
	}
	public static void swap(int []numbers,int x,int y){
		int tmp = numbers[x];
		numbers[x]=numbers[y];
		numbers[y]=tmp;
	}
}
