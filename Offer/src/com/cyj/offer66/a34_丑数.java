package com.cyj.offer66;

public class a34_丑数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a34_丑数 test = new a34_丑数();
		int x = test.GetUglyNumber_Solution(15);
		System.out.println(x);
	}
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        int uglyCount=0;
        int num=0;
        while(uglyCount<index){
            ++num;
            if(isUglyNumber(num)){
                ++uglyCount;
            }
        }
        return num;
    }
    private boolean isUglyNumber(int num){
       
        while(num%2==0){
            num=num/2;
        }
        while(num%3==0){
            num/=3;
        }
        while(num%5==0){
            num/=5;
        }
        return (num==1)?true:false;
    }
    //用空间换时间的方法
    public int GetUglyNumber_Solution2(int index) {
        if(index<=0){
            return 0;
        }
        //辅助数组,大小为index
        int uglyArr[]=new int[index];
        //题目中描述的第一个丑数为1
        uglyArr[0]=1;
        //下一个丑数的位置
        int nextUgly=1;
        
        int index2=0;
        int index3=0;
        int index5=0;
        
        int ugly2=uglyArr[index2];
        int ugly3=uglyArr[index3];
        int ugly5=uglyArr[index5];
        
        //找到的丑数的数目还不满足要求
        while(nextUgly<index){
            int min=Min(ugly2*2,ugly3*3,ugly5*5);
            //这里已经为下一个丑数赋值了
            uglyArr[nextUgly]=min;
            
            //把先前的数都乘以2，找第一个大于当前丑数的数
            while(uglyArr[index2]*2<=uglyArr[nextUgly]){
            	//移向下一个数
                ugly2=uglyArr[++index2];
            }
          //把先前的数都乘以3，找第一个大于当前丑数的数
            while(uglyArr[index3]*3<=uglyArr[nextUgly]){
            	//移向下一个数
                ugly3=uglyArr[++index3];
            }
          //把先前的数都乘以5，找第一个乘以5后大于当前丑数的数的位置
            while(uglyArr[index5]*5<=uglyArr[nextUgly]){
            	//移向下一个数
                ugly5=uglyArr[++index5];
            }
            ++nextUgly;
        }
        return uglyArr[nextUgly-1];
    }
    //求三个数的最小值的Min函数
    private int Min(int num1,int num2,int num3){
        int min=num1<num2?num1:num2;
        return min<num3?min:num3;
    }
}
