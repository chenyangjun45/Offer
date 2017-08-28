package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Scanner;
/*

Kolakoski序列

30 4
2 1 3 1



10 2
1 2

*/
public class a20170828_搜狐_kolakoski数列 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int n = in.nextInt();
            int m = in.nextInt();
            int myArr[] = new int[m];
            for(int i=0;i<m;i++){
            	myArr[i]=in.nextInt();
            }
            printKola(myArr,n);
        }
    }
    public static void printKola(int arr[],int n){
    	int len = arr.length;
    	if(len==0){
    		System.out.println("");
    		return;
    	}
    	if(len==1){
    		for(int i=0;i<n;i++){
    			System.out.println(arr[0]);
    		}
    		return;
    	}
    	int all=1;
    	int i=1;
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	list.add(-1);
    	list.add(arr[0]);
    	while(all<=n){
    		int ai = list.get(i);
    		int tmp = (i-1)%len;
    		int x = arr[tmp];
    		//考虑第一个数是1的情况，ai直接=arr[i]
    		if(i==1&&x==1){
    			ai=arr[i];
    			x = arr[i];
    	  		for(int y=0;y<ai;y++){
        			list.add(x);
        		}
        		all = all+ai;
        		i++;
        		i++;
        		continue;
    		}
    		//i==1时，要少入一个
    		else if(i==1&&x!=1){
        		for(int y=0;y<ai-1;y++){
        			list.add(x);
        		}
        		all = all+ai-1;
        		i++;
        		continue;
    		}
    		for(int y=0;y<ai;y++){
    			list.add(x);
    		}
    		all = all+ai;
    		i++;
    	}
    	for(int p=1;p<=n;p++){
    		System.out.println(list.get(p));
    	}
    }
}
