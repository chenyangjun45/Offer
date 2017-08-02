package com.cyj.offer66;

import java.util.Stack;

public class a20_stack最小值 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(6);
		push(2);
		push(3);
		push(4);
		push(5);
		int result = min();
		System.out.println(result);
	}
    static Stack<Integer> stack=new Stack<Integer>();
    static Stack<Integer> stack2=new Stack<Integer>();
    public static void push(int node) {
        stack.push(node);
    }
      
    public void pop() {
        int p=stack.pop();
    }
      
    public int top() {
        return stack.peek();
    }
      
    public static int min() {
        int min=Integer.MAX_VALUE;
        //先遍历一遍存数据的stack,找到最小的
        while(stack.isEmpty()!=true){
            int node=stack.pop();
            if(node<min){
                min=node;
            }
            //遇见小的就放进minstack
            stack2.push(node);
        }
        //遍历完成后，最上面的就是最小的
        while(stack2.isEmpty()!=true){
            stack.push(stack2.pop());
        }
        return min;
    }
}
