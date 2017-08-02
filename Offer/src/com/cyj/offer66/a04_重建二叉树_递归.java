package com.cyj.offer66;

public class a04_重建二叉树_递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//根据前序遍历和中序遍历的数组构建二叉树
		//前序遍历
		int preOrder[] = { 1, 2, 4, 7, 3, 5, 6, 8 };  
        // 二叉树的中序遍历  
        int inOrder[] = { 4, 7, 2, 1, 5, 3, 8, 6 };  
        TreeNode root = reConstructBinaryTree(preOrder, inOrder);  
        printPostOrder(root);
	}
	//若果觉得函数参数不够用，就自己写函数
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
	        return root;
	}
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
         
        if(startPre>endPre||startIn>endIn)
            return null;
        //1.先找到根节点
        TreeNode root=new TreeNode(pre[startPre]);
        //然后抽出公用逻辑
        //2.中序遍历中，找到左子树和右子树
        //然后在左子树中，又抽象成一个已知前序和中序，构造二叉树的问题
        for(int i=startIn;i<=endIn;i++)
        	//找到根节点在中序中的位置，将中序分为左子树和右子树
            if(in[i]==pre[startPre]){
            	//中序遍历中，左子树的范围
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                //中序遍历中，右子树的位置
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }
        return root;
    }
    public static void printPostOrder(TreeNode root) {  
        if (root != null) {
            System.out.print(root.val + "、");  
            printPostOrder(root.left);  
            printPostOrder(root.right);
        }  
    }  
}
