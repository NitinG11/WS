package com.sap.uc.ThreadPool;

import java.util.ArrayList;
import java.util.List;

//We are creating a thread pool
//We will submit task in thread pool
//It will create a blocking queue with given capacity
//Thread pool will add tasks submitted to this blocking queue
//If blocking queue is full then it will wait for completion of already submitted task
//when 1 task completes then thread pool will again add remaining tasks 1 by 1
//Thread pool has fixed no of worker threads
//Thread pool will start these worker threads
//Each worker thread will take 1 task from blocking queue and executes it
//After completion of 1 task 1 space will be available in blocking queue where thread pool can submit 1 task
//After completion of 1 Task , worker thread will again takes 1 task from blocking queue and executes it
public class CustomThreadPool {

	private CustomBlockingQueue<Runnable> queue;
	private boolean shutDownInitiated;
	List<WorkerThread> workerThreadList = null;
	
	//constructor will create blocking queue and worker threads
	public CustomThreadPool(int taskSubmitionCapacity, int totalWorkerThread){
		
		shutDownInitiated = false;
		
		//taskSubmitionCapacity is max no of tasks that can be added to blocking queue at a time
		//totalWorkerThread is no of worker thread in thread pool
		
		//blocking queue with capacity 'taskSubmitionCapacity' is created
		queue = new CustomBlockingQueue<Runnable>(taskSubmitionCapacity);
		
		//if there is any exception in task it will go to worker thread..2 condition arises
		//if exception is handled in worker thread then go to that particular exception block
		//if exception is not handled that means exception is uncaught exception
		//it will come here
		//now after handling the exception in both cases we can again execute worker thread by calling workerThread.run() method
		Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread workerThread, Throwable e) {
				System.out.println(workerThread+" got uncaught exception "+e);	//we handled uncaughtexception . we can take any required action here
				workerThread.run();//it will again start execution of worker thread
			}
		};
		
		workerThreadList = new ArrayList<WorkerThread>();
		
		//now 'totalWorkerThread' no of worker threads will be created
		for(int i=0; i<totalWorkerThread; i++){		
			workerThreadList.add(new WorkerThread(queue));
		}
		
		for(WorkerThread workerThread:workerThreadList){
			workerThread.setUncaughtExceptionHandler(handler);
			workerThread.start();
		}
		
	}
	
	//if shutdown() method is called then it reurns tru else it will return false
	public boolean isShutDownInitiated(){
		return shutDownInitiated;
	}
	
	//shutdown thread pool
	public void shutDown(){
		shutDownInitiated = true;
		
		for(WorkerThread worker:workerThreadList){
			worker.shut();			
		}
	}
	
	
	public void shutDownNow(){
		shutDownInitiated = true;
		
		//if there is any task in queue that will be cleared
		if(queue.size()>0){
			queue.clear();
		}
		
		for(WorkerThread worker:workerThreadList){
			worker.shutDownNow();			
		}
	}
	
	
	//adds task to blocking queue
	public void submitTask(Runnable task) throws Exception{
		if(isShutDownInitiated()){
			throw new Exception("Shut down has been initiated. New task can not be added.");
		}
		
		queue.enqueue(task);
	}
	
	//get currently active threads
	public synchronized void monitorExecutingThreads(){
		shutDownInitiated = true;
		
		int totalThread = workerThreadList.size();
		int activeThread = 0;
		int waitingThread = 0;// execution started but blockingqueue is empty(WAITITNG) or BLOCKED 
		int idleThread = 0;// execution not started yet i.e. run() is not called
		
		String state = null;
		
		for(WorkerThread worker:workerThreadList){
			 
			state = worker.getState().toString();
			if(state.equals("WAITING") || state.equals("BLOCKED")){
				waitingThread++;
			}else if(state.equals("TIMED_WAITING")){
				activeThread++;
			}else if(state.equals("RUNNABLE")){
				idleThread++;
			}
			
			System.out.println(worker.getName()+" state: "+worker.getState());		
		}
		
		System.out.println("Total worker threads:"+totalThread+" active threads:"+activeThread+" waiting threads: "+waitingThread+" idle thread: "+idleThread);
	}
}
