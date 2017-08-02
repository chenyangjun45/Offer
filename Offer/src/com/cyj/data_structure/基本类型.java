package com.cyj.data_structure;

public class 基本类型 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c;         // 声明三个int型整数：a、 b、c
		int d = 3, e = 4, f = 5; // 声明三个整数并赋予初值
		byte z = 22;         // 声明并初始化 z
		String s = "runoob";  // 声明并初始化字符串 s
		double pi = 3.14159; // 声明了双精度浮点型变量 pi
		char x = 'x';        // 声明变量 x 的值是字符 'x'。
		
		//内置数据类型
		int a1 = 5000;
		float b1 = 13.65f;
		byte c1 = 0x4a;
		//包装类型
		Float x1=1f;
		Double x2=2.0;
		Long x3=1000l;
		
		//char和Character类
		char ch = 'a';
		// Unicode 字符表示形式
		char uniChar = '\u039A'; 
		// 字符数组
		char[] charArray ={ 'a', 'b', 'c', 'd', 'e' };
		Character ch2 = new Character('a');
		// 原始字符 'a' 装箱到 Character 对象 ch 中
		Character ch3 = 'a';
		
		
		//数组
		double[] myList = {1.9, 2.9, 3.4, 3.5};	 
	      // 打印所有数组元素
	      for (double element: myList) {
	         System.out.println(element);
	      }
	      
		//格式化输出
		float floatVar=1.0f;
		int intVar=20;
		String stringVar="字符串";
		System.out.printf("浮点型变量的的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", floatVar, intVar, stringVar);
		
		//String和char相互转化
		
	}
}
