package com.cyj.school_problem_2017;

import java.util.Scanner;
/*
21857711


*/
public class a20170921_顺丰_47幸运数_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			long n = sc.nextInt();
			long result = getLuck(n);
			System.out.print(result);
		}
	}
	public static long getLuck(long n){
		long count = 0;
		//System.out.println(isLucky(n));
		for(long i=1;i<=n;i++){
			if(isLucky(i)){
				count++;
				
			}
		}
		count = count%1000000007;
		return count;
	}
	public static boolean isLucky(long num){
		boolean lucky=false;  
        long[] split = toIntArray(num);  
        for(int j=0;j<split.length;j++){  
            if(!(split[j]==4)){  
                if(!(split[j]==7)){  
                    lucky=false;  
                    break;  
                }  
            }  
            lucky=true;  
        }  
        return lucky; 
	}
	public static long[] toIntArray(long t){
		String str = String.valueOf(t);
		//System.out.println(str);
		char[] ch = str.toCharArray();
		long result[] = new long[ch.length];
		for(int i=0;i<ch.length;i++){
			result[i] = Integer.valueOf(String.valueOf(ch[i]));
			//System.out.println(result[i]);
		}
		return result;
	}
}
