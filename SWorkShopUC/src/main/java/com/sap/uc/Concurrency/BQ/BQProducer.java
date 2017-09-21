package com.sap.uc.Concurrency.BQ;

import java.util.concurrent.TimeUnit;

public class BQProducer implements Runnable{

	CustomBlockingQueue<Integer> cbq;

	public BQProducer(CustomBlockingQueue<Integer> cbq) {
		super();
		this.cbq = cbq;
	}

	public void run() {

		for(int i =0; i< 7;i++) {
			cbq.enqueue(i);
			System.out.println("Added element "+i+ " to the Queue");
			try {
				Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}
