package com.cyj.offer66;

public class a14_链表中倒数第k个结点_遍历链表 {

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
        ListNode resultNode = FindKthToTail(head,3);
        System.out.println(resultNode.getval());
	}
//最佳代码：Java代码，通过校验。代码思路如下：两个指针，
//先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
//然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。。
   public static ListNode FindKthToTail(ListNode head,int k) {
        if(head==null||k<=0){
            return null;
        }
        ListNode pre=head;
        ListNode last=head;       
        for(int i=1;i<k;i++){
            if(pre.next!=null){
                pre=pre.next;
            }else{
                return null;
            }
        }
        while(pre.next!=null){
            pre = pre.next;
            last=last.next;
        }
        return last;
    }
}
