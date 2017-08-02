package com.cyj.offer66;

import java.util.ArrayList;
import java.util.Iterator;

public class a24_二叉树中和为某一值得路径_深度遍历_用了回溯 {

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
		ArrayList<ArrayList<Integer>> listAll = FindPath(root1,4);
		Iterator<ArrayList<Integer>> it = listAll.iterator();
		while(it.hasNext()){
			ArrayList<Integer> intList = it.next();
			
		}
	}
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        //定义result用于存储找到的所有符合条件的路径
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        //当前便遍历的路径
        ArrayList<Integer> curResult=new ArrayList<>();
        if(root==null){
            return result;
        }
        int curSum=0;
        //target,curResult,result,curSum都是独立在递归之外的
        FindPathCore(root,target,curResult,result,curSum);
        return result;
    }
    private static void FindPathCore(TreeNode root,int target,ArrayList<Integer> curResult,ArrayList<ArrayList<Integer>> result,int curSum){
        if(root==null){
            return;
        }   
        boolean isLeaf=(root.left==null&&root.right==null);
        
        curSum+=root.val;
        //如果当前结点是叶子节点
        if(isLeaf){
            if(curSum==target){
                curResult.add(root.val);
                //是叶子结点就输出结果
                result.add(new ArrayList<Integer>(curResult));
                //路径中取出该叶子节点
                curResult.remove(curResult.size()-1);
            }
            //这里，返回上一层的时候要移出当前结点！！
            //返回上层节点,并从当前路径和中减去该叶子节点
            curSum-=root.val;
            return;
        }
        curResult.add(root.val);
        FindPathCore(root.left,target,curResult,result,curSum);
        FindPathCore(root.right,target,curResult,result,curSum);
        curResult.remove(curResult.size()-1);

    }
}
