package com.cyj.offer66;

public class a07_菲波那切数列_递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fibonacci(4));
	}
	//递推
	public static int Fibonacci(int n) {
		int x1=1,x2=1,x3=0;
        if(n<0){
            return -1;
        }else if(n==1||n==2){
            return 1;
        }else{
            for (int i=3;i<=n;i++){
                x3=x1+x2;
                x1=x2;
                x2=x3;
            }
            return x3;
        }
	}
	//递归
	

}
