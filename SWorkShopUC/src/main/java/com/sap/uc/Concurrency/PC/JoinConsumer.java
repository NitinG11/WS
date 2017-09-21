package com.sap.uc.Concurrency.PC;

public class JoinConsumer implements Runnable{

	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i< 7;i++) {
			System.out.println("Removed element "+i+ " from the Queue");
		}
	}

}
