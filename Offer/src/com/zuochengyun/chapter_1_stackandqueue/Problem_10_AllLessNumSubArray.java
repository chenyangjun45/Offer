package com.zuochengyun.chapter_1_stackandqueue;

import java.util.LinkedList;

public class Problem_10_AllLessNumSubArray {

	public static int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int i = 0;
		int j = 0;
		int res = 0;
		while (i < arr.length) {
			//找j
			while (j < arr.length) {
				//先是当做栈来用，通过栈找左边比它大的数
				//不断向右遍历，则不断找到的是目前序列中最大的数
				//队尾大于当前值，弹出队尾
				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				//队列为空，直接加入，保证队头是最小
				qmin.addLast(j);
				//队尾小于当前值，弹出队尾
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				//队列为空，直接加入，保证队头是最大
				qmax.addLast(j);
				//最大值与最小值已经找到
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				j++;
			}
			//当前窗口的第一个，在下一次循环中不应该存在，过期了
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			//当前窗口的第一个，在下一次循环中不应该存在，过期了
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			res += j - i;
			i++;
		}
		return res;
	}

	// for test
	public static int[] getRandomArray(int len) {
		if (len < 0) {
			return null;
		}
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 10);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] arr = getRandomArray(30);
		int num = 5;
		printArray(arr);
		System.out.println(getNum(arr, num));

	}

}
