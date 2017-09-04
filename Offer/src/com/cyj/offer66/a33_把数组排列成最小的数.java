package com.cyj.offer66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class a33_把数组排列成最小的数 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int []numbers={3,32,321};
		int []numbers={3,32,321};
		PrintMinNumber(numbers);
		
	}
	//方法1：求全排列，然后比较大小。
	//注意范围问题！！！！！String拼接后可能超过Integer的范围，所以用Long
	public static String PrintMinNumber(int [] numbers) {
		if(numbers.length==0){
			return "";
		}
		int k = 0;
		ArrayList<ArrayList<Long>> allList = new ArrayList<ArrayList<Long>>();
		getAll(numbers,k,allList);
		ArrayList<Long> together = new ArrayList<Long>();
		for(ArrayList<Long> list:allList){
			String str="";
			for(Long intNum:list){
				//System.out.print(intNum);
				str=str+intNum.toString();
			}
			//System.out.println(str);
			together.add(Long.parseLong(str));
		}
		Long small = together.get(0);
		for(Long ittmp:together){
			if(ittmp<=small){
				small=ittmp;
			}
		}
		System.out.println(small.toString());
		return small.toString();
	}
	public static void getAll(int []numbers,int k,ArrayList<ArrayList<Long>> allList){
		if(k==numbers.length){
			ArrayList<Long> list = new ArrayList<Long>();
			for(int i=0;i<numbers.length;i++){
				list.add((long) numbers[i]);
			}
			allList.add(list);
			return;
		}
		for(int i=k;i<numbers.length;i++){
			swap(numbers,i,k);
			getAll(numbers,k+1,allList);
			swap(numbers,i,k);
		}
	}
	public static void swap(int []numbers,int x,int y){
		int tmp = numbers[x];
		numbers[x]=numbers[y];
		numbers[y]=tmp;
	}
	//方法2，对String定义自己的排序器
    public String PrintMinNumber2(int [] numbers) {
        if(numbers==null||numbers.length<1){
            return "";
        }
        int len=numbers.length;
        //将数组元素转换为字符串数组中的元素，即用字符串表示数字，应对大数溢出问题!!
        String[] str=new String[len];
        for(int i=0;i<len;i++){
            str[i]=String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String c1,String c2){
                return (c1+c2).compareTo(c2+c1);
            }
        });
        //使用StringBuilder来构建String
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<len;i++){
            builder.append(str[i]);
        }
        return builder.toString();
    }
}
