package com.cyj.real_test;
import java.util.ArrayList;
import java.util.Scanner;

public class 京东1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n =0;
		int resultCount = 0;
		while(sc.hasNext()){

			int abilityOfP = 0;
			n=sc.nextInt();
			String que = sc.nextLine();
			que = sc.nextLine();
			char []cyjqueue = new char[n];
			cyjqueue = que.toCharArray();
			//ArrayList<Integer> intList = new ArrayList<Integer>();
			for(int i=0;i<cyjqueue.length;i++){
				if(cyjqueue[i]=='1'||cyjqueue[i]=='1'
						||cyjqueue[i]=='2'||cyjqueue[i]=='3'
						||cyjqueue[i]=='4'||cyjqueue[i]=='5'
						||cyjqueue[i]=='6'||cyjqueue[i]=='7'
						||cyjqueue[i]=='8'||cyjqueue[i]=='9'){
					char []tmpChar ={cyjqueue[i]};
					abilityOfP = Integer.parseInt(new String(tmpChar));
					//System.out.println(abilityOfP);//*2+1
					//char []tmpArray = new char[abilityOfP*2+1];
					for(int j=0;j<abilityOfP*2+1;j++){
						//tmpArray[j]=cyjqueue[i-abilityOfP+j];
						//System.out.println(cyjqueue[i-abilityOfP+j]);
						if(i-abilityOfP+j<0){
							continue;
						}
						if(i-abilityOfP+j>=cyjqueue.length){
							continue;
						}
						if(cyjqueue[i-abilityOfP+j]=='X'){
							resultCount++;
							cyjqueue[i-abilityOfP+j]='#';
						}
						//System.out.println(tmpArray[j]);
					}
					//System.out.println(cyjqueue[i]);
				}
				//System.out.println(cyjqueue[i]);
			}
			System.out.println(resultCount);
		}
	}

}
