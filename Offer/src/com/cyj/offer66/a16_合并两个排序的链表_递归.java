package com.cyj.offer66;

public class a16_合并两个排序的链表_递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode head2 = new ListNode(2);
        ListNode node_one = new ListNode(3);  
        ListNode node_two = new ListNode(4);  
        ListNode node_three = new ListNode(6);  
        ListNode node_four = new ListNode(7);
        
        head.setNext(node_one);
        node_one.setNext(node_two);
        node_two.setNext(null);
        
        head2.setNext(node_three);
        node_three.setNext(node_four);
        node_four.setNext(null);
        
        ListNode result = Merge(head,head2);
        ListNode tmp = result;
        while(tmp.val!=0){
        	System.out.println(tmp.getval());
        	if(tmp.next==null){
        		break;
        	}
        	tmp = tmp.next;
        }
        
	}
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode pMergeHead = null;
        if(list1.val<list2.val){
            pMergeHead = list1;
            pMergeHead.next = Merge(list1.next,list2);
        }else{
            pMergeHead = list2;
            pMergeHead.next = Merge(list1,list2.next);
        }
        return pMergeHead;
    }
}