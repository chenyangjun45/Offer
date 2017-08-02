package com.cyj.java_primary.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.crypto.Data;

public class SynMain {

	//用SynThread和SynData来测试多线程访问数据
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SynData data=new SynData();//多个线程操作的是同一个对象
        ExecutorService executorService=Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new SynThread(data));
        }
        executorService.shutdown();//关闭线程池，如果不关闭线程池将一直运行。
	}

}
