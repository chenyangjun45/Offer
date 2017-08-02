package com.cyj.data_structure.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class a5_RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,1,5,7,2,4,9,6,10,8};
		radixSort(a);
	}
	public static void radixSort(int[] array) {  
	    //首先确定排序的趟数;  
	    int max = array[0];  
	    for (int i = 1; i < array.length; i++) {  
	        if (array[i] > max) {  
	            max = array[i];  
	        }  
	    }  
	    int time = 0;  
	    //判断位数;  
	    while (max > 0) {  
	        max /= 10;  
	        time++;  
	    }  
	  
	  
	    //建立10个队列;  
	    ArrayList<ArrayList<Integer>> queue = new ArrayList<>();  
	    for (int i = 0; i < 10; i++) {  
	        ArrayList<Integer> queue1 = new ArrayList<>();  
	        queue.add(queue1);  
	    }  
	  
	  
	    //进行time次分配和收集;  
	    for (int i = 0; i < time; i++) {  
	        //分配数组元素;  
	        for (int anArray : array) {  
	            //得到数字的第time+1位数;  
	            int x = anArray % (int)Math.pow(10, i + 1) / (int)Math.pow(10, i);  
	            ArrayList<Integer> queue2 = queue.get(x);  
	            queue2.add(anArray);  
	            queue.set(x, queue2);  
	        }  
	        int count = 0;//元素计数器;  
	        //收集队列元素;  
	        for (int k = 0; k < 10; k++) {  
	            while (queue.get(k).size() > 0) {  
	                ArrayList<Integer> queue3 = queue.get(k);  
	                array[count] = queue3.get(0);  
	                queue3.remove(0);  
	                count++;  
	            }  
	        }  
	    }  
	    System.out.println(Arrays.toString(array) + " radixSort");  
	}  
}
