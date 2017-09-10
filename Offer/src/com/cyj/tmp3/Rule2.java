package com.cyj.tmp3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Rule2{
	private int []fee = new int[25];
	private Fee fee1 = new Fee();
	private Fee fee2 = new Fee();
	private Fee fee3 = new Fee();
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
	
	public int[] getFee() {
		return fee;
	}
	public void setFee(int[] fee) {
		this.fee = fee;
	}
	public Rule2() {
		super();
		for(int i=9;i<=11;i++){
			fee[i]=40;
		}
		for(int i=12;i<=17;i++){
			fee[i]=50;
		}
		for(int i=18;i<=21;i++){
			fee[i]=60;
		}
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