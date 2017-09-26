package com.sap.uc.Concurrency.Synchronizers;

public class CustomCLImpl {

	int count;
	int accessThreadCount;
	public CustomCLImpl(int count) {
		super();
		this.count = count;
	}
	public CustomCLImpl(int count, int accessThreadCount) {
		super();
		this.count = count;
		this.accessThreadCount = accessThreadCount;
	}
	
	public  synchronized void await() throws InterruptedException{
		if(count >0)
			wait();
		
	}
	
	public synchronized void countDown() throws InterruptedException {
		count --;
		if(count==0)
			notify();
	}
}
