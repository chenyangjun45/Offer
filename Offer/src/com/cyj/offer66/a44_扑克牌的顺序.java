package com.cyj.offer66;

import java.util.Arrays;

public class a44_扑克牌的顺序 {
    public static void main(String args[]) {  
        // 模拟随机抽牌，大小王为0，A为1，J为11，Q为12，K为13，其实就是个数组，判断数组是否是顺序的  
  
        // 测试1：正好填补  
        int array_1[] = { 0, 0, 1, 4, 5 };  
        System.out.println(isContinuous(array_1));  
        // 测试2：不能填补  
        int array_2[] = { 0, 1, 4, 5, 6 };  
        System.out.println(isContinuous(array_2));  
        // 测试3：有相同元素  
        int array_3[] = { 0, 1, 3, 3, 4, };  
        System.out.println(isContinuous(array_3));  
    }  
  
    public static boolean isContinuous(int array[]) {  
        // 由于数组的规模很小，则可以直接使用库函数完成  
        // 作者有句话很重要：通常我们认为不同级别的时间复杂度只有当n足够大的时候才有意义  
        Arrays.sort(array);  
  
        int numOfZero = 0;// 统计0的个数  
        int sumOfError = 0;  
        for (int i = 0; i < array.length - 1; i++) {  
            if (array[i] == 0) {  
                numOfZero++;  
            } else {// 非零的情况  
                    // 若有相同的元素  
                if (array[i + 1] - array[i] == 0) {  
                    return false;  
                } else {
                	//相邻的差2才是需要补的
                    sumOfError += (array[i + 1] - array[i] - 1);  
                }  
            }  
        }  
        if (numOfZero >= sumOfError) {// 0能填补空缺  
            return true;  
        } else {  
            return false;  
        }  
    }  
}
