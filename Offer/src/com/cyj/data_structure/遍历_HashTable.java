package com.cyj.data_structure;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class 遍历_HashTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    // Create a hash map
	      Hashtable<String, Double> balance = new Hashtable<String, Double>();
	      String str;
	      double bal;

	      balance.put("Zara", new Double(3434.34));
	      balance.put("Mahnaz", new Double(123.22));
	      balance.put("Ayan", new Double(1378.00));
	      balance.put("Daisy", new Double(99.22));
	      balance.put("Qadir", new Double(-19.08));

	      // Show all balances in hash table.
	      //第一种遍历
	      Enumeration names;
	      names = balance.keys();
	      while(names.hasMoreElements()) {
	         str = (String) names.nextElement();
	         System.out.println(str + ": " +
	         balance.get(str));
	      }
	      //第二种遍历
	      for (Map.Entry<String, Double> entry : balance.entrySet()) {
		       System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
		  }
	      System.out.println();
	      // Deposit 1,000 into Zara's account
	      bal = ((Double)balance.get("Zara")).doubleValue();
	      balance.put("Zara", new Double(bal+1000));
	      System.out.println("Zara's new balance: " +
	      balance.get("Zara"));
	      
	      //第三种遍历
	      Iterator it = balance.entrySet().iterator();
	      while(it.hasNext()){
	    	  Map.Entry entry = (Map.Entry) it.next();
	    	  System.out.println(entry.getKey());
	    	  System.out.println(entry.getValue());
	      }
	}

}
