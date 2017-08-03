package com.zuochengyun.chapter_1_stackandqueue;

import java.util.LinkedList;

public class Problem_07_SlidingWindowMaxArray {

	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		//双端队列
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			//每一次向后移动一个，都要保证队头的是目前最大的！！！！
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				//弹出队尾
				qmax.pollLast();
			}
			//加在队尾
			qmax.addLast(i);
			//当前窗口的第一个，在下一次循环中不应该存在，过期了
			if (qmax.peekFirst() == (i - w)) {
				qmax.pollFirst();
			}
			//i大于窗口以后，每次都输出一个值
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3,5 , 4, 3, 3, 6, 7 };
		int w = 3;
		printArray(getMaxWindow(arr, w));

	}

}
