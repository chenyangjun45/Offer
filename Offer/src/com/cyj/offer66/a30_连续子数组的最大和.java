package com.cyj.offer66;

public class a30_连续子数组的最大和 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []array={6,-3,-2,7,-15,1,2,2};
		FindGreatestSumOfSubArray(array);
	}
	public static int FindGreatestSumOfSubArray(int[] array) {
		int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }
}
