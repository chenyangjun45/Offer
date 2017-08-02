package com.cyj.offer66;

public class a12_数值的整数次方_数据的边界 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Power(2.0,2));
	}
    public static double Power(double base, int exponent) {
        //一定要分析输入的情况
        //由于exponent是int类型的整数，则可能包含正整数、0以及负整数三种情况。
        double temp=1;
        if(exponent>0){
            for(int i=1;i<=exponent;i++){
                temp=temp*base;
                if(temp>1.7976931348623157E308){
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
            }
            return temp;
             
        }if(exponent<0){
            exponent=-exponent;
            for(int i=1;i<=exponent;i++){
                temp=temp*base;
                if(temp>1.7976931348623157E308){
                    System.out.println("已经超出double类型的取值范围。");
                    return -1;
                }
            }
            temp=1.0/temp;
            return temp;
        }else{
            return 1;
        }
         
    }
}
