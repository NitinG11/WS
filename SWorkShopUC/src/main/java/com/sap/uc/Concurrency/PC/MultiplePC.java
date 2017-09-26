package com.sap.uc.Concurrency.PC;

import java.util.LinkedList;
import java.util.Queue;

public class MultiplePC {

	public static void main(String[] args) {
		Queue list = new LinkedList<>();
		
		Producers p = new Producers(list,10);
		Thread tp = new Thread(p, "Thread 1");
				
		Consumers c = new Consumers(list,10);
		Thread tc = new Thread(c, "Thread 2");
		
		tp.start();
		tc.start();
	}
}

class Producers implements Runnable{
	
	Queue l ;
	int maxSize;
	
	

	public Producers(Queue l,int maxSize) {
		super();
		this.l = l;
		this.maxSize = maxSize;
	}



	@Override
	public void run() {
		
		while(maxSize>0) {
			synchronized (l) {
				while(l.size() == maxSize){
					try {
						l.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				double m = Math.random();
				System.out.println("Producing value "+m);
				l.add(m);
				l.notify();
			}
			maxSize --;
		}
	}
	
}

class Consumers implements Runnable{

	Queue l ;
	int maxSize;
	
	public Consumers(Queue l,int maxSize) {
		super();
		this.l = l;
		this.maxSize = maxSize;
	}


	@Override
	public void run() {
		while(maxSize>0) {
			synchronized (l) {
				while(l.size() == 0){
					try {
						l.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Consuming "+l.poll());
				l.notify();
			}
			maxSize --;
		}
	}
	
}