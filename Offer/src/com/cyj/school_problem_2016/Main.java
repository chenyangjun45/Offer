package com.cyj.school_problem_2016;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
/*
E:\V1R2\product\fpgadrive.c 1325

*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.读入文件路径记录,最后再取后16位
		//2.统计各个文件中的错误数
		//3.排序
		
		//读入所有数据
		Scanner sc = new Scanner(System.in);
		ArrayList<String> strList = new ArrayList<String>();
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		while(sc.hasNext()){
			String strtmp = sc.nextLine();
			String strPath[] = strtmp.split("\\\\");
			//System.out.println(strPath[strPath.length-1]);
			String finalPath = strPath[strPath.length-1];
			strList.add(finalPath);
			//System.out.println(finalPath);
			String pathAndLine[] = finalPath.split(" ");
//			System.out.println(pathAndLine[0]);
//			System.out.println(pathAndLine[1]);
			if(map.containsKey(pathAndLine[0])){
				Integer tmpInt = map.get(pathAndLine[0]);
				tmpInt++;
				map.put(pathAndLine[0], tmpInt);
			}
			else{
				map.put(pathAndLine[0], Integer.parseInt(pathAndLine[1]));
			}
		}
		sc.close();//记得关闭！！！
		//找出不同的数据，用不着！！
/*		HashSet<String> setStr = new HashSet<String>();
		setStr.addAll(strList);*/
		
		
	}
	class record{
		String path;
		int line;
		int count;
		int order;
	}
}
