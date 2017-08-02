package com.cyj.java_primary;

public class Singleton {
	private static Singleton instance = null;
	private String url="aaaa";
	private Singleton(){}
	public static Singleton getInstance(){
		if(instance==null){
			instance = new Singleton();
		}
		return instance;
	}
	public String getUrl(){
		return url;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton sin = new Singleton();
		System.out.println(sin.getUrl());
	}

}
