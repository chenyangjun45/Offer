package com.cyj.tmp3;

import java.util.Date;

class Order{
	private String userId;
	private Date startReserve;//预定开始时间
	private Date endReserve;//预定开始时间
	private boolean cancle;
	private int sumFee;
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
	
	public int getSumFee() {
		return sumFee;
	}
	public void setSumFee(int sumFee) {
		this.sumFee = sumFee;
	}
	public Order() {
		super();
	}
	public Order(String userId, Date startReserve, Date endReserve) {
		super();
		this.userId = userId;
		this.startReserve = startReserve;
		this.endReserve = endReserve;
	}
	public Order(String userId, Date startReserve, Date endReserve, boolean cancle) {
		super();
		this.userId = userId;
		this.startReserve = startReserve;
		this.endReserve = endReserve;
		this.cancle = cancle;
	}
	public void PrintOrder(){
		System.out.println(this.getUserId());
		System.out.println(this.getStartReserve());
		System.out.println(this.getEndReserve());
		System.out.println(this.isCancle());
	}
}
