package com.cyj.real_test;

import java.util.Scanner;

public class 今日头条_极大极小值 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//String name = "";
		while(sc.hasNext()){
			int n=0;
			String data = "";
			n=sc.nextInt();
			int[] num=new int[n];
			int[] num2=new int[n];
			int count=0;
			//ArrayList<Integer> intList = new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				num[i]=sc.nextInt();
				//System.out.println(num[i]);
			}
			if(n==1){
				System.out.println(num[0]);
			}
			else if(n>1){
				if(num[0]<num[1]){
					num2[0]=0;
				}
				for(int j=1;j<n-1;j++){
					if(((num[j]<num[j-1])&&num[j]<num[j+1])){
						count++;
						num2[count]=j;
					}
				}
				if(num[n-1]<num[n-2]){
					count++;
					num2[count]=n-1;
				}
				//找最大的
				int bigbig=0;
				int pos = 0;
				for(int y=num2.length-1;y>=1;y--){
					int temp=num2[y]-num[y-1];
					if(temp>bigbig){
						bigbig = temp;
						pos=y-1;
					}
					
				}
				System.out.println(num2[pos]+" "+num2[pos+1]);
			}
		}
	}

}
