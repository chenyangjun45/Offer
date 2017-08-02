package com.cyj.data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class 队列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> queue=new LinkedList<String>();
        //添加几个元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");
        queue.add("5");
        System.out.println("队列中的元素是:"+queue);
        //弹出元素
        queue.poll();
        System.out.println("队列中的元素是:"+queue);
        //查看队列中首个元素，并不移除
        String peek=queue.peek();
        System.out.println("查看队列中首个元素，并不移除:"+peek);
        System.out.println("队列中的元素是:"+queue);
	}

}
