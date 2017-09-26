package com.sap.uc.Concurrency.Synchronizers;

public class DriverCB {

	public static void main(String[] args) {
		
	}
}

class CLImp implements Runnable {
	
	CustomCLImpl cl = new CustomCLImpl(2, 4);
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			cl.countDown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}