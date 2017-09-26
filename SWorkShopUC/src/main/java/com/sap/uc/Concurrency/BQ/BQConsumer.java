package com.sap.uc.Concurrency.BQ;

public class BQConsumer implements Runnable{

	CustomBlockingQueue<Integer> cbq;

	public BQConsumer(CustomBlockingQueue<Integer> cbq) {
		super();
		this.cbq = cbq;
	}

	public synchronized void run() {

//		System.out.println("Run Invoked for Consumer Thread with Thread Id "+ Thread.currentThread().getName());
			System.out.println("Removed element "+cbq.dequeue()+ " from the queue");
	}
	
}
