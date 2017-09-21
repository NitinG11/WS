package com.sap.uc.Concurrency.BQ;

import java.util.concurrent.TimeUnit;

public class BQDriver {

	public static void main(String[] args) {
		CustomBlockingQueue<Integer> oCustomBlockingQueue = new CustomBlockingQueue<Integer>(10);
		
		BQProducer oBqProducer = new BQProducer(oCustomBlockingQueue);
		Thread prodThread = new Thread(oBqProducer, " Thread 1");
		
		BQConsumer oBqConsumer = new BQConsumer(oCustomBlockingQueue);
		Thread consThread = new Thread(oBqConsumer, " Thread 1");
		
		System.out.println("Invoking threads now");
		prodThread.start();
		consThread.start();
		
	}
	
}
