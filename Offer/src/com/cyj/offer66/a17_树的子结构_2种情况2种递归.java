package com.cyj.offer66;

public class a17_树的子结构_2种情况2种递归 {
	/*思路：参考剑指offer
		1、首先设置标志位result = false，因为一旦匹配成功result就设为true，
			剩下的代码不会执行，如果匹配不成功，默认返回false
		2、递归思想，如果根节点相同则递归调用DoesTree1HaveTree2（），
			如果根节点不相同，则判断tree1的左子树和tree2是否相同，
			再判断右子树和tree2是否相同
		3、注意null的条件，HasSubTree中，如果两棵树都不为空才进行判断，
			DoesTree1HasTree2中，如果Tree2为空，则说明第二棵树遍历完了，即匹配成功，
			tree1为空有两种情况（1）如果tree1为空&&tree2不为空说明不匹配，
			（2）如果tree1为空，tree2为空，说明匹配。
	*/
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
		
		
		TreeNode root2 = new TreeNode(1);
		TreeNode left2 = new TreeNode(2);
		TreeNode left21 = new TreeNode(4);
		root2.left = left2;
		left2.left = left21;
		boolean sub = HasSubtree(root1,root2);
		System.out.println(sub);
	}
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2==null) return false;
        if(root1==null && root2!=null) return false;
        //经过了上面的两个if以后，下面的则是两个root都不为空的情况
        boolean flag = false;
        if(root1.val==root2.val){
            flag = isSubTree(root1,root2);
        }
        if(!flag){
            flag = HasSubtree(root1.left, root2);
            if(!flag){
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }
       
    private static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if(root2==null) return true;
        if(root1==null && root2!=null) return false;      
        if(root1.val==root2.val){
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }else{
        return false;
        }
    }
}
