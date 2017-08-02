package com.cyj.offer66;

import java.util.Stack;

public class a18_二叉树的镜像_栈_递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		  1
		2   3
	  4  5
*/
		TreeNode root1 = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(3);
		TreeNode left11 = new TreeNode(4);
		TreeNode leftRight12 = new TreeNode(5);
		root1.left = left1;
		root1.right = right1;
		left1.left = left11;
		left1.right = leftRight12;
		
		Mirror(root1);
		printTree(root1);
	}
    public static void Mirror(TreeNode root) {
    	//递归实现
        /*if(pRoot==NULL)
            return;
        TreeNode *ptemp=pRoot->left;
        pRoot->left=pRoot->right;
        pRoot->right=ptemp;
        if(pRoot->left)
            Mirror(pRoot->left);
        if(pRoot->right)
            Mirror(pRoot->right);*/
    	
        //非递归实现
    	//用栈来完成层次遍历
    	//有子结点的点都会弹出来
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
        	//
            TreeNode node = stack.pop();
            if(node.left != null || node.right != null) {
                TreeNode nodeLeft = node.left;
                TreeNode nodeRight = node.right;
                node.left = nodeRight;
                node.right = nodeLeft;
            }
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
    }
    public static void printTree(TreeNode root){
    	if(root!=null){
    		System.out.println(root.val);
    		printTree(root.left);
    		printTree(root.right);
    	}
    }
}
