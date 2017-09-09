package com.zuochengyun.chapter_4_recursionanddp;

public class Problem_04_CoinsWay {

	public static int coins1(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		return process1(arr, 0, aim);
	}

	public static int process1(int[] arr, int index, int aim) {
		int res = 0;
		if (index == arr.length) {
			res = (aim == 0 ? 1 : 0);
		} else {
			for (int i = 0; arr[index] * i <= aim; i++) {
				res += process1(arr, index + 1, aim - arr[index] * i);
			}
		}
		return res;
	}

	public static int coins2(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] map = new int[arr.length + 1][aim + 1];
		return process2(arr, 0, aim, map);
	}
	//记忆搜索
	//加了一个Map用来表示计算过的位置
	public static int process2(int[] arr, int index, int aim, int[][] map) {
		int res = 0;
		//map中记录的是p(i,j)的返回值
		//map(i,j)==0表示p(i,j)从来没有计算过
		//map(i,j)==0表示递归过程计算过，但是返回值为0
		if (index == arr.length) {
			res = aim == 0 ? 1 : 0;
		} else {
			int mapValue = 0;
			for (int i = 0; arr[index] * i <= aim; i++) {
				mapValue = map[index + 1][aim - arr[index] * i];
				//累加计算过的位置
				if (mapValue != 0) {
					res += (mapValue == -1 ? 0 : mapValue);
				} else {
					res += process2(arr, index + 1, aim - arr[index] * i, map);
				}
			}
		}
		map[index][aim] = res == 0 ? -1 : res;
		return res;
	}
	//dp
	public static int coins3(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		//初始化列
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		//初始化行
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		int num = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				num = 0;
				//计算当前位置的值，是使用1张，2张，...，n张的累加
				for (int k = 0; j - arr[i] * k >= 0; k++) {
					num += dp[i - 1][j - arr[i] * k];
				}
				dp[i][j] = num;
			}
		}
		return dp[arr.length - 1][aim];
	}

	public static int coins4(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[arr.length][aim + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= aim; j++) {
			dp[0][arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
			}
		}
		return dp[arr.length - 1][aim];
	}

	public static int coins5(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		int[] dp = new int[aim + 1];
		for (int j = 0; arr[0] * j <= aim; j++) {
			dp[arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
			}
		}
		return dp[aim];
	}

	public static void main(String[] args) {
		int[] coins = { 10, 5, 1, 25 };
		int aim = 2000;

		long start = 0;
		long end = 0;
		System.out.println("===========�����ݹ�ķ���===========");
		start = System.currentTimeMillis();
		System.out.println(coins1(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		aim = 20000;

		System.out.println("===========���������ķ���===========");
		start = System.currentTimeMillis();
		System.out.println(coins2(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		System.out.println("=====��̬�滮O(N*(aim^2))�ķ���=====");
		start = System.currentTimeMillis();
		System.out.println(coins3(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		System.out.println("=======��̬�滮O(N*aim)�ķ���=======");
		start = System.currentTimeMillis();
		System.out.println(coins4(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

		System.out.println("====��̬�滮O(N*aim)�ķ���+�ռ�ѹ��===");
		start = System.currentTimeMillis();
		System.out.println(coins5(coins, aim));
		end = System.currentTimeMillis();
		System.out.println("cost time : " + (end - start) + "(ms)");

	}

}
