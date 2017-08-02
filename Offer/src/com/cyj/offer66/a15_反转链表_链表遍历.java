package com.cyj.offer66;

public class a15_反转链表_链表遍历 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	        ListNode resultNode = ReverseList(head);
	        //遍历链表
	        while(resultNode!=null){
	        	System.out.println(resultNode.getval());
	        	resultNode = resultNode.next;
	        }
	}
    public static ListNode ReverseList(ListNode head) {
        //特殊情况
        if(head==null)
            return null;
        //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
        ListNode pre = null;
        ListNode next = null;

        //1->2->3->4->5
        //1<-2<-3 4->5
        //CYJ，如果要改变head的信息，则一定要设置一个指针来保存信息
        while(head!=null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
        }
        return pre;
    }
}
