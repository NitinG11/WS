package com.sap.uc.Concurrency.Counters;

public class CCounter implements Runnable{

	static volatile int counter =0;
	
	 synchronized void incrementCount() {
		System.out.println(Thread.currentThread().getName() +" has counter "+ counter);
		counter +=1;
	}

	@Override
	public void run() {
		for(int i=0;i<8;i++){
			incrementCount();
		}
	}
	
	public static void main(String[] args) {
		CCounter cc = new CCounter();
		Thread t1 = new Thread(cc, "thread 1");
		Thread t2 = new Thread(cc, "thread 2");
		Thread t3 = new Thread(cc, "thread 3");
		t1.start();
		t2.start();
		t3.start();
	}
	 
}
