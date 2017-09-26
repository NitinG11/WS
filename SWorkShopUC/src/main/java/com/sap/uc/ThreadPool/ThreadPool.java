package com.sap.uc.ThreadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class CThreadPool {

	int threads;
	BlockingQueue<Runnable> queue;
	
	
	public CThreadPool(int tasksize, int numThreads) {
		queue = new LinkedBlockingQueue<>(tasksize);
		for(int i=0;i<numThreads;i++){
			new PoolThread(queue).start();
		}
	}
	
	void submitTask(Runnable task ) {
		queue.offer(task);
		queue.notify();
	}
	
	private class PoolThread extends Thread {
		
		BlockingQueue<Runnable> bq ;

		public PoolThread(BlockingQueue<Runnable> bq) {
			super();
			this.bq = bq;
		}

		@Override
		public void run() {
			 Runnable task = null;
			while (true) {
				synchronized (bq) {
					while(bq.isEmpty()){
						String name = Thread.currentThread().getName();
					    task =  bq.poll();
					    System.out.println("Task Started by Thread :" + name+","+task);
					}
					 task.run();
				}
				
				    System.out.println("Task Finished by Thread :" +Thread.currentThread().getName() );
			    
			}
			
		}
		
		
	}	
}


class ThreadPool {
	public static void main(String[] args) {
		CThreadPool c = new CThreadPool(3,4);
		for(int i =0;i<5;i++){
//			c.submitTask(new Task(i));
		}
	}
}
