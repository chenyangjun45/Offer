package com.cyj.data_structure.sort;

public class a2_1_SimpleSelectSort {

    public static void main(String[] args) {  
        int a[] = {3,1,5,7,2,4,9,6,10,8};    
        a2_1_SimpleSelectSort  obj=new a2_1_SimpleSelectSort();  
        System.out.println("初始值：");  
        obj.print(a);  
        obj.selectSort(a);  
        System.out.println("\n排序后：");  
        obj.print(a);  
  
    }  
    private void selectSort(int[] a) {  
        for(int i=0;i<a.length;i++){  
            int k=i;//k存放最小值下标。每次循环最小值下标+1  
            for(int j=i+1;j<a.length;j++){//找到最小值下标  
                if(a[k]>a[j])  
                    k=j;  
            }  
            swap(a,k,i);//把最小值放到它该放的位置上  
        }  
    }  
    public void print(int a[]){  
        for(int i=0;i<a.length;i++){  
            System.out.print(a[i]+" ");  
        }  
    }  
     public  void swap(int[] data, int i, int j) {    
            if (i == j) {    
                return;    
            }    
            data[i] = data[i] + data[j];    
            data[j] = data[i] - data[j];    
            data[i] = data[i] - data[j];    
        }
     void SelectSort2(int r[],int n) {  
    	    int i ,j , min ,max, tmp;  
    	    for (i=1 ;i <= n/2;i++) {    
    	        // 做不超过n/2趟选择排序   
    	        min = i; max = i ; //分别记录最大和最小关键字记录位置  
    	        for (j= i+1; j<= n-i; j++) {  
    	            if (r[j] > r[max]) {   
    	                max = j ; continue ;   
    	            }    
    	            if (r[j]< r[min]) {   
    	                min = j ;   
    	            }     
    	      }    
    	      //该交换操作还可分情况讨论以提高效率  
    	      tmp = r[i-1]; r[i-1] = r[min]; r[min] = tmp;  
    	      tmp = r[n-i]; r[n-i] = r[max]; r[max] = tmp;   
    	  
    	    }   
    	}  

}
