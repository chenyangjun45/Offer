package com.cyj.offer66;

import java.util.ArrayList;
import java.util.List;

public class a13_数组奇数在偶数前面_冒泡排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={3,4,5,2,6,1,7,8};
		reOrderArray2(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	//冒泡排序
    public static void reOrderArray(int [] array) {
        for(int i= 0;i<array.length-1;i++){
             for(int j=0;j<array.length-1-i;j++){
            	//是奇数在后面则交换
                 if(array[j]%2==0&&array[j+1]%2==1){
                     int t = array[j];
                     array[j]=array[j+1];
                     array[j+1]=t;
                 }
             }
         }
     }
    //定义2个list，一个数组，一个存偶数，一个村奇数，然后再合并到一个数组中
    public static void reOrderArray2(int [] array) {         
        List<Integer> odd = new ArrayList<Integer>();
        List<Integer> even = new ArrayList<Integer>();
        int n = array.length;
        int temp = 0;
        for(int i = 0;i < n;i++){
            temp = array[i];
            if(temp % 2 == 1){
                odd.add(temp);
            }else{
                even.add(temp);
            }
        }
        int m = 0;
        for(int j = 0;j < odd.size();j++){
            array[m] = odd.get(j);
            m++;
        }
        for(int k = 0;k < even.size();k++){
            array[m] = even.get(k);
            m++;
        }
         
         
    }
}
