package com.cyj.school_problem_2016;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class a8_最高分是多少_Main {
/*	
5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

5 7
1 2 3 4 5
Q 1 5
U 3 6
Q 3 4
Q 4 5
U 4 5
U 2 9
Q 1 5

9 10
28 49 11 35 40 17 57 4 6
Q 9 9
U 9 79
Q 9 5
Q 4 8
U 2 27
U 8 40
U 4 77
U 7 71
U 4 44
U 8 51


	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int numOfStu = sc.nextInt();
			int numOfOperator = sc.nextInt();
			//各学生的成绩
			int stus[] = new int[numOfStu];
			//操作列表
			ArrayList<Oper> listOfOperator = new ArrayList<Oper>();
			for(int i=0;i<numOfStu;i++){
				stus[i]=sc.nextInt();
				//System.out.println(stus[i]);
			}
			sc.nextLine();
			for(int j=0;j<numOfOperator;j++){
				String tmp = sc.nextLine();
				//System.out.println(tmp);
				String str[] = tmp.split(" ");
				a8_最高分是多少_Main  outer = new a8_最高分是多少_Main();
				a8_最高分是多少_Main.Oper opTmp = outer.new Oper(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]));
				listOfOperator.add(opTmp);
			}
			//如果是Q，则是询问操作
			//System.out.println(maxStu(stus,4,1));
			Iterator<Oper> it = listOfOperator.iterator();
			while(it.hasNext()){
				a8_最高分是多少_Main.Oper opTmp = it.next();
				//System.out.println(opTmp.getOpName());
				if(opTmp.getOpName().equals("Q")){
					System.out.println(maxStu(stus,opTmp.getA(),opTmp.getB()));
				}
				if(opTmp.getOpName().equals("U")){
					stus[opTmp.getA()-1]=opTmp.getB();
				}
			}
		}
	}
	//A和B是原始位置，没有-1
	public static int maxStu(int []stus,int start,int end){
		int big=0;
		if(start<=end){
			int i=start-1;
			for(;i<end;i++){
				if(stus[i]>=big){
					big = stus[i];
				}
			}
		}
		if(start>end){
			int i=end-1;
			for(;i<start;i++){
				if(stus[i]>big){
					big=stus[i];
				}
			}
		}
		return big;
	}
	class Oper{
		String opName;
		int a;
		int b;
		public String getOpName() {
			return opName;
		}
		public void setOpName(String opName) {
			this.opName = opName;
		}
		public int getA() {
			return a;
		}
		public void setA(int a) {
			this.a = a;
		}
		public int getB() {
			return b;
		}
		public void setB(int b) {
			this.b = b;
		}
		public Oper(String opName, int a, int b) {
			super();
			this.opName = opName;
			this.a = a;
			this.b = b;
		}
	}
}
