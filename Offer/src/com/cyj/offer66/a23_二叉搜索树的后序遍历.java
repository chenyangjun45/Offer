package com.cyj.offer66;

import java.util.Vector;

public class a23_二叉搜索树的后序遍历 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static boolean VerifySquenceOfBST(int [] sequence) {
		//在这里判断特殊情况
        if(sequence.length == 0) return false;
        return IsTreeBST(sequence, 0, sequence.length-1);
    }
/*	BST的后序序列的合法序列是，对于一个序列S，
	最后一个元素是x （也就是根），如果去掉最后
	一个元素的序列为T，那么T满足：T可以分成两段
	，前一段（左子树）小于x，后一段（右子树）大
	于x，且这两段（子树）都是合法的后序序列。完
	美的递归定义 : ) 。*/
    public static boolean IsTreeBST(int [] sequence,int start,int end ){
        //if(end <= start) return true;
        int i = start;
        //左子树的点都比最后一个点小，找到左子树的最后一个结点
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        int j;
        //右子树中的应该都小于最后一个点，只要有小的，则不合法
        for (j = i; j < end; j++) {
            if(sequence[j] < sequence[end]) return false;
        }
        boolean left=true;
        //根结点左子树不为空
        if(i>0){
            left=IsTreeBST(sequence, start, i-1);
        }
        boolean right=true;
        //根结点右子树不为空
        if(j<end-1){
            return IsTreeBST(sequence, i, end-1);
        }
        return left&&right;
    }
}
