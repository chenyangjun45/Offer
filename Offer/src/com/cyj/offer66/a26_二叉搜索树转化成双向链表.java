package com.cyj.offer66;

public class a26_二叉搜索树转化成双向链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(4);
		TreeNode left1 = new TreeNode(2);
		TreeNode right1 = new TreeNode(5);
		TreeNode left11 = new TreeNode(1);
		TreeNode leftRight12 = new TreeNode(3);
		root1.left = left1;
		root1.right = right1;
		left1.left = left11;
		left1.right = leftRight12;
		TreeNode node1 = Convert(root1);
		int x = node1.val;
		int count=1;
		while(node1.right!=null){
			System.out.println(node1.val);
			node1 = node1.right;
			/*if(count==1){
				System.out.println(node1.val);
				count++;
				node1 = node1.right;
			}
			if(count>1){
				if(node1.val>x){
					System.out.println(node1.val);
					node1 = node1.right;
				}
//				if(node1.val==x){
//					break;
//				}
			}*/
		}
	}
	//主要思想是中序遍历
/*	方法二：递归版
	解题思路：
	1.将左子树构造成双链表，并返回链表头节点。
	2.定位至左子树双链表最后一个节点。
	3.如果左子树链表不为空的话，将当前root追加到左子树链表。
	4.将右子树构造成双链表，并返回链表头节点。
	5.如果右子树链表不为空的话，将该链表追加到root节点之后。
	6.根据左子树链表是否为空确定返回的节点。*/

    public static TreeNode Convert(TreeNode root) {
        if(root==null)
            return null;
        if(root.left==null&&root.right==null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while(p!=null&&p.right!=null){
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = root;
            root.left = p;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left!=null?left:root;        
    }
    //中序遍历
    
}
