package com.cyj.data_structure.find;

public class a1_OrderSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {3,1,5,7,2,4,9,6,10,8};  
		orderSearch(10,a);
	}
	public static int orderSearch(int searchKey,int[] array){  
	    if(array==null||array.length<1)  
	        return -1;  
	    for(int i=0;i<array.length;i++){  
	        if(array[i]==searchKey){  
	            return i;  
	        }  
	    }  
	    return -1;  
	      
	}  
}
