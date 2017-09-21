package com.sap.uc.Concurrency.PC;

public class WaitNotifyPC {

	public static void main(String[] args) {
		
		Counter c = new Counter();
		WNProducer prod = new WNProducer(c);
		WNConsumer cons = new WNConsumer(c);
		
		new Thread(prod).start();
		new Thread(cons).start();
	}
}

class WNProducer implements Runnable {
	
	Counter oCounter;
	
	
	public WNProducer(Counter oCounter) {
		super();
		this.oCounter = oCounter;
	}


	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i<7;i++){
			oCounter.putCount(i);
			System.out.println("Adding "+i );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class WNConsumer implements Runnable {

	Counter oCounter;
	
	public WNConsumer(Counter oCounter) {
		super();
		this.oCounter = oCounter;
	}

	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i<7;i++){
			try {
				System.out.println("Getting Count "+oCounter.getCount());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Counter {
	private int counter;
	private boolean isAvaialable = false;
	
	
	public int getCount() throws InterruptedException {
		synchronized (this) {
			if(isAvaialable == false){
				wait();
			}
				notifyAll();
			isAvaialable = false;
			return counter;
		}
	}
	
	public void putCount(int n) {
		synchronized (this) {
			try{
				while (isAvaialable == true) {
					wait();
				
				}
			}catch(InterruptedException ie){
				
			}
			counter = n;
			isAvaialable = true;
			notifyAll();
		}
	}
}