package com.cyj.real_test;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
 /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String[] match(int m, int n, double[] A, double[] B, double[][] C) {
    	int bigA = theBig(A);
    	int bigB = theBig(B);
    	
		return null;
    }
    //匹配的规则检验
    static boolean rule(){
    	return false;
    }
    static int theBig(double []A){
    	double big=0.0;
    	int bigI = -1;
    	for(int i=0;i<A.length;i++){
    		if(A[i]>=big){
    			big=A[i];
    			bigI=i;
    		}
    	}
    	return bigI;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _A_size = _m;
        double[] _A = new double[_A_size];
        double _A_item;
        String[] _A_vals = in.nextLine().trim().split(" ");
        for(int _A_i = 0; _A_i < _A_size; _A_i++) {
            _A_item = Double.parseDouble(_A_vals[_A_i]);
            _A[_A_i] = _A_item;
        }

        int _B_size = _n;
        double[] _B = new double[_B_size];
        double _B_item;
        String[] _B_vals = in.nextLine().trim().split(" ");
        for(int _B_i = 0; _B_i < _B_size; _B_i++) {
            _B_item = Double.parseDouble(_B_vals[_B_i]);
            _B[_B_i] = _B_item;
        }

        int _C_rows = _m;
        int _C_cols = _n;

        double[][] _C = new double[_C_rows][_C_cols];
        for(int _C_i=0; _C_i<_C_rows; _C_i++) {
            String[] _C_vals = in.nextLine().trim().split(" ");
            for(int _C_j=0; _C_j<_C_cols; _C_j++) {
                _C[_C_i][_C_j] = Double.parseDouble(_C_vals[_C_j]);
            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }

        res = match(_m, _n, _A, _B, _C);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}