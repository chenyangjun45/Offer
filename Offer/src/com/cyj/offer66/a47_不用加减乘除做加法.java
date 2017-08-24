package com.cyj.offer66;

public class a47_不用加减乘除做加法 {

    public static void main(String args[]) {  
        int a = 1;  
        int b = 2;  
        System.out.println(add(a, b));  
    }  
  
    public static int add(int num1, int num2) {  
        int sum = 0;  
        int carry = 0;  
        do {
        	//亦或相加，不产生进位
            sum = num1 ^ num2;// 第一步，异或
            //产生进位
            carry = (num1 & num2) << 1;// 第二步，进位  
            // 第三步，相加  
            num1 = sum;  
            num2 = carry;  
        } while (num2 != 0); //只要没有进位就结束
  
        return num1;  
    }  
}
