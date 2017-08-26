package com.cyj.school_problem_2017;

import java.util.Scanner;
import java.util.Stack;
/*
 * 跳水运动员，前面比他分高的有几个。
5
4 5 1 3 2

0 0 2 2 3

1
2

0
*/
public class a20170826_360_跳水运动员_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int score[] = new int[n];
			int result[] = new int[n];
			for(int i=0;i<n;i++){
				score[i] = sc.nextInt();
				//System.out.println(score[i]);
			}
			if(n==1){
				result[0]=0;
			}
			else{
				for(int j=1;j<n;j++){
					int curCount = 0;
					for(int x=0;x<j;x++){
						if(score[x]>score[j]){
							curCount++;
						}
					}
					result[j]=curCount;
				}
			}
			for(int y=0;y<n-1;y++){
				System.out.print(result[y]+" ");
			}
			System.out.println(result[n-1]);
		}
	}

}
