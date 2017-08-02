package com.cyj.school_problem_2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class a4_微软_Lucky_String {

/*	题目描述
	A string s is LUCKY if and only if the number 
	of different characters in s is a fibonacci 
	number. Given a string consisting of only 
	lower case letters , output all its lucky 
	non-empty substrings in lexicographical order. 
	Same substrings should be printed once.
	示例1
输入

aabcd

输出

a 
aa 
aab 
aabc 
ab 
abc 
b 
bc 
bcd 
c 
cd 
d
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
        String str=sc.next();
        sc.close();
        //首先计算斐波那契数字，不多于100位意味着100之内的斐波那契数就行
        Set<Integer> fib=new HashSet<Integer>();
        for (int i = 1; i < 20; i++) {
            fib.add(fibonacci(i));
        }
        //拆分字符串，两层for循环
        Set<String> subStr=new HashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                subStr.add(str.substring(i, j+1));
            }
        }
        //对子字符串集合进行排序
        ArrayList<String> strList=new ArrayList<String>();
        strList.addAll(subStr);
        Collections.sort(strList);
        //比对并输出
        //设置一个集合，可以去重
        Set<Character> chs=new HashSet<Character>();
        for (String s : strList) {
            char[] ch=s.toCharArray();
            for (char c : ch) {
                chs.add(c);
            }
            if (fib.contains(chs.size())) {
                System.out.println(s);
            }
            chs.clear();
        }
	}
    public static int fibonacci(int n){
        if (n==1||n==2) {
            return 1;
        }
        else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}
