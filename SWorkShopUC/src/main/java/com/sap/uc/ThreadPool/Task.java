
package com.sap.uc.ThreadPool;
//It is a task that will be submitted to thread pool
//i.e. added to blocking queue
//if blocking queue is full then waits before addition
//when there will be space available in blocking queue then task will be added

//Thread pool has fixed no of worker thread
//if worker thread is available then it will take 1 task from blocking queue and execute it i.e. calss run() method of task
public class Task implements Runnable{

	String name;
	
	public Task(String name){
		this.name = name;
	}
	@Override
	public void run(){
		System.out.println("Task "+name+" started.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("exception in task in "+Thread.currentThread().getName()+" task:"+name);
		}
		System.out.println("Task "+name+" completed.");
		//throw new ArithmeticException("arithmatic exception in "+name);// this exception is handled in worker thread so will go to catch block of Arithmatic exception in worker thread
		//throw new RuntimeException("uncaught exception in "+name);//this exception is not handled in worker thread so it will go to uncaught exception handler
	}
	
	@Override
	public String toString(){
		return name;
	}
}
