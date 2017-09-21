package com.sap.uc.Concurrency.BQ;

import java.util.LinkedList;
import java.util.List;

public class CustomBlockingQueue<T> {

	private int limit = 5;
	private List<T> queue = new LinkedList<T>();
	
	
	public CustomBlockingQueue(int limit) {
		super();
		this.limit = limit;
	}


	public synchronized void enqueue(T data) {
		try{
			if(this.queue.size() == limit )
				wait();
			else
				if(this.queue.size() == 0)
					notifyAll();
			this.queue.add(data);
		}catch (InterruptedException ie) {
			System.out.println(" Exception raised while addding elemnts to queue"+ie);
		}
	}
	
	public synchronized T dequeue() {
		try{
			while(this.queue.size() == 0)
				wait();
			if(this.queue.size() == this.limit)
				notifyAll();
			return this.queue.remove(0);
		}catch(InterruptedException ie) {
			System.out.println(" Exception raised while getting elements from queue"+ie);
		}
		return null;
	}
}
