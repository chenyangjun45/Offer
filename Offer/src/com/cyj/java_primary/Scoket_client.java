package com.cyj.java_primary;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Scoket_client {
	public static void main(String []args) throws UnknownHostException, IOException, InterruptedException{
		 final int length = 100;
		  String host = "localhost";
		  int port = 1122;
		  Socket[] socket = new Socket[length];
		  for(int i = 0;i<length;i++){
		   socket[i] = new Socket(host,port);
		   System.out.println("第"+(i+1)+"次连接成功！");
		  }
		  Thread.sleep(3000);
		  for(int i=0;i<length;i++){
		   socket[i].close();
		  }
	}
}
