package com.cyj.offer66;

public class a39_平衡二叉树 {

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
		System.out.println(root1);
	}
    public boolean check(TreeNode root) {
        //定义一个引用类型的数据作为平衡标记,通过传引用的方式在递归左右子树时修改平衡标记
        boolean[] res=new boolean[1];
        //从根节点开始遍历树，遍历过程中修改平衡标记
        res[0]=true;
        postCheck(root,1,res);
         
        return res[0];
    }
    public int postCheck(TreeNode root,int depth,boolean[] res){
        if(root==null){
            return depth;
        }
        //遍历一次左子树，获取深度(深度已经在参数改变了，目的是为了检查左子树是否平衡)
        //若遍历左子树过程中修改了平衡标记为false，则子树非平衡，所以当前结点为根的子树非平衡，不再递归，直接返回

        int left_depth=postCheck(root.left,depth+1,res);
        if(res[0]==false){
            return depth;
        }
        //若左子树是平衡的，则遍历右子树并获取深度
        //若遍历右子树过程中修改了平衡标记为false，则子树非平衡，所以当前结点为根的子树非平衡，不再递归，直接返回
        int right_depth=postCheck(root.right,depth+1,res);
        if(res[0]==false){
            return depth;
        }
         
        //若左右子树都是平衡的，则对左右子树深度进行比较，判断当前结点为根的子树是否平衡
        if(Math.abs(left_depth-right_depth)>1){//高度差大于1，当前子树不平衡,修改平衡标记
            res[0]=false;
        }
        //用左右子树深度最大者作为自己的高度
        return Math.max(left_depth,right_depth);
    }
}
