package com.cyj.school_problem_2016;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class a1_小米_Git {
	//多叉树公共父节点问题
/*	Java解法
	多叉树寻找最近公共父节点问题
	
	解题思路
	  从矩阵构造出father数组，father数组保存每个节点的父节点。
	  记录从根节点到带求节点A和B的路径。
	  比较路径，找到最近的公共节点。

	技巧
	  由于矩阵给的双向关系，构造father数组时，需要从根节点0开始，从上层往下层构造。
	  用双向队列记录根节点到本节点的路径，双向队列可以往对头加节点，也可以从对头取节点。*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String matrix[]={"01011","10100","01000","10000","10000"};
		int result = getSplitNode(matrix,1,2);
	}
    /**
     * 返回git树上两点的最近分割点
     * 
     * @param matrix 接邻矩阵，表示git树，matrix[i][j] == '1' 当且仅当git树中第i个和第j个节点有连接，节点0为git树的跟节点
     * @param indexA 节点A的index
     * @param indexB 节点B的index
     * @return 整型
     */
	public static int getSplitNode(String[] matrix, int indexA, int indexB) {
        if (indexA == indexB) return indexA;
        int len = matrix.length;
        // 构造一个father数组，存放每个节点的父节点
        int[] father = new int[len];
        // 标志数组
        int[] flag = new int[len];
        // 根节点的父节点为-1
        father[0] = -1;
        // 根节点 已经访问过
        flag[0] = 1;
        
        //***********下面的部分是层次遍历!!!!!，目的是标记所有结点的父节点
        //层次遍历的思路
        //1.根节点入队
        //2.只要队列非空，访问队头结点
        // 		左子节点入队，右子节点入队
        Queue<Integer> children = new ArrayDeque<>();
        children.offer(0);
        // 构造father数组，从根节点0开始
        while (!children.isEmpty()) {
            int parent = children.poll();
            char[] chars = matrix[parent].toCharArray();
            //遍历chars的内容，看当前节点是哪些节点的父结点
            for (int i = 0; i < chars.length; i++) {
                if (flag[i] != 1 && chars[i] == '1') {
                    // 设置i的父节点
                    father[i] = parent;
                    // 将其加入孩子队列
                    children.offer(i);
                    // 标记为 访问过
                    flag[i] = 1;
                }
            }
        }
        //**************
        
        int ia = indexA;
        int ib = indexB;
        // 记录从根节点到本节点的路径
        //这是双向链表！！！
        Deque<Integer> queueA = new ArrayDeque<>();
        Deque<Integer> queueB = new ArrayDeque<>();
        //将A的父节点依次入队
        while (ia != -1) {
            queueA.addFirst(ia);
            ia = father[ia];
        }
        while (ib != -1) {
            queueB.addFirst(ib);
            ib = father[ib];
        }
        // 找到！！！最近！！！公共父节点
        int commonParent = 0;
        while (queueA.peekFirst() == queueB.peekFirst()) {
            commonParent = queueA.peekFirst();
            queueA.pollFirst();
            queueB.pollFirst();
        }
        return commonParent;
    }
}
