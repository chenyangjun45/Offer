package com.cyj.tmp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Stadium stA = new Stadium();
		Stadium stB = new Stadium();
		Stadium stC = new Stadium();
		Stadium stD = new Stadium();
		while(true){
			String str = bf.readLine();
			if(!(str.length()==0)){//不为空行，则是订单
				System.out.println(str);
				if(!checkOrder(str)){//如果输入不合法
					System.out.println("Error: the booking is invalid!");
					continue;
				}
				else{//如果合法
					DateUtils dt = new DateUtils();
					String []strArr = str.split(" ");
					String []times = strArr[2].split("~");
					String start = strArr[1]+" "+times[0];
					String end = strArr[1]+" "+times[1];
					boolean cancle=false;
					if(strArr.length==5){//判断是否是取消订单
						if(strArr[4].equals("C")){
							cancle=true;
						}
						else{
							System.out.println("Error: the booking is invalid!");
							continue;
						}
					}
					Order order = new Order(strArr[0],dt.strToDateLong(start),dt.strToDateLong(end),cancle);
					//order.PrintOrder();
					//1,可以预定或删除
					//2,不能预定，因为冲突
					//3,不能取消，因为冲突
					switch(strArr[3]){
					case "A":
						//System.out.println("A");
						int bl = stA.putAnOrderOrCancle(strArr[1],order);
						printResult(bl);
						break;
					case "B":
						int bl1 = stB.putAnOrderOrCancle(strArr[1],order);
						printResult(bl1);
						break;
					case "C":
						int bl2 = stC.putAnOrderOrCancle(strArr[1],order);
						printResult(bl2);
						break;
					case "D":
						int bl3 = stD.putAnOrderOrCancle(strArr[1],order);
						printResult(bl3);
						break;
					}//switch
					
				}//if(!checkOrder(str)){}输入是否合法
			}//输入不为""
			else{
				//System.out.println("空行");
				//开始计算所有盈利。
				int allSum = 0;
				System.out.println("收入汇总");
				System.out.println("---");
				System.out.println("场地:A");
				stA.getAllProfit();
				stA.printAllFee();
				System.out.println("小计："+(int)(stA.sum)+"元\n");
				System.out.println("场地:B");
				stB.getAllProfit();
				stB.printAllFee();
				System.out.println("小计："+(int)(stB.sum)+"元\n");
				System.out.println("场地:C");
				stC.getAllProfit();
				stC.printAllFee();
				System.out.println("小计："+(int)(stC.sum)+"元\n");
				System.out.println("场地:D");
				stD.getAllProfit();
				stD.printAllFee();
				System.out.println("小计："+(int)(stD.sum)+"元");
				allSum = (int)(stA.sum)+(int)(stB.sum)+(int)(stC.sum)+(int)(stD.sum);
				System.out.println("---");
				System.out.println("总计："+allSum+"元\n");
				break;
			}
		}
	}
	//下面的函数主要检测输入是否合法
	public static boolean checkOrder(String order){
		String strArr[]= order.split(" ");
		//按空格分割，少于4个则输入不合法
		if(strArr.length<4){
			return false;
		}
		String time = strArr[2];
		String timeArr[] = time.split("~");//按~分割得到开始时间和结束时间
		//检查是否为整点
		DateUtils dt = new DateUtils();
		if(dt.ifOnTheHour(timeArr[0])&&dt.ifOnTheHour(timeArr[1])){
			//起始时间要比结束时间小，且不能相等
			if(dt.ifTimeOneIsSmall(timeArr[0], timeArr[1])){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	public static void printResult(int i){
		if(i==1){
			System.out.println("Success: the booking is accepted!");
		}
		else if(i==2){
			System.out.println("Error: the booking conflicts with existing bookings!");
		}
		else if(i==3){
			System.out.println("Error: the booking being cancelled does not exist!");
		}
	}
}

