package com.cyj.offer66;

public class a01_二维数组的查找_比较大小_更改行列 {

	public static void main(String args[]) {  
        // 测试用的例子  
        int A[][] = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },  
                { 6, 8, 11, 15 } };  
        System.out.println(find(A, 99));  
    }  
      
    /** 
     * 二维数组的查找 
     * @param array 已知的数组 
     * @param number 待查找的数 
     * @return 
     */  
    public static boolean find(int array[][], int target) {  
        boolean flag = false;  
        int rows = array.length;// 行数  
        int columns = array[0].length;// 列数  
        int row = 0;  
        int column = columns - 1;  
        while (row < rows && column >= 0) {  
            // 比较二维数组中的元素与target的关系  
            if (array[row][column] == target) {  
                flag = true;  
                break;// 跳出循环  
            } else if (array[row][column] > target) {  
                // 列变小  
                column--;  
            } else {  
                // 行变大  
                row++;  
            }  
        }  
        return flag;  
    }
}
