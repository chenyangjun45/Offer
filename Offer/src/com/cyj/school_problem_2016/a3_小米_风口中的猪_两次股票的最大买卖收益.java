package com.cyj.school_problem_2016;

import java.util.Scanner;

public class a3_小米_风口中的猪_两次股票的最大买卖收益 {

/*	
 * 题目描述
	风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
	给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以
	长度为n的整数数组表示，数组中第i个元素（prices[i]）代表
	该股票第i天的股价。 假设你一开始没有股票，但有至多两次买入
	1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。
	若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最
	大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
	
	示例1
	输入
6
3 8 5 1 7 8

	输出
	
	12
	*/
/*	
问题解析
首先抽象为两次购买问题，对数组a[1]至a[i]是第一次购买，a[i+1]至a[n]是第二次购买。
求两次购买的最大收益。
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//第一个输入的是数组的大小
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		int []stocks = new int[size];
		while(sc.hasNext()){
			for(int i=0;i<size;i++){
				stocks[i]=sc.nextInt();
			}
			System.out.println(calculateMax(stocks));
			System.out.println(calculateMax2(stocks));
		}
		
	}
	//解法一：动态规划
	public static int calculateMax(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
 
        for (int curPrice : prices) {
            firstBuy = Math.max(firstBuy, -curPrice);
            firstSell = Math.max(firstSell, firstBuy + curPrice);
            secondBuy = Math.max(secondBuy,firstSell - curPrice);
            secondSell = Math.max(secondSell, secondBuy + curPrice);
        }
        return secondSell;
    }
	//解法二：把区间分成两部分，分别求各自区间的最大收益。就和leetcode121题目一样了。
	 public static int calculateMax2(int[] prices) {
	        if(prices==null || prices.length<2)return 0;
	        int sum=0;
	        for(int i=1;i<prices.length;i++){
	            int temp=getMax(prices,0,i)+getMax(prices,i+1,prices.length-1);
	            if(temp>sum)sum=temp;
	        }
	        return sum;
	    }
	    public static int getMax(int[] prices,int left,int right){
	        if(left>=prices.length)return 0;
	        int Min=prices[left];
	        int ret=0;
	        for(int i=left+1;i<=right;i++){
	            Min=Math.min(prices[i],Min);
	            ret=Math.max(ret,prices[i]-Min);
	        }
	        return ret;
	    }


	
}
