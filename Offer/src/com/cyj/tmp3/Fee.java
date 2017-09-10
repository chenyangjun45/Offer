package com.cyj.tmp3;

import java.util.Date;

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
