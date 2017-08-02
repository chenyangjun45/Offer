package com.cyj.real_test;

import java.util.Scanner;

public class 京东2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nOfCar = 0;
		String str="";
		
		while(sc.hasNext()){
			int maxLen =0;
			nOfCar = sc.nextInt();
			str = sc.nextLine();
			int [][]arrayOfCar = new int[nOfCar][2];
			for(int i=0;i<nOfCar;i++){
				arrayOfCar[i][0]=sc.nextInt();
				arrayOfCar[i][1]=sc.nextInt();
				str = sc.nextLine();
			}
/*			for(int i=0;i<nOfCar;i++){
				System.out.println(arrayOfCar[i][0]+","+arrayOfCar[i][1]);
			}*/
			maxLen = arrayOfCar[nOfCar-1][1]+arrayOfCar[nOfCar-1][0]-arrayOfCar[0][0]+1;
			//System.out.println(maxLen);
			int overlap[] = new int[maxLen];
			for(int j=0;j<maxLen;j++){
				overlap[j]=0;
			}
			for(int j=0;j<maxLen;j++){
				for(int i=0;i<nOfCar;i++){
					if(arrayOfCar[i][0]<=j&&j<=(arrayOfCar[i][0]+arrayOfCar[i][1])){
						overlap[j]++;
					}
				}
			}
			int big1 =0;
			int big2=0;
			int tmp=0;
			for(int j=0;j<maxLen;j++){
				if(overlap[j]>=big1){
					big1 = overlap[j];
					tmp = j;
				}
			}
			overlap[tmp]=0;
			for(int j=0;j<maxLen;j++){
				if(overlap[j]>=big2){
					big2 = overlap[j];
				}
			}
			System.out.println(big1+big2);
		}
	}

}
