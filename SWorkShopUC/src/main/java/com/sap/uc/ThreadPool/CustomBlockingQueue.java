package com.sap.uc.ThreadPool;

import java.util.LinkedList;
import java.util.Queue;

//We are implementing a blocking queue 
//It is bounded queue i.e. size restriction 
//if size of queue is equal to maxsize i.e.e queue is full then it bolcks to add element in queue
//otherwise adds an element to queue
//if queue is empty then it blocks to consume (return) element
//else it will return element
//In our example element is task that will be executed by worker thread of pool
public class CustomBlockingQueue<E> {

	private Queue<E> queue;
	int maxSize;
	
	public CustomBlockingQueue(int maxSize){
		queue = new LinkedList<E>();
		this.maxSize = maxSize;
	}
	
	//returns the size of blocking queue i.e. no of elements currently available
	public int size(){
		return queue.size();
	}
	
	//clears the queue if queue has any task in case shutdown now is called
	public void clear(){
		queue.clear();
	}
	
	//adds a task to queue if queue is not full
	public synchronized void enqueue(E task) throws InterruptedException{
		
		while(queue.size() == maxSize){
			wait();
		}
		
		queue.offer(task);
		notifyAll();
	}
	
	//returns a task if queue is not empty
	public synchronized E dequeue() throws InterruptedException{
		
		while(queue.isEmpty()){
			wait();
		}
		
		E e = queue.poll();
		notifyAll();
		
		return e;
	
	}
}
