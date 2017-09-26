package com.sap.uc.Concurrency.Synchronizers;

/**
 * @author nitin
 *
 */
public class CustomCBImpl {

	int initialCount;
	int threadsCount;
	Runnable oRunnable;
	
	
	public CustomCBImpl(int initialCount) {
		super();
		this.initialCount = initialCount;
	}


	public CustomCBImpl(int threadsCount, Runnable oRunnable) {
		super();
		this.initialCount = threadsCount;
		this.threadsCount = threadsCount;
		this.oRunnable = oRunnable;
	}
	
	public void await() throws InterruptedException {
		synchronized (this) {
			threadsCount--;
			
			if(threadsCount>0)
				wait();
			 
			threadsCount = initialCount;
			notify();
			oRunnable.run();
		}
	}
	
}
