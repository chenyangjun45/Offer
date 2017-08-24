package com.cyj.offer66;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class a22_从上往下打印二叉树 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		TreeNode left11 = new TreeNode(4);
		TreeNode leftRight12 = new TreeNode(5);
		root1.left = left1;
		root1.right = right1;
		left1.left = left11;
		left1.right = leftRight12;
		PrintFromTopToBottom(root1);
		printTree(root1);
	}
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer>  list  =  new  ArrayList<Integer>();
        if(root==null){
                return  list;
        }
        Queue<TreeNode>  queue  =  new  LinkedList<TreeNode>();
        //root进入队列
        queue.offer(root);
        while  (!queue.isEmpty())  {
        	//父节点出队，左右结点进队
            TreeNode  treeNode  =  queue.poll();
            if  (treeNode.left  !=  null)  {
            	//左进队
                    queue.offer(treeNode.left);
            }
            if  (treeNode.right  !=  null)  {
            	//右进队
                    queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return  list;
	}
    public static void printTree(TreeNode root){
    	if(root!=null){
    		System.out.println(root.val);
    		printTree(root.left);
    		printTree(root.right);
    	}
    }
}
