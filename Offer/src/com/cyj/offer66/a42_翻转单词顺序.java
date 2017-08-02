package com.cyj.offer66;

import java.util.Stack;

public class a42_翻转单词顺序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I am a student";
		String str2 = " ";
		System.out.println(ReverseSentence(str));
		System.out.println("a"+ReverseSentence2(str2)+"b");
	}
   public static String ReverseSentence(String str) {
        if(str==null||str.length()==0){
            //反复错在这个位置，之前返回的是null值
            return str;
        }
        char chas[]=str.toCharArray();
        rolateWord(chas);
        return String.valueOf(chas);
    }
    private static void rolateWord(char chas[]){
        if(chas==null||chas.length==0){
            return;
        }
        //先翻转整个字符串
        reverse(chas,0,chas.length-1);
        //下面对每一个局部的单词进行逆序
        //标记一个单词的开始
        int start=0;
        //标记一个单词的结束
        int end=0;
        //遍历字符数组
        int i=0;
        while(i<chas.length){
        	//下面两个while共用一个i
            while(i<chas.length&&chas[i]==' '){
                i++;
                start=i;
            }
            while(i<chas.length&&chas[i]!=' '){
                i++;
                end=i;
            }
            reverse(chas,start,end-1);
        }

        
    }
    private static void reverse(char chas[],int left,int right){
        while(left<right){
            char temp=chas[left];
            chas[left]=chas[right];
            chas[right]=temp;
            left++;
            right--;
        }
    }
    public static String ReverseSentence2(String str) {
    	//如果字符串为null
    	//或者字符串去掉空格后为空！！！
    	//trim()!!!!!!!!!!!!
    	//特殊情况：全是空格！！
    	if(str==null||str.trim().length()==0){
    		return str;
    	}
    	String []strArr = str.split(" ");
    	//Stack stack = new Stack();
    	String result = "";
    	for(int i=strArr.length-1;i>=0;i--){
    		if(i!=0){
    			result = result+strArr[i]+" ";
    		}
    		else if(i==0){
    			result = result+strArr[i];
    		}
    	}
    	//System.out.println(result);
    	return result;
    }
}
