package com.cyj.offer66;

public class a02_替换空格_字符串转数组_重新建立空间 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s = new StringBuffer("hello world");
		//未通过
		String result = replaceSpace(s);
		//通过
		//String result = replaceBlank(s);
		//通过
		//String result = replaceSpace2(s);
		System.out.println(result);
	}
	//重新计算数组空间，然后重新复制一遍
	public static String replaceBlank(StringBuffer str){
		char c_old[] = str.toString().toCharArray();

		int length = c_old.length;
		// 查找空格的数目
		int blank = 0;
		for (int i = 0; i < length; i++) {
			System.out.print(c_old[i]);
			if (c_old[i] == ' ') {
				blank++;
			}
		}
		System.out.println();
		// 重新计算新的数组的大小
		int length_new = length + blank * 2;
		// 从尾到头查找，注意-1
		int j = length - 1;
		//k为加了空格以后的长度，注意-1
		int k = length_new - 1;
		//设置新的char数组的长度
		char c_new[] = new char[k+1];
		for (int i = 0; i < c_old.length; i++) {
			c_new[i] = c_old[i];
		}
		while (j >= 0 && k >= 0) {
			if (c_new[j] != ' ') {
				c_new[k--] = c_new[j];
			} else {
				c_new[k--] = '0';
				c_new[k--] = '2';
				c_new[k--] = '%';
			}
			j--;
		}
		return new String(c_new);
	}
	public static String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
       StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
            	//不是空格的字符就直接复制
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
	 public static String replaceSpace2(StringBuffer str) {
	        int spacenum = 0;//spacenum为计算空格数
	        for(int i=0;i<str.length();i++){
	            if(str.charAt(i)==' ')
	                spacenum++;
	        }
	        int indexold = str.length()-1; //indexold为为替换前的str下标
	        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
	        int indexnew = newlength-1;//indexold为为把空格替换为%20后的str下标
	        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
	        //从后往前遍历
	        for(;indexold>=0 && indexold<newlength;--indexold){ 
	                if(str.charAt(indexold) == ' '){  //
		                str.setCharAt(indexnew--, '0');
		                str.setCharAt(indexnew--, '2');
		                str.setCharAt(indexnew--, '%');
	                }else{
	                    str.setCharAt(indexnew--, str.charAt(indexold));
	                }
	        }
	        return str.toString();
	   }
}
