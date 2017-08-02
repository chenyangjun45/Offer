package com.cyj.offer66;

import java.util.HashMap;

public class a25_复杂链表的复制 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node1.random = node3;
		node2.random=node5;
		RandomListNode result = Clone(node1);
	}
	public static RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode ret=new RandomListNode(-1);
        RandomListNode last=ret;
        HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode p=pHead;
        while(p!=null){
            RandomListNode temp=new RandomListNode(p.label);
            map.put(p,temp);
            p=p.next;
            last.next=temp;
            last=last.next;
        }
        p=pHead;
        while(p!=null){
            if(p.random!=null){
                map.get(p).random=map.get(p.random);
            }
            p=p.next;
        }
        return ret.next;
    }
}
