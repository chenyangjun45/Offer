package com.cyj.java_primary;
interface IntCompare{
	public int cmp(int a,int b);
}
class Comp1 implements IntCompare{
	public int cmp(int a,int b){
		return 0;
	}
}
class Comp2 implements IntCompare{
	public int cmp(int a,int b){
		return 0;
	}
}
class Test {
	public static void insertSort(int []a, IntCompare cmp){
		
	}
}
public class IntCompare_实现函数指针 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//调用
		int []a = {};
		Test test = new Test();
		test.insertSort(a,new Comp1());
	}

}
