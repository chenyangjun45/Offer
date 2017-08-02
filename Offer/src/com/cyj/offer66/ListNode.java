package com.cyj.offer66;

public class ListNode { 
    //private
    int val;  
    //private 
    ListNode next;  
  
    public ListNode() {
    	
    }
    public ListNode(int val) {  
        this.val = val;  
    }  
  
    public ListNode(int val, ListNode next) {  
        this.val = val;  
        this.next = next;  
    }  
  
    public void setval(int val) {  
        this.val = val;  
    }  
  
    public void setNext(ListNode next) {  
        this.next = next;  
    }  
  
    public int getval() {  
        return this.val;  
    }  
  
    public ListNode getNext() {  
        return this.next;  
    }  
  
}  