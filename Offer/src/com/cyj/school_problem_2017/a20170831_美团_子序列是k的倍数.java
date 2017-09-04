package com.cyj.school_problem_2017;

import java.util.Scanner;

public class a20170831_美团_子序列是k的倍数{
	
/*
4
2 3 3 1

*/

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in );
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			int arr[]=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=scanner.nextInt();
				System.out.println(arr[i]);
			}
			int x=scanner.nextInt();
			System.out.println(solution(arr,x));
		}
	}
	private static int solution(int[] a, int k) {
		for (int i = 0; i <a.length; i++) {
			for (int bg = 0, end = a.length- i; end<=a.length; bg++, end++) {
				int sum=0;
				for(int j=bg;j<end;j++){
					sum+=a[j];
				}
				if(sum%k==0){
					return end-bg;
				}
			}
		}
		return 0;
	}

}

