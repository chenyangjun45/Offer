package com.cyj.tmp3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		Rule2 rule = new Rule2();
		rule.setRule();
		System.out.println(rule.getFee1().getStart());
		System.out.println(rule.getFee1().getEnd());
		System.out.println(rule.getFee1().getExpense());
		System.out.println(rule.getFee2().getStart());
		System.out.println(rule.getFee2().getEnd());
		System.out.println(rule.getFee2().getExpense());
		System.out.println(rule.getFee3().getStart());
		System.out.println(rule.getFee3().getEnd());
		System.out.println(rule.getFee3().getExpense());
//		System.out.println(rule.getFee4().getStart());
//		System.out.println(rule.getFee4().getEnd());
//		System.out.println(rule.getFee4().getExpense());
		
	}
	
}
class Fee{
	private Date start;
	private Date end;
	private int expense;
	
	public Fee() {
		super();
	}
	public Fee(Date start, Date end, int expense) {
		super();
		this.start = start;
		this.end = end;
		this.expense = expense;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
}
class Rule1{
	//"yyyy-MM-dd HH:mm:ss"
	//HH是24小时制
	private Fee fee1 = new Fee();
	private Fee fee2 = new Fee();
	private Fee fee3 = new Fee();
	private Fee fee4 = new Fee();
	
	public Fee getFee1() {
		return fee1;
	}

	public void setFee1(Fee fee1) {
		this.fee1 = fee1;
	}

	public Fee getFee2() {
		return fee2;
	}

	public void setFee2(Fee fee2) {
		this.fee2 = fee2;
	}

	public Fee getFee3() {
		return fee3;
	}

	public void setFee3(Fee fee3) {
		this.fee3 = fee3;
	}

	public Fee getFee4() {
		return fee4;
	}

	public void setFee4(Fee fee4) {
		this.fee4 = fee4;
	}
	
	//初始化费用信息
	public void setRule(){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//时间段1
			String startTime1 = "2017-09-09 9:00:00";
			String endTime1 = "2017-09-09 12:00:00";
			int exp1 = 30;
			Date start1 = sdf.parse(startTime1);
			Date end1 = sdf.parse(endTime1);
			this.setFee1(new Fee(start1,end1,exp1));
			//时间段2
			String startTime2 = "2017-09-09 12:00:00";
			String endTime2 = "2017-09-09 18:00:00";
			int exp2 = 50;
			Date start2 = sdf.parse(startTime2);
			Date end2 = sdf.parse(endTime2);
			this.setFee2(new Fee(start2,end2,exp2));
			//时间段3
			String startTime3 = "2017-09-09 18:00:00";
			String endTime3 = "2017-09-09 20:00:00";
			int exp3 = 80;
			Date start3 = sdf.parse(startTime3);
			Date end3 = sdf.parse(endTime3);
			this.setFee3(new Fee(start3,end3,exp3));
			//时间段4
			String startTime4 = "2017-09-09 20:00:00";
			String endTime4 = "2017-09-09 22:00:00";
			int exp4 = 60;
			Date start4 = sdf.parse(startTime4);
			Date end4 = sdf.parse(endTime4);
			this.setFee4(new Fee(start4,end4,exp4));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
class Rule2{
	private Fee fee1;
	private Fee fee2;
	private Fee fee3;
	public Fee getFee1() {
		return fee1;
	}
	public void setFee1(Fee fee1) {
		this.fee1 = fee1;
	}
	public Fee getFee2() {
		return fee2;
	}
	public void setFee2(Fee fee2) {
		this.fee2 = fee2;
	}
	public Fee getFee3() {
		return fee3;
	}
	public void setFee3(Fee fee3) {
		this.fee3 = fee3;
	}
	//初始化费用信息
	public void setRule(){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//时间段1
			String startTime1 = "2017-09-09 9:00:00";
			String endTime1 = "2017-09-09 12:00:00";
			int exp1 = 40;
			Date start1 = sdf.parse(startTime1);
			Date end1 = sdf.parse(endTime1);
			this.setFee1(new Fee(start1,end1,exp1));
			//时间段2
			String startTime2 = "2017-09-09 12:00:00";
			String endTime2 = "2017-09-09 18:00:00";
			int exp2 = 50;
			Date start2 = sdf.parse(startTime2);
			Date end2 = sdf.parse(endTime2);
			this.setFee2(new Fee(start2,end2,exp2));
			//时间段3
			String startTime3 = "2017-09-09 18:00:00";
			String endTime3 = "2017-09-09 22:00:00";
			int exp3 = 60;
			Date start3 = sdf.parse(startTime3);
			Date end3 = sdf.parse(endTime3);
			this.setFee3(new Fee(start3,end3,exp3));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
class Order{
	private String userId;
	private Date startReserve;//预定开始时间
	private Date endReserve;//预定开始时间
	private boolean cancle;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getStartReserve() {
		return startReserve;
	}
	public void setStartReserve(Date startReserve) {
		this.startReserve = startReserve;
	}
	public Date getEndReserve() {
		return endReserve;
	}
	public void setEndReserve(Date endReserve) {
		this.endReserve = endReserve;
	}
	public boolean isCancle() {
		return cancle;
	}
	public void setCancle(boolean cancle) {
		this.cancle = cancle;
	}
}
//某天的订单列表和每个小时时间段的占用情况
class OrderDay{
	//用来记录某一天的预定情况，所有订单都在里面，包括预定和取消
	public ArrayList<Order> orderList = new ArrayList<Order>();
	//用来记录每个小时是否被预定，即24个小时，第一个字段Integer表示24小时制的时间，第二个字段表示是否被预定
	public HashMap<Integer,Boolean> orderMap = new HashMap<Integer,Boolean>();
	public void PutAnOrderOrCancle(Order order){
		if(order.isCancle()==true){//如果是取消订单
			//首先加入订单
			//然后更改预定状态hash
		}
		else{//如果是预定
			//先检查是否冲突
			//如果冲突
			
			//如果不冲突
			
		}
	}
	public int GetProfit(){
		int sum=0;
		//遍历订单，如果有取消预定，则计算违约金
		//然后遍历HashMap直接累加每个小时的盈利即可
		return 0;
	}
}
//每个场馆的预定情况
class  Stadium{
	//HashMap前一个字段String为日志的"yyyy-MM-dd",后一个字段OrderDay为这一天的订单情况
	public HashMap<String,OrderDay> orderMap = new HashMap<String,OrderDay>();
	//获取所有盈利
	public int getAllProfit(){
		int sum=0;
		//遍历所有日期的订单，计算盈利总和
		return 0;
	}
}