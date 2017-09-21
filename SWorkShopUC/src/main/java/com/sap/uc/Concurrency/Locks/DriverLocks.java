package com.sap.uc.Concurrency.Locks;

public class DriverLocks {

	public static void main(String[] args) {
		CReentrantLock lock = new CReentrantLock();
		Mylock myLock = new Mylock(lock);
		Thread thread = new Thread(myLock, "Thread 1");
		thread.start();
		Thread thread1 = new Thread(myLock, "Thread 12");
		thread1.start();
	}
}

class Mylock implements Runnable {

	CReentrantLock cL;
	
	public Mylock(CReentrantLock cL) {
		super();
		this.cL = cL;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Awaiting for lock");
		try {
			cL.lock();
			System.out.println("Loc Aquired by "+Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("Releasing lock "+Thread.currentThread().getName());
			cL.unlock();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
