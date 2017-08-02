package com.cyj.java_primary.thread;

public class MixRunableThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunnable = new MyRunnable2();
                Thread thread = new MyThread2(myRunnable);
                thread.start();
            }
        }
	}

}
class MyRunnable2 implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        System.out.println("in MyRunnable run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyThread2 extends Thread {

    private int i = 0;
    
    public MyThread2(Runnable runnable){
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println("in MyThread run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
