package com.cyj.offer66;

public class a11_二进制中1的个数_处理二进制 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(NumberOf1(3));
	}
	//二进制中1的个数
	 public static int NumberOf1(int n) {
		int t=0;
        char[]ch=Integer.toBinaryString(n).toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='1'){
                t++;
            }
        }
        return t;
    }
}
