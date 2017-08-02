package com.cyj.offer66;

public class a39_二叉树的深度 {

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
		int depth = TreeDepth2(root1);
		System.out.println(depth);
	}
	//递归实现
    public static int TreeDepth2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lh=TreeDepth2(root.left);
        int rh=TreeDepth2(root.right);
        return lh>rh?(lh+1):(rh+1);
    }
    //顺带实现，判断是不是平衡二叉树
    //这是两个递归嵌套！！！
    public boolean IsBalanced_Solution(TreeNode root) {
        // write code here
        if(root==null){
            return true;
        }
        int lh=getDepth(root.left);
        int rh=getDepth(root.right);
        int diff=lh-rh;
        //只要有差别，则不平衡
        if(diff>1||diff<-1){
            return false;
        }
        //注意是&&
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
    }
    //返回一个节点的深度，即该节点到叶子节点的路径最大长度
    private int getDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int lh=getDepth(root.left);
        int rh=getDepth(root.right);

        return lh>rh?(lh+1):rh+1;
    }
    
}
