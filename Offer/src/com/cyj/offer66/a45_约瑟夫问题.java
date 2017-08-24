package com.cyj.offer66;

public class a45_约瑟夫问题 {

    public static void main(String args[]) {  
        System.out.println(lastRemaining(5, 3));  
    }  
  
    /** 
     * 比较巧妙的办法是推导出一个推导公式 
     *  
     * @param n 
     *            ：n个数字 
     * @param m 
     *            ：删除第m个数字 
     * @return 
     */  
    public static int lastRemaining(int n, int m) {  
        if (n < 1 || m < 1) {  
            return -1;  
        }  
  
        int last = 0;  
        for (int i = 2; i <= n; i++) {  
            last = (last + m) % i;  
        }  
        return last;  
    }  

}
