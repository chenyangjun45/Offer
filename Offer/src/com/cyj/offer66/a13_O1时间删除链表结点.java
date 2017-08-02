package com.cyj.offer66;

public class a13_O1时间删除链表结点 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ListNode firListNode = new ListNode();
        ListNode secListNode = new ListNode();
        ListNode thiListNode = new ListNode();
        firListNode.next = secListNode;
        secListNode.next = thiListNode;
        firListNode.val = 1;
        secListNode.val = 2;
        thiListNode.val = 3;
        deleteNode(firListNode, thiListNode);
        System.out.println(firListNode.next.val);
	}
    public static void deleteNode(ListNode head, ListNode deListNode) {
        // 空链表
        if (head == null || deListNode == null) {
            return;
        }
        // 要删除的链表中只有一个结点
        if (head == deListNode) {
            head = null;
        } else {
            // 要删除的结点不在链表的中间，不在尾部
            if (deListNode.next != null) {
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            } else {
            	//如果在尾部
                ListNode pointNode = head;
                while (pointNode.next != deListNode) {
                    pointNode = pointNode.next;
                }
                pointNode.next = null;
            }
        }
    }
}
