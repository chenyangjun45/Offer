package com.cyj.data_structure;

import java.util.ArrayList;
import java.util.Iterator;

public class 遍历_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		Iterator it = intList.iterator();
		while(it.hasNext()){
			Integer x = (Integer) it.next();
			System.out.println(x);
		}
	}

}
