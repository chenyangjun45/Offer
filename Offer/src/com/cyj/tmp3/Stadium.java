package com.cyj.tmp3;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//每个场馆的预定情况
class  Stadium{
	double sumCancelFee = 0.0;
	double sumOrderFee = 0.0;
	double sum=0.0;
	Rule1 rule1 = new Rule1();
	Rule2 rule2 = new Rule2();
	//HashMap前一个字段String为日志的"yyyy-MM-dd",后一个字段OrderDay为这一天的订单情况
	public Map<String,OrderDay> orderMap = new TreeMap<String,OrderDay>(
			new Comparator<String>() {
                public int compare(String obj1, String obj2) {
                    // 降序排序
                	
                    return obj1.compareTo(obj2);
                }
            });
	//获取所有盈利
	public double getAllProfit(){
		//遍历所有日期的订单，计算盈利总和
		for (Map.Entry<String, OrderDay> entry : orderMap.entrySet()) {
			//System.out.println("Stadium "+entry.getKey());
			sum = sum + entry.getValue().getProfit(rule1,rule2);
			sumCancelFee = sumCancelFee + entry.getValue().getSumCancelFeeOneDay();
			sumOrderFee = sumOrderFee + entry.getValue().getSumOrderFeeOnday();
		}
		//System.out.println("Stadium "+sum);
		return sum;
	}
	//插入一个订单
	public int putAnOrderOrCancle(String date,Order order){
		if(orderMap.containsKey(date)){//如果当前日期的已经存在
			int ifBook = orderMap.get(date).putAnOrderOrCancle(order);
			return ifBook;
		}
		else{//当前日期的不存在
			OrderDay orderDay = new OrderDay();
			int ifBook = orderDay.putAnOrderOrCancle(order);
			orderMap.put(date, orderDay);
			return ifBook;
		}
	}
	//打印所有收入
	public void printAllFee(){
		
		for (Map.Entry<String, OrderDay> entry : orderMap.entrySet()) {
			entry.getValue().printOrderFee();
		}
	}
}