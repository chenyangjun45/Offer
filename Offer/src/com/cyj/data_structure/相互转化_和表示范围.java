package com.cyj.data_structure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 相互转化_和表示范围 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//各类型范围！！
		/*整型 
		其中byte、short、int、long都是表示整数的，只不过他们的取值范围不一样 
		byte的取值范围为-128~127，占用1个字节（-2的7次方到2的7次方-1） 
		short的取值范围为-32768~32767，占用2个字节（-2的15次方到2的15次方-1） 
		int的取值范围为（-2147483648~2147483647），占用4个字节（-2的31次方到2的31次方-1） 
		long的取值范围为（-9223372036854774808~9223372036854774807），占用8个字节（-2的63次方到2的63次方-1）
		*/
		
		/*
		浮点型 
		float和double是表示浮点型的数据类型，他们之间的区别在于他们的精确度不同 
		float 3.402823e+38 ~ 1.401298e-45（e+38表示是乘以10的38次方，同样，e-45表示乘以10的负45次方）占用4个字节 
		double 1.797693e+308~ 4.9000000e-324 占用8个字节 
		double型比float型存储范围更大，精度更高，所以通常的浮点型的数据在不声明的情况下都是double型的，如果要表示一个数据是float型的，可以在数据后面加上“F”。 
		浮点型的数据是不能完全精确的，所以有的时候在计算的时候可能会在小数点最后几位出现浮动，这是正常的。 
		*/
		
		
		/*
		char型（文本型） 
		用于存放字符的数据类型，占用2个字节，采用unicode编码，它的前128字节编码与ASCII兼容 
		字符的存储范围在\u0000~\uFFFF，在定义字符型的数据时候要注意加' '，比如 '1'表示字符'1'而不是数值1， 
		char c = ' 1 '; 
		我们试着输出c看看，System.out.println(c);结果就是1，而如果我们这样输出呢System.out.println(c+0); 
		结果却变成了49。 
		如果我们这样定义c看看 
		char c = ' \u0031 ';输出的结果仍然是1，这是因为字符'1'对应着unicode编码就是\u0031 
		char c1 = 'h',c2 = 'e',c3='l',c4='l',c5 = 'o'; 
		System.out.print(c1);System.out.print(c2);
		System.out.print(c3);System.out.print(c4);Sytem.out.print(c5);
		*/
		String my_str="123";
		
		//如何将字串 String 转换成整数 int? 
		int i1 = Integer.valueOf(my_str).intValue();
		int i2=Integer.parseInt(my_str);
		System.out.println(i1);
		System.out.println(i2);
		//如何将字串 String 转换成Integer ?
		Integer integer=Integer.valueOf(my_str);

		//如何将整数 int 转换成字串 String ? 
		int my_int=123;
		String s1 = String.valueOf(my_int);
		String s2 = Integer.toString(my_int); 
		String s3 = "" + my_int; 
		//如何将整数 int 转换成Integer ? 
		Integer integer2=new Integer(my_int);
		
		//如何将 String 转换成 char ?
		char[] ca="123".toCharArray();
		
		//如何将char转换成String?
		String s21 = new String(ca);
		String s=ca.toString();      //任何类型都可以采用toString()转换成String类型
		//另附对时间的处理： 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");   //按照2011-09-21 13:33:24:456的格式输出时间
		sdf.format(new Date());
	}

}
