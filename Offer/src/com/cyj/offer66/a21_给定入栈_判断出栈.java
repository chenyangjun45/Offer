package com.cyj.offer66;

import java.util.Stack;

public class a21_给定入栈_判断出栈 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pushA[]={1,2,3,4,5};
		int popA[]={4,5,3,2,1};
	}
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0){
  			return false;
  		}
        //将前序遍历序列压入stack
  		Stack<Integer> s = new Stack<Integer>();
  		//用于标识弹出序列的位置
  		int popIndex = 0;
  		//遍历一遍输出序列，如果原序列还有存留，则判断序列不可得
  		for(int i = 0; i< pushA.length;i++){
  			s.push(pushA[i]);
  			//如果栈不为空，且栈顶元素等于弹出序列
  			while(!s.empty() &&s.peek() == popA[popIndex]){
  				//出栈
  				s.pop();
  				//弹出序列向后一位
  				popIndex++;
  			}
  		}
  		return s.empty();
      }
}
