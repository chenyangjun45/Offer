package com.cyj.school_problem_2017;



import java.util.*;
public class a20170908_搜狗_圆上两点最远距离_暴力_Main {

	public static void main(String[] args)
	{
		Scanner sr=new Scanner(System.in);
		while(sr.hasNext())
		{
			int n=sr.nextInt();
			double[] num=new double[n];
			for(int i=0;i<n;i++)
				num[i]=sr.nextDouble();
			double Result=0.00000000;
			for(int i=0;i<n-1;i++)
				for(int j=i+1;j<n;j++)
				{
					double tmpRe=Math.abs(num[i]-num[j]);
					if(tmpRe>180)
						tmpRe=360.00000000-tmpRe;
					if(tmpRe>Result)
						Result=tmpRe;
				} 
            System.out.println(String.format("%.8f", Result));  
		}
	}
}

