package com.cyj.offer66;

import java.util.Stack;

public class a37_链表的第一个公共结点 {

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
		 ListNode head2 = new ListNode(9);  
	        ListNode node_one2 = new ListNode(8);  
	        ListNode node_two2 = new ListNode(2);  
	        ListNode node_three2 = new ListNode(3);  
	        ListNode node_four2 = new ListNode(4);  
	        head2.setNext(node_one2);
	        node_one2.setNext(node_two2);  
	        node_two2.setNext(node_three2);  
	        node_three2.setNext(node_four2);  
	        node_four2.setNext(null); 
	        ListNode node = FindFirstCommonNode(head,head2);
	        System.out.println(node.val);
	}
    //时间复杂度为O(mn),空间复杂度为O(m+n)的方法
/*	借助两个栈！！
 * 
 * 分别把两个链表的结点放入两个栈里，这样两个链表
	的尾结点就位于两个栈的栈顶，接下来比较两个栈顶
	的结点是否相同。如果相同，则把栈顶弹出接着比较
	下一个栈顶，直到找到最后一个相同的结点。*/
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
  
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        while(pHead1!=null){
            stack1.push(pHead1);
            pHead1=pHead1.next;
        }
        while(pHead2!=null){
            stack2.push(pHead2);
            pHead2=pHead2.next;
        }
        if(stack1.peek().val!=stack2.peek().val){
            return null;
        }
        ListNode node1=null;
        ListNode node2=null;
        ListNode common=null;
        while(!stack1.empty()&&!stack2.empty()){
            node1=stack1.peek();
            node2=stack2.peek();
            if(node1.val==node2.val){
                stack1.pop();
                stack2.pop();
                common=node1;
            }else{
                break;
            }          
        }
       
        return common;
    }
/*    
    解法三：不借助外部空间法

    那么，可不可以不借助栈来实现了呢？答案是可以的，
    我们可以首先遍历两个链表得到它们的长度，就能知
    道哪个链表比较长，以及长的链表比短的链表多几
    个结点。在第二次遍历的时候，在较长的链表上先走
    若干步，接着再同时在两个链表上遍历，找到的第
    一个相同的结点就是它们的第一个公共结点。

    　　比如在上图的两个链表中，我们可以先遍历一次
      得到它们的长度分别为5和4，也就是较长的链表
      与较短的链表相比多一个结点。第二次先在长的链表
      上走1步，到达结点2。接下来分别从结点2和结点
      4出发同时遍历两个结点，直到找到它们第一个相
      同的结点6，这就是我们想要的结果。*/
    //时间复杂度为O(mn),空间复杂度为O(1)的方法
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int len1=getLengthOfList(pHead1);
        int len2=getLengthOfList(pHead2);
        ListNode longList=null;
        ListNode shortList=null;
        //两个链表的长度差
        int diff=0;
        if(len1<len2){
            diff=len2-len1;
            longList=pHead2;
            shortList=pHead1;
        }else{
            diff=len1-len2;
            longList=pHead1;
            shortList=pHead2;
        }
        //长链表先走diff步
        while(diff>0){
            longList=longList.next;
            diff--;
        }
        while(longList!=null&&shortList!=null&&longList!=shortList){
            
            longList=longList.next;
            shortList=shortList.next;            
        }
        return longList;
    }
    private int getLengthOfList(ListNode head){
        int len=0;
        while(head!=null){
            len++;
            head=head.next;
        }
        return len;
    }
}
