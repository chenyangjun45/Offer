package com.cyj.java_primary;

import java.io.File;

public class MyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("/");
		if(!file.exists()){
			System.out.println("空目录");
			return;
		}
		System.out.println(file.getAbsolutePath());
		File []fileList = file.listFiles();
		for(int i=0;i<fileList.length;i++){
			if(fileList[i].isDirectory()){
				System.out.println("是目录");
			}
			if(fileList[i].isFile()){
				System.out.println("是文件");
			}
		}
	}

}
