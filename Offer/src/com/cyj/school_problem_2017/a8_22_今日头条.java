package com.cyj.school_problem_2017;
import java.util.*;
import java.lang.*;
/*
 * 
 * 题目意思即为，右上角没有点！！！！！
input
5
1 2
5 3
4 6
7 5
9 0

output
4 6
7 5
9 0
*/
//自己写了一个类，用了Array中的sort排序
public class a8_22_今日头条 {

	public static void solution(Point[] points, int n) {
		Arrays.sort(points, new MyComparator());
		boolean[] valid = new boolean[n];
		//获得最大的x坐标的y值
		//即从右往左遍历,不断记录满足条件的点的y值
		//比它大才行,比它小的直接continue，见下面for循环
		int RMaxY = points[n - 1].y;
		valid[n - 1] = true;
		int validCnt = 1;

		for (int i = n - 2; i >= 0; i--) {
			if ( points[i].y <= RMaxY ) continue;
			else {
				RMaxY = points[i].y;
				valid[i] = true;
				validCnt++;
			}
		}

		for (int i = 0; i < n; i++) {
			if (valid[i]) {
				System.out.println( points[i].x + " " + points[i].y );
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Point[] points = new Point[n];
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			points[i] = new Point(x, y);
		}

		solution(points, n);
	}

}
class MyComparator implements Comparator<Point> {
	@Override
	public int compare(Point o1, Point o2) {
		return o1.x - o2.x;
	}
}

class Point {
	public int x;
	public int y;
	public Point(int curx, int cury) {
		x = curx;
		y = cury;
	}
}