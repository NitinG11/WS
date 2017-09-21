package com.sap.uc.Concurrency.PC;

public class JoinProducer implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i< 7;i++) {
			System.out.println("Added element "+i+ " to the Queue");
		}
	}

}
