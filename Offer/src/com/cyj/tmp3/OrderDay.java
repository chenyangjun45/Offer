package com.cyj.tmp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

//某天的订单列表和每个小时时间段的占用情况
class OrderDay{
	private double sumCancelFeeOneDay = 0.0;
	private double sumOrderFeeOnday=  0.0;
	//用来记录某一天的预定情况，所有订单都在里面，包括预定和取消
	public ArrayList<Order> orderList = new ArrayList<Order>();
	//用来记录每个小时是否被预定，即24个小时，从下标1开始，第一个字段Integer表示24小时制的时间，第二个字段表示是否被预定
	public boolean[] blArr = new boolean[25];
	//用来记录每个小时属于哪个用户，即24个小时，从下标1开始，第一个字段Integer表示24小时制的时间，第二个字段表示是否被预定
	public String[] owner = new String[25];
	
	public double getSumCancelFeeOneDay() {
		return sumCancelFeeOneDay;
	}
	public void setSumCancelFeeOneDay(double sumCancelFeeOneDay) {
		this.sumCancelFeeOneDay = sumCancelFeeOneDay;
	}
	public double getSumOrderFeeOnday() {
		return sumOrderFeeOnday;
	}
	public void setSumOrderFeeOnday(double sumOrderFeeOnday) {
		this.sumOrderFeeOnday = sumOrderFeeOnday;
	}
	public OrderDay() {
		super();
		for(int i=0;i<owner.length;i++){
			owner[i]="";
		}
	}
	public int putAnOrderOrCancle(Order order){
		if(order.isCancle()==true){//如果是取消订单
			//首先判断是否合法，即是否在取消不存在的订单
			if(ifCanBeCancled(order)){//合法
				//1.加入list 2.更新每个整点时间的状态
				cancleOrder(order);
				return 1;
			}
			else{
				return 3;
			}
		}
		else{//如果是预定
			//先检查是否冲突
			if(ifCanBeOrdered(order)){//不冲突，可以预定
				addOrder(order);
				return 1;
			}
			else{//不能预定
				return 2;
			}
		}
	}
	public double getProfit(Rule1 r1,Rule2 r2){
		double sum=0.0;
		int rule1[] = r1.getFee();
		int rule2[] = r2.getFee();
		DateUtils dt = new DateUtils();
		int week = dt.getWeek(orderList.get(0).getStartReserve());
		//遍历订单，如果有取消预定，则计算违约金
		ListIterator<Order> lit=orderList.listIterator();
		while(lit.hasNext()){
			Order ord = lit.next();
			if(ord.isCancle()==true){
				double tmp = calFee(r1,r2,ord);
				ord.setSumFee((int)tmp);
				sum = sum + tmp;
				sumCancelFeeOneDay = sumCancelFeeOneDay + tmp;
			}
			else{
				double fee = calFee(r1,r2,ord);
				ord.setSumFee((int)fee);
			}
		}
		//然后遍历预定状态数组，直接累加每个小时的盈利即可
		for(int i=0;i<blArr.length;i++){
			if(blArr[i]==true){
				if(week>=1&&week<=5){
					sum = sum + rule1[i];
					sumOrderFeeOnday = sumOrderFeeOnday + rule1[i];
				}
				else if(week>=6&&week<=7){
					sum = sum + rule2[i];
					sumOrderFeeOnday = sumOrderFeeOnday + rule2[i];
				}
			}
		}
		return sum;
	}
	public boolean ifCanBeCancled(Order order){
		//日期已经确定过了，只用判断时间间隔里的整点是否被预定。
		DateUtils dt = new DateUtils();
		int time1 = Integer.parseInt(dt.dateToStrHour(order.getStartReserve()));
		int time2 = Integer.parseInt(dt.dateToStrHour(order.getEndReserve()));
		time2 = time2-1;//!!!!!注意减1
		//只要有一个整点时间没有被预定，就是不合法的，不能取消
		for(int i=time1;i<=time2;i++){
			if(blArr[i]==false||(!order.getUserId().equals(owner[i]))){
				return false;
			}
		}
		return true;
	}
	public boolean ifCanBeOrdered(Order order){
		//日期已经确定过了，只用判断时间间隔里的整点是否被预定。
		DateUtils dt = new DateUtils();
		int time1 = Integer.parseInt(dt.dateToStrHour(order.getStartReserve()));
		int time2 = Integer.parseInt(dt.dateToStrHour(order.getEndReserve()));
		time2 = time2-1;//!!!!!注意减1
		//只要有一个整点时间被预定，就是不合法的
		for(int i=time1;i<=time2;i++){
			if(blArr[i]==true){
				return false;
			}
		}
		return true;
	}
	public void cancleOrder(Order order){
		
		//日期已经确定过了，只用判断时间间隔里的整点是否被预定。
		DateUtils dt = new DateUtils();
		int time1 = Integer.parseInt(dt.dateToStrHour(order.getStartReserve()));
		int time2 = Integer.parseInt(dt.dateToStrHour(order.getEndReserve()));
		time2 = time2-1;//!!!!!注意减1
		for(int i=time1;i<=time2;i++){
			blArr[i] = false;
			owner[i] = "";
		}
		//从order中删除和取消的订单相同的订单
		Iterator<Order> it = orderList.iterator();
		while(it.hasNext()){
			Order ord = it.next();
			if(ifTheSame(ord,order)){
				it.remove();
			}
		}
		orderList.add(order);
	}
	public void addOrder(Order order){
		//日期已经确定过了，只用判断时间间隔里的整点是否被预定。
		DateUtils dt = new DateUtils();
		int time1 = Integer.parseInt(dt.dateToStrHour(order.getStartReserve()));
		int time2 = Integer.parseInt(dt.dateToStrHour(order.getEndReserve()));
		time2 = time2-1;//!!!!!注意减1
		for(int i=time1;i<=time2;i++){
			blArr[i] = true;
			owner[i] = order.getUserId();
			//System.out.println("addOrder"+owner[i]);
		}
		orderList.add(order);
	}
	public double calFee(Rule1 r1,Rule2 r2,Order order){
		//首先判断是周几
		int rule1[] = r1.getFee();
		int rule2[] = r2.getFee();
		double cancelRate = 1.0;
		double sum=0.0;
		DateUtils dt = new DateUtils();
		int time1 = Integer.parseInt(dt.dateToStrHour(order.getStartReserve()));
		int time2 = Integer.parseInt(dt.dateToStrHour(order.getEndReserve()));
		time2 = time2-1;//!!!!!注意减1
		int week = dt.getWeek(order.getStartReserve());
		//System.out.println("星期: "+week);
		if(week>=1&&week<=5){
			if(order.isCancle()){
				cancelRate = 0.5;
			}
			for(int i=time1;i<=time2;i++){
				sum = sum + rule1[i]*cancelRate;
			}
		}
		else if(week>=6&&week<=7){
			if(order.isCancle()){
				cancelRate = 0.25;
			}
			for(int i=time1;i<=time2;i++){
				sum = sum + rule2[i]*cancelRate;
			}
		}
		return sum;
	}
	public boolean ifTheSame(Order ord1,Order ord2){
		if(ord1.getUserId().equals(ord2.getUserId())
				&&ord1.getStartReserve().compareTo(ord2.getStartReserve())==0
				&&ord1.getEndReserve().compareTo(ord2.getEndReserve())==0
				){
			return true;
		}
		return false;
	}
	public void printOrderFee(){
		Collections.sort(orderList, new Comparator<Order>() {
			@Override
			public int compare(Order ord1, Order ord2) {
				// TODO Auto-generated method stub
				return ord1.getStartReserve().compareTo(ord2.getStartReserve());
			}

		});
		Iterator<Order> it = orderList.iterator();
		DateUtils dt = new DateUtils();
		while(it.hasNext()){
			Order ord = it.next();
			String cancel = "";
			if(ord.isCancle()){
				cancel="违约金 ";
			}
			System.out.println(dt.dateToStrDay(ord.getStartReserve())+" "
					+dt.dateToStrHour(ord.getStartReserve())+":00~"
					+dt.dateToStrHour(ord.getEndReserve())+":00 "
					+cancel+
					+ord.getSumFee()+"元");
		}
	}
}