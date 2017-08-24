package com.cyj.offer66;

public class a56_链表中环的入口位置 {

    public static void main(String args[]) {  
        // 生成链表  
        ListNode head = new ListNode(1);  
        ListNode node_2 = new ListNode(2);  
        ListNode node_3 = new ListNode(3);  
        ListNode node_4 = new ListNode(4);  
        ListNode node_5 = new ListNode(5);  
        ListNode node_6 = new ListNode(6);  
        head.setNext(node_2);  
        node_2.setNext(node_3);  
        node_3.setNext(node_4);  
        node_4.setNext(node_5);  
        node_5.setNext(node_6);  
        node_6.setNext(node_3);  
  
        // 找到环的入口结点  
        System.out.println("环的入口结点为：" + getEntry(head).getval());  
    }  
      
    /** 
     * 求出环内结点的个数 
     * @param head 
     * @return 
     */  
    public static int numOfCycle(ListNode head) {  
        // 链表是否存在  
        if (head == null) {  
            return -1;// -1表示不存在环  
        }  
  
        // 建立快慢指针  
        ListNode fastNode = head;  
        ListNode slowNode = head;  
  
        int num = 0; // 环中结点的个数  
        //快指针每次走两个，慢指针每次走一个
        //如果有环，快慢指针早晚会相遇
        while (fastNode != null && slowNode != null) {  
            if (fastNode.getNext() != null  
                    && fastNode.getNext().getNext() != null) {  
                fastNode = fastNode.getNext().getNext();  
            } else {  
                return -1;// -1表示不存在环  
            }  
            slowNode = slowNode.getNext();  
            // 相遇表示存在环  
            if (fastNode == slowNode) {  
                break;// 跳出循环  
            }  
        }  
  
        // 计算环中结点的个数  
        num++;  
        slowNode = slowNode.getNext();  
        while (slowNode != fastNode) {  
            slowNode = slowNode.getNext();  
            num++;  
        }  
        return num;  
    }  
      
    /** 
     * 得到入口结点 
     * @param head 
     * @return 
     */  
    public static ListNode getEntry(ListNode head) {  
        if (head == null) {  
            return null;  
        }  
  
        ListNode fastNode = head;  
        ListNode slowNode = head;  
        int k = numOfCycle(head);  
        // 无环  
        if (k == -1) {  
            return null;  
        }  
  
        // 快指针先走k步，这边是关键  
        for (int i = 0; i < k; i++) {  
            fastNode = fastNode.getNext();  
        }  
  
        // 同时走  
        while (fastNode != slowNode) {  
            fastNode = fastNode.getNext();  
            slowNode = slowNode.getNext();  
        }  
  
        return fastNode;  
    }  

}
