package com.cyj.java_primary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LisrtSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ArrayList list = new ArrayList();

	    list.add("92.8");

	    list.add("68.9");

	    list.add("168.61");

	    list.add("242");

	    list.add("317");

	    list.add("105");

	    // 字符串排序

	    Collections.sort(list);

	    System.out.println(list.toString()); // [105, 168.61, 242, 317, 68.9, 92.8]

	    Collections.sort(list, new Comparator() {

	      @Override

	      public int compare(Object o1, Object o2) {

	        return new Double((String) o1).compareTo(new Double((String) o2));

	      }

	    });

	    System.out.println(list.toString()); // [68.9, 92.8, 105, 168.61, 242, 317]

	  }
	}
//下面的代码实现先按照主属性排序，再按照次属性排序
/*
 import java.util.*;

public class ComparatorResultType implements Comparator{

 public int compare(Object arg0, Object arg1) {
  ResultTypeDesc desc0=(ResultTypeDesc)arg0;
  ResultTypeDesc desc1=(ResultTypeDesc)arg1;

   //首先比较主指标，如果主指标相同，则比较次指标

  int flag=desc0.getXXX().compareTo(desc1.getXXX());
  if(flag==0){
   return desc0.getXXX2().compareTo(desc1.getXXX2());
  }else{
   return flag;
  }  
 }
}

//测试类中代码：
ComparatorResultType comparator=new ComparatorResultType();
Collections.sort(list, comparator);
 * */
