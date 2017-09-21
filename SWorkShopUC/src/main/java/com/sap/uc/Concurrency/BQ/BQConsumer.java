package com.sap.uc.Concurrency.BQ;

public class BQConsumer implements Runnable{

	CustomBlockingQueue<Integer> cbq;

	public BQConsumer(CustomBlockingQueue<Integer> cbq) {
		super();
		this.cbq = cbq;
	}

	public void run() {

//		System.out.println("Run Invoked for Consumer Thread with Thread Id "+ Thread.currentThread().getName());
		for(int i =0; i<7;i++)
			System.out.println("Removed element "+cbq.dequeue()+ " from the queue");
	}
	
}
