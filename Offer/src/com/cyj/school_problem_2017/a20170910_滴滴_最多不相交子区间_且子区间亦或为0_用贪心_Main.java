package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Scanner;

public class a20170910_滴滴_最多不相交子区间_且子区间亦或为0_用贪心_Main {
/*	
4
3 0 2 2

*/
	private static class Zone{
		int a;
		int b;
		public Zone(){
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int num = sc.nextInt();
			int[] numArr = new int[num];
			for(int i=0;i<num;i++){
				numArr[i] = sc.nextInt();
				//System.out.println(numArr[i]);
			}
			//int a[][] = new int[][2];
			ArrayList<Zone> list = new ArrayList<Zone>();
			//下面求所有区间
			int result = 0;
			for(int x1=0;x1<=num-1;x1++){
				for(int x2=num-1;x2>=x1;x2--){
					if(ifXOR(numArr,x1,x2)){
//						System.out.println(x1);
//						System.out.println(x2);
						result++;
						Zone z = new Zone();
						z.a=x1;
						z.b=x2;
						list.add(z);
					}
				}
			}
			int len = list.size();
			//System.out.println("长度："+len);
			int a[][] = new int[len][2];
			int count=0;
			for(Zone z:list){
				a[count][0]=z.a;
				a[count][1]=z.b;
				//System.out.println(a[count][0]);
				//System.out.println(a[count][1]);
				count++;
			}
			System.out.println(maxNum(a,len));
		}

	}
	public static boolean ifXOR(int[] arr,int x1,int x2){
		int n = arr.length;
		int result = arr[x1];
		for(int i=x1+1;i<=x2;i++){
			result = result^arr[i];
		}
		if(result==0){
			return true;
		}
		else{
			return false;
		}
	}
	//贪心找子区间的最大个数！！！，不知道对不对，未验证
	public static int maxNum(int [][]a,int n){
		//先按右边的点排序
		sort(a,n);
		int end=-1;
		int res = 0;
		for (int i = 0; i < n;i++){
			if(end<a[i][0]){
				res++;
				end = a[i][1];
			}
		}
		return res;
	}
	public static void sort(int[][] a ,int n){
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(a[j][1]<a[i][1]){
					int []temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
	}
}
