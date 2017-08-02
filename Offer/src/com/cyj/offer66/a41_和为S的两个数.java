package com.cyj.offer66;

import java.util.ArrayList;

public class a41_和为S的两个数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//动态规划，规划的标准是不断缩小游标的距离
		int []a={1,2,5,7,10,15};
		ArrayList<Integer> resultList = FindNumbersWithSum(a,15);
		for(Integer it:resultList){
			System.out.println(it);
		}
	}
	   public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
	        ArrayList<Integer> list=new ArrayList<Integer>();  
	        if(array==null||array.length<1){
	            return list;
	        }
	        int small=0;
	        int big=array.length-1;
	        while(small<big){
	            
	            if(array[small]+array[big]>sum)
	                big--;
	            else if(array[small]+array[big]<sum)
	                small++;
	            else
	            {
	                list.add(array[small]);
	                list.add(array[big]);
	                return list;
	            }
	        }
	         return list;
	    }
}
