package com.cyj.data_structure;

import java.util.ArrayDeque;
import java.util.Deque;

public class 双向队列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //这是双向链表！！！
        Deque<Integer> queueA = new ArrayDeque<>();
        Deque<Integer> queueB = new ArrayDeque<>();
        //1.正常的排队
        queueA.offer(1);
        queueA.offer(2);
        queueA.offer(3);
        while(!queueA.isEmpty()){
        	System.out.println(queueA.poll());
        }
        //2.前插，就跟stack是一样的了。。
        queueA.addFirst(1);
        queueA.addFirst(2);
        queueA.addFirst(3);
        while(!queueA.isEmpty()){
        	System.out.println(queueA.poll());
        }
        //queueA.addLast(e);//加在队尾
        //queueA.peek();//获得队头，但是不出队
        
	}

}
