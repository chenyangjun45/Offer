package com.cyj.offer66;

public class a06_旋转数组的最小数字_折半查找 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//折半查找的变形
		int []num = {4,5,6,7,1,2,3};
		int x = minNumberInRotateArray(num);
		System.out.println(x);
	}
	public static int minNumberInRotateArray(int [] array) {
	    int low = 0 ; int high = array.length - 1;   
	    while(low < high){
	        int mid = low + (high - low) / 2;  
	        //大则==mi+1
	        if(array[mid] > array[high]){
	            low = mid + 1;
	        }else if(array[mid] == array[high]){
	            high = high - 1;
	        }else{
	            high = mid;
	        }   
	    }
	    return array[low];
	}
}
