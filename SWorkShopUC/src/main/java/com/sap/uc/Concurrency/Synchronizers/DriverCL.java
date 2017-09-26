package com.sap.uc.Concurrency.Synchronizers;

import java.awt.AWTError;
import java.util.concurrent.CyclicBarrier;

public class DriverCL {

	public static void main(String[] args) {
		CustomCBImpl oCbImpl = new CustomCBImpl(2, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("All threads have reached the barrier");
			}
		});
		
		Thread t1 = new Thread(new CBImpl(oCbImpl, 1),"Thread 1");
		Thread t2 = new Thread(new CBImpl(oCbImpl, 2),"Thread 2");
		t1.start();
	
		t2.start();
	}
}

class CBImpl implements Runnable{
	CustomCBImpl cb;
	int id;
	public CBImpl(CustomCBImpl cb, int id) {
		super();
		this.cb = cb;
		this.id = id;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ID "+ id +" by Thread "+Thread.currentThread().getName());
		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

