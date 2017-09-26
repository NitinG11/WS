package com.sap.uc.Concurrency.PC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Semaphores {

	static int i=0;
	static Semaphore s= new Semaphore(1);
	static Semaphore s1= new Semaphore(0);
	public static void main(String[] args) {
		
		Queue queue = new LinkedList();
		
		ProducerI p = new ProducerI(s,s1,queue);
		Thread t = new Thread(p,"Thread 1");
		t.start();
		
		ConsumerI c = new ConsumerI(s,s1,queue);
		Thread t1 = new Thread(c,"Thread 2");
		t1.start();
	}
	
	static void addElement(int i){
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i =i;
		s1.release();
	}
	
	static void getElement(){
		try {
			s1.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
		s.release();
	}
	
}


class ProducerI implements Runnable {
	
	Semaphore s,s1;
	Queue queue;

	public ProducerI(Semaphore s,Semaphore s1,Queue q) {
		super();
		this.s = s;
		this.s1 = s1;
		this.queue = q;
	}

	@Override
	public void run() {
		for(int i =0;i<3;i++) {
			Semaphores.addElement(i);
		}
		/*
		// TODO Auto-generated method stub
		System.out.println("Putting value ");
		try {
			s.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hhh");
		queue.add("hhhh");
		
		s1.release();
		System.out.println(s1.availablePermits());
	*/}
	
}

class ConsumerI implements Runnable {
	Semaphore s,s1;
	Queue queue;

	public ConsumerI(Semaphore s, Semaphore s1,Queue queue) {
		super();
		this.s = s;
		this.s1 = s1;
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		System.out.println("getting value "+queue.remove());
		for(int i =0;i<3;i++){
			Semaphores.getElement();
		}
	}
}