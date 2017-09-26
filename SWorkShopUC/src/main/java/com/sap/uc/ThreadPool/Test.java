package com.sap.uc.ThreadPool;

//Thread pool creates blocking queue with capacity 3 i.e. 3 out of 7 tasks can be submitted at a time
//when 1 task completed then again 1 task will be completed
//Thread pool has 4 worker threads
//each worker thread take a task and executes..1 worker thread will be idle as there is only 3 task in queue at atime
public class Test {

	public static void main(String[] args) throws Exception{
		
		int taskSubmitionCapacity = 3;//blocking queue capacity
		int totalWorkerThread = 4; // no of worker threads present in thread pool
		
		CustomThreadPool threadPool = new CustomThreadPool(taskSubmitionCapacity, totalWorkerThread);
		
		int totalTasks = 6; // no of tasks to be submitted in thread pool
		String taskName = null;
		Runnable task = null;		
		
		for(int i=0; i<totalTasks; i++){
			
			taskName = "task"+i;
			
			task = new Task(taskName);
			 
			threadPool.submitTask(task);
		}
		
		threadPool.shutDown();
		//threadPool.monitorExecutingThreads();
	}
}
