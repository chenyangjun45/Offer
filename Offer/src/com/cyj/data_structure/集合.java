package com.cyj.data_structure;

import java.util.HashSet;
import java.util.Iterator;

public class 集合 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>();
		set.add("aa2.txt 2");
		set.add("aa2.txt 2");
		set.add("aa2.txt 1");
		Iterator<String> it = set.iterator();  
		while (it.hasNext()) {  
		  String str = it.next();  
		  System.out.println(str);  
		}
	}

}
