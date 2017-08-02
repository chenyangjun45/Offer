package com.cyj.offer66;

public class a31_整数区间中1出现的次数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            
            count+=core(i);
        }
      
        return count;
    }
    //每次除以10，看有多少个1
    private static int core(int n){
        int num=0;
        while(n!=0){
            if(n%10==1){
                num++;
            }
            n/=10;
        }
        return num;
    }
}
