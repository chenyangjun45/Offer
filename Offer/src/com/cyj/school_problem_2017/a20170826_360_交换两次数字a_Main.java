package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class a20170826_360_交换两次数字a_Main {

/*
4
1 3 7 9
3
2 10 12

*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int na = sc.nextInt();
			int arrA[] = new int[na];
			for(int i=0;i<na;i++){
				arrA[i] = sc.nextInt();
				//System.out.print(arrA[i]+" ");
			}
			//System.out.println();
			int nb = sc.nextInt();
			int arrB[] = new int[nb];
			for(int i=0;i<nb;i++){
				arrB[i] = sc.nextInt();
				//System.out.print(arrA[i]+" ");
			}
			
			//System.out.println();
			//boolean calArr[][] = new boolean [na][nb];
			ArrayList<Integer> list = new ArrayList<Integer>();
			int sumA=0;
			int sumB=0;
			for(int i=0;i<na;i++){
				sumA = sumA+arrA[i];
			}
			for(int i=0;i<nb;i++){
				sumB = sumB+arrB[i];
			}
			for(int i=0;i<na;i++){
				for(int j=0;j<nb;j++){
					//第一次交换
					swap(arrA,arrB,i,j);
					sumA = sumA-arrA[i]+arrB[j];
					sumB = sumB+arrA[i]-arrB[j];
					//calArr[i][j]=true;
					for(int x=0;x<na;x++){
						for(int y=0;y<nb;y++){
							if(x==i&&y==j){
								continue;
							}
							swap(arrA,arrB,x,y);
							sumA = sumA-arrA[x]+arrB[y];
							sumB = sumB+arrA[x]-arrB[y];
							list.add((int)Math.abs(sumA-sumB));
						}
					}
				}
			}
			Collections.sort(list);
			System.out.println(list.get(0));
		}
		
	}
	public static void swap(int []arrA,int[] arrB,int i,int j){
		int tmp =  arrA[i];
		arrA[i] = arrB[j];
		arrB[j] = tmp;
	}
}
