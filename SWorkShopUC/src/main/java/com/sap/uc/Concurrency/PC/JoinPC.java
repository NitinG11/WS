package com.sap.uc.Concurrency.PC;

public class JoinPC {

	public static void main(String[] args) {
		JoinProducer jp = new JoinProducer();
		JoinConsumer jc = new JoinConsumer();
		
		Thread t = new Thread(jp);
		Thread t2 = new Thread(jc);
		
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.start();
	}
}
