package com.cyj.offer66;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class a03_从尾到头打印链表_递归或stack {
	static ArrayList<Integer> intListResult = new ArrayList<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 构建链表  
        ListNode head = new ListNode(0);  
        ListNode node_one = new ListNode(1);  
        ListNode node_two = new ListNode(2);  
        ListNode node_three = new ListNode(3);  
        ListNode node_four = new ListNode(4);  
        head.setNext(node_one);  
        node_one.setNext(node_two);  
        node_two.setNext(node_three);  
        node_three.setNext(node_four);  
        node_four.setNext(null);  
        System.out.println("第一种方式，递归实现：");  
        //printListReverse_1(head);  
        //换行  
        System.out.println();  
        System.out.println("第二种方式，非递归实现：");  
        //printListReverse_2(head);  

        ArrayList<Integer> intList = new ArrayList<Integer>();
        //递归的时候注意数据结构的位置
        intList = printListFromTailToHead2(head);
        Iterator<Integer> it = intList.iterator();
        while(it.hasNext()){
        	Integer num = it.next();
        	System.out.println(num);
        }
	}
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		if(listNode!=null){
			printListFromTailToHead(listNode.next);
			intListResult.add(listNode.val);
		}
		return intListResult;
	}
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
	}
}
