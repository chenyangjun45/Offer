package com.cyj.data_structure;

import java.util.LinkedHashMap;
import java.util.Map;

public class 遍历_LinkedHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("1", 1);
	    map.put("2", 2);
	    map.put("3", 3);
	      System.out.println("通过Map.keySet遍历key和value：");
	      for (String key : map.keySet()) {
	       System.out.println("key= "+ key + " and value= " + map.get(key));
	      }
	      
	}

}
