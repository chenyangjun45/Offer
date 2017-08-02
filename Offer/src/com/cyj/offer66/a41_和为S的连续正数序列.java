package com.cyj.offer66;

import java.util.ArrayList;

public class a41_和为S的连续正数序列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer> > list = FindContinuousSequence(9);
		for(ArrayList<Integer> outList:list){
			String tmpStr="";
			for(Integer it:outList){
				tmpStr = tmpStr+it+",";
			}
			System.out.println(tmpStr);
		}
	}
	//同样设置small和big两个游标
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int small = 1; 
        int big = 2;
        int curSum = small+big;
        while(small < big && small < (sum+1)/2){
            if(curSum == sum){
                ArrayList<Integer> list = new ArrayList<Integer>();
                
                for(int i=small;i<=big;i++){
                    list.add(i);
                }
                result.add(list);

                //更新
                curSum -= small;
                //区间右移
                small ++;        
                big ++;
                curSum += big;
            }else if(curSum < sum){          //tmp_sum小,右侧扩展
                //区间右侧 右移，包括更大的数字     
                big ++;
                curSum += big; //更新
            }else{                             //tmp_sum大，左侧紧缩
                curSum -= small;
                small ++;      //左侧紧缩
            }
        }
        return result;
    }
}
