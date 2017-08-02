package com.cyj.offer66;

public class a38_数字在排序数组中出现的次数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={1,2,3,4,4,4,4,5,6,7,8,9,10};
		GetNumberOfK(a,4);
	}
	 //需要充分利用排序数组这个特点
	//1.找到第一次出现的位置
	//2.找到第二次出现的位置
    public static int GetNumberOfK(int [] array , int k) {
        
        if(array==null||array.length==0){
            return 0;
        }
        int firstIndexK=getTheIndexOfFirst(array,array.length,k,0,array.length-1);
        int lastIndexK=getTheIndexOfLast(array,array.length,k,0,array.length-1);
        if(firstIndexK>-1||lastIndexK>-1){
            return(lastIndexK-firstIndexK+1);
        }
        //数组中不存在数字k
        return 0;
    }
    //找到第一次出现k的位置
    private  static int getTheIndexOfFirst(int[] arr,int len,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        int dataMid=arr[mid];
        if(dataMid>k){
            end=mid-1;
        }else if(dataMid<k){
            start=mid+1;
        }else{
            if(mid!=0){
                if(arr[mid-1]!=k){
                    return mid;
                }else{
                    end=mid-1;
                }
            }else{
                return mid;
            }
        }
        return getTheIndexOfFirst(arr,len,k,start,end);
    }
    //找到最后一次出现k的位置
    private static int getTheIndexOfLast(int[] arr,int len,int k,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=(start+end)/2;
        int dataMid=arr[mid];
        if(arr[mid]<k){
            start=mid+1;
        }else if(arr[mid]>k){
            end=mid-1;
        }else{
            if(mid!=len-1){
                if(arr[mid+1]!=k){
                    return mid;
                }else{
                    start=mid+1;
                }
            }else{
                return mid;
            }
        }
        return getTheIndexOfLast(arr,len,k,start,end);
    }
}
