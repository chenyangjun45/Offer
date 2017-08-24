package com.cyj.offer66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class a27_字符串的_全排列 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.用递归方法做
		String str="abc";
		ArrayList<String> list = Permutation(str);
		Iterator<String> it = list.iterator();
		for(String str2:list){
			System.out.println(str2);
		}
	}
	//全排列
	public static ArrayList<String> Permutation(String str) {
        ArrayList<String> re = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return re;
        }
        HashSet<String> set = new HashSet<String>();
        fun(set, str.toCharArray(), 0);
        //将集合中的元素加入ArrayList中
        re.addAll(set);
        Collections.sort(re);
        return re;
    }
	//k是独立在递归之外的
	static void  fun(HashSet<String> re, char[] str, int k) {
		//到最后一步，将结果保存
        if (k == str.length) {
            re.add(new String(str));
            return;
        }
        //将当前位置k的字母与后面的字符挨个交换，再执行该函数
        //直到所有情况都有了，k到最后位置，输出结果
        //一个递归后面跟n个递归！！！！
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(re, str, k + 1);
            //注意要交换回来，要恢复状态
            swap(str, i, k);
        }
    }
	static void  swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

}
