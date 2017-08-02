package com.cyj.data_structure.sort;

public class a3_1_BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	void bubbleSort(int a[], int n){  
	    for(int i =0 ; i< n-1; ++i) {  
	        for(int j = 0; j < n-i-1; ++j) {  
	            if(a[j] > a[j+1])  
	            {  
	                int tmp = a[j] ; a[j] = a[j+1] ;  a[j+1] = tmp;  
	            }  
	        }  
	    }  
	} 
	void bubble2 ( int r[], int n) {  
	    int i= n -1;  //初始时,最后位置保持不变  
	    while ( i> 0) {   
	        int pos= 0; //每趟开始时,无记录交换  
	        for (int j= 0; j< i; j++)  
	            if (r[j]> r[j+1]) {  
	                pos= j; //记录交换的位置   
	                int tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;  
	            }   
	        i= pos; //为下一趟排序作准备  
	     }   
	}
	void bubble3 ( int r[], int n){  
	    int low = 0;   
	    int high= n -1; //设置变量的初始值  
	    int tmp,j;  
	    while (low < high) {  
	        for (j= low; j< high; ++j) //正向冒泡,找到最大者  
	            if (r[j]> r[j+1]) {  
	                tmp = r[j]; r[j]=r[j+1];r[j+1]=tmp;  
	            }   
	        --high;                 //修改high值, 前移一位  
	        for ( j=high; j>low; --j) //反向冒泡,找到最小者  
	            if (r[j]<r[j-1]) {  
	                tmp = r[j]; r[j]=r[j-1];r[j-1]=tmp;  
	            }  
	        ++low;                  //修改low值,后移一位  
	    }   
	}   
}
