package com.cyj.school_problem_2017;

import java.util.Scanner;

public class a20170919_迅雷_数组分割 {
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			getAllcombs(n,m);
			System.out.println(count);
			count=0;
		}
	}
	 public static void getAllcombs(int n, int m){
		if(n==1&&m==1){
			 count=1;
			 return;
		}
        if (n <= 0 || m <= 0 || m > n*(1+n)>>1){
            System.out.println(-1);
            return;
        }


        if(n>=m){
        	count++;
            Integer[] comb = new Integer[m-1];
        	recursionProcedure(1,m-1,m,comb);
        }
        if(n<m){
        	Integer[] comb = new Integer[n];
            recursionProcedure(1,n,m,comb);
        }
    }
     public static void recursionProcedure(int num, int n, int m, Integer[] comb){
        //num大于m，或者num超过了n
        if (num > m || num > n){
            return;
        }
        if (num == m){
        	count++;
            comb[num-1] = num;
            return;
        }

        //num被选中
        comb[num-1] = num;
        recursionProcedure(num+1,n,m-num,comb);

        //num被放弃
        comb[num-1] = null;
        recursionProcedure(num+1,n,m,comb);
    }
}
