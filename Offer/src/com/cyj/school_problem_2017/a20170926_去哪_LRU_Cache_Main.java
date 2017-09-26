package com.cyj.school_problem_2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


/*
3 5
put a b
put x y
put d kkk
put zzz lll
get a

3 5
put a b
put a b
put a b
put x y
get a



*/
import java.util.*;
public class a20170926_去哪_LRU_Cache_Main {
	static List<String> key=new ArrayList<String>();
	static List<String> value=new ArrayList<String>();
	static int cache;
	static int allOper;
	public static void main(String[] args)
	{
		Scanner sr=new Scanner(System.in );
		while(sr.hasNext())
		{
			cache=sr.nextInt();
			int n=sr.nextInt();
			for(int i=0;i<n;i++)
			{
				String str=sr.next();
				String k=sr.next();
				String v="";
				if(str.equals("put"))
					v=sr.next();
				if(str.equals("put"))
					put(k,v);
				else
					get(k);
			}
		}
	}
	 public static void put(String k,String v)
	 {
		 if(allOper<cache)
		 {
			 if(!key.contains(k))
			 {
				 key.add(k);
				 value.add(v);
				 allOper++;
			 }
			 
		 }
		 else
		 {
			 if(!key.contains(k))
			 {
				 key.remove(0);
				 value.remove(0);
				 key.add(k);
				 value.add(v);
			 }
			 else
			 {
				 int i;
				 for(i=0;i<key.size();i++)
				 {
					 if(key.get(i).equals(k))
						 break;
				 }
				 for(int j=i+1;j<key.size();j++)
				 {
					 key.set(j-1,key.get(j));
					 value.set(j-1, value.get(j));
				 }
				 key.set(key.size()-1, k);
				 value.set(key.size()-1, v);
			 }
		 }
	 }
	 public static void get(String k)
	 {
		 if(allOper>0&&key.contains(k))
		 {
			 for(int i=0;i<key.size();i++)
			 {
				 if(key.get(i).equals(k))
				 {
					 System.out.println(value.get(i));
					 break;
				 }
			 }
		 }
		 else
			 System.out.println("null");
	 }

}