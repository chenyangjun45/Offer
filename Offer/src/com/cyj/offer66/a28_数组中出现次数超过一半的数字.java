package com.cyj.offer66;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class a28_数组中出现次数超过一半的数字 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//用HashMap
		int []array={1,2,3,4,5,2,2,2,2};
		char []ch = {'a','b','c'};
		int result = MoreThanHalfNum_Solution(array);
		System.out.println(result);
	}
	//直接用Map的方法，是暴力算法
	public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++){
             //不包含则加入到HashMap
            if(!map.containsKey(array[i])){
               map.put(array[i],1); 
            }else{
            	//如果包含，则相应的数字计数+1
            	//map.get是按照key来获取的
                int count = map.get(array[i]);
                map.put(array[i],++count);
            }
        }
        //遍历Map的方法！！
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            Integer key =(Integer)entry.getKey();
            Integer val = (Integer)entry.getValue();
            if(val>array.length/2){
                return key;
            }
        }
        return 0;
	}
	//用守阵士兵的算法
/*	
 * 采用阵地攻守的思想： 第一个数字作为第一个士兵，守阵地；count = 1；
			遇到相同元素，count++; 遇到不相同元素，即为敌人，同归于尽,
			count--；当遇到count为0的情况，又以新的i值作为守阵地的士兵，
			继续下去，到最后还留在阵地上的士兵，有可能是主元素。 再加一次
			循环，记录这个士兵的个数看是否大于数组一般即可。
			*/
	 public int MoreThanHalfNum_Solution2(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }
        
        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
        	//每一次等于0的时候就是一个新的士兵
            if(times==0){
                result=array[i];
                times=1;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }
        
        times=0;
       for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
       }
            
       if(times*2<=length){
           result=0;
       }
       return result;
    }
}
