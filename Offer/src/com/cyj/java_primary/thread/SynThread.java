package com.cyj.java_primary.thread;

public class SynThread implements Runnable{
	private SynData synData;

	public SynThread(SynData data){
		synData = data;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
        while (true)
        {
            int val = synData.getEven();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
            }
        }
	}
	
}
