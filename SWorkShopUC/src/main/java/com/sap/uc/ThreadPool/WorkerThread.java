package com.sap.uc.ThreadPool;

//Thread pool has fixed no of worker threads
//when thread pool starts worker thread ..run()method of worker thread will be called
//Now its responsibility is to take a task from blocking queue and execute it
//This responsibility runs in loop i.e. 
//when 1 task is completed it takes another task from blocking queue
//until blocking queue is empty i.e. there is no task in blocking queue i.e.
//all tasks submitted to thread pool are completed
public class WorkerThread extends Thread{

	CustomBlockingQueue<Runnable> queue;
	volatile boolean isShutDown;
	
	public WorkerThread(CustomBlockingQueue<Runnable> queue){
		this.queue = queue;
		isShutDown = false;
		
	}
	
	@Override
	public void run(){
		try{
		//worker thread takes a task from queue and runs it. After completing 1 task it again takes a task from queue to execute
			while(!isShutDown()){
					
			System.out.println("Worker Thread "+Thread.currentThread().getName()+" started.");
			Runnable task = queue.dequeue(); //takes a task from queue
			System.out.println("Worker Thread "+Thread.currentThread().getName()+" took task "+task);
			
			//if there is any exception in task it will come to worker thread..2 condition arises
			//if exception is handled in worker thread then go to that particular exception block
			//if exception is not handled that means exception is uncaught exception
			//it will call uncaughtexceptionhandler registerd in thread pool and associated with worker thread before starting a new worker thread
			//now after handling the exception in both cases we can again execute worker thread by calling workerThread.run() method
			task.run();//execute the task
			System.out.println("Worker Thread "+Thread.currentThread().getName()+" completed task "+task);
			//after completion it again takes task to execute
			//until there is task in queue
			//throw new RuntimeException("exception in "+this.getName());
			}
		}catch(InterruptedException ex){
			System.out.println("Worker thread "+this.getName()+" Interrupted Exception");
		}catch(ArithmeticException ex){
			System.out.println("Worker thread "+this.getName()+" Interrupted Exception");
			this.run();//it will again start execution of worker thread
		}
		
		
	}
	
	public boolean isShutDown(){
		return isShutDown;
	}
	
	public synchronized void shut(){
		System.out.println(this.getName()+" shut down initiated.");
		isShutDown = true;
		this.interrupt();
		System.out.println(this.getName()+" interrupt called.");
		try {
			sleep(1);
		} catch (Exception e) {
			System.out.println("worker exception in shutdown: "+this.getName());
		}
	}
	
	public synchronized void shutDownNow(){
		//
	}

}
