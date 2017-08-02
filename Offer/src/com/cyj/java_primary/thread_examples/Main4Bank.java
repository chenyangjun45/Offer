package com.cyj.java_primary.thread_examples;

public class Main4Bank {

	//Bank.java
	//PersonA.java
	//PersonB.java
/*	
 * 示例二：两个人AB通过一个账户A在柜台取钱和B在ATM机取钱！
 * 
	程序分析：钱的数量要设置成一个静态的变量。两个人要取的同一个对象值
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 实力化一个银行对象
		Bank bank = new Bank();
		// 实例化两个人，传入同一个银行的对象
		PersonA pA = new PersonA(bank);
		PersonB pB = new PersonB(bank);
		// 两个人开始取钱
		pA.start();
		pB.start();
	}

}
