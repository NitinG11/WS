package com.sap.uc.Concurrency.BQ;

import java.util.concurrent.TimeUnit;

public class BQProducer implements Runnable{

	CustomBlockingQueue<Integer> cbq;
	static int i =0;

	public BQProducer(CustomBlockingQueue<Integer> cbq) {
		super();
		this.cbq = cbq;
		
	}

	public synchronized void run() {
			
			cbq.enqueue(++i);
			System.out.println("Added element "+i+ " to the Queue");
			try {
				Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
