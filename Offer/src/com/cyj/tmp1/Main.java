package com.cyj.tmp1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
10 20 30
3
1000 10 10 30
500 10 10 20
600 8 10 20


*/
class Model{
	public int price;
	public int length;
	public int width;
	public int height;
}
class MyComparator implements Comparator<Model> {
	@Override
	public int compare(Model o1, Model o2) {
		return o1.length*o1.width*o1.height - o2.length*o2.width*o2.height;
	}
}
public class Main {
	private static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
/** 请完成下面这个process函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
	private static int process(Model boxTemplate,Model []items) 
	{
		Arrays.sort(items,new MyComparator());
//		for(Model tmp:items){
//			System.out.println(tmp.height*tmp.length*tmp.width);
//		}
		int boxNum = 1;
		int i=items.length-1;
		while(i>=1){
			//System.out.println(containOrNot(boxTemplate,items[i],items[i-1]));
			if(containOrNot(boxTemplate,items[i],items[i-1])){
				i=i-2;
			}
			else{
				boxNum++;
				i--;
			}
		}
		if(i==0){
			boxNum++;
		}
		return boxNum;
	}
	public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Model boxTemplate = new Model();
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()){
	        boxTemplate.length = scanner.nextInt();
	        boxTemplate.width = scanner.nextInt();
	        boxTemplate.height = scanner.nextInt();
	
	        int itemNum = scanner.nextInt();
	        Model []items = new Model[itemNum];
	        for(int i=0; i<itemNum; i++){
	            Model item = new Model();
	            item.price = scanner.nextInt();
	            item.length = scanner.nextInt();
	            item.width = scanner.nextInt();
	            item.height = scanner.nextInt();
	            items[i] = item;
	        }
	        long startTime = System.currentTimeMillis();
	        //boxMinNum = Integer.MAX_VALUE;
	        System.out.println (process(boxTemplate,items));
        }
	}
	public static boolean containOrNot(Model boxTemplate,Model item1,Model item2){
		if((item1.length*item1.width*item1.height + item2.length*item2.width*item2.height)>
		boxTemplate.length*boxTemplate.width*boxTemplate.height){
			return false;
		}
		return true;
	}
}