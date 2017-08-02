package com.cyj.source_on_data_structure;

public class Problem_02_GCD {

	public static int gcd(int m, int n) {
		return n == 0 ? m : gcd(n, m % n);
	}

	public static void main(String[] args) {

		System.out.println(gcd(18, 27));

	}

}
