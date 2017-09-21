package com.sap.uc.Concurrency.Locks;

public class CReentrantLock implements ILock {

	int lockCount;
	long threadId;

	public CReentrantLock() {
		super();
		this.lockCount = 0;
	}

	@Override
	public synchronized boolean tryLock() throws InterruptedException {
		// TODO Auto-generated method stub
		if (lockCount == 0) {
			lock();
			return false;
		} else {
			return true;
		}

	}

	@Override
	public synchronized void  lock() throws InterruptedException {
		// TODO Auto-generated method stub
		if (lockCount == 0) {
			lockCount++;
			threadId = Thread.currentThread().getId();
		}

		else {
			if (lockCount > 0 && threadId == Thread.currentThread().getId()) {
				lockCount++;
			} else {
				wait();
				lockCount++;
				threadId = Thread.currentThread().getId();
			}

		}
	}

	@Override
	public synchronized void unlock() throws InterruptedException {
		// TODO Auto-generated method stub

		lockCount--;
		if (lockCount == 0)
			notifyAll();

	}

}

interface ILock {

	boolean tryLock() throws InterruptedException;

	void lock() throws InterruptedException;

	void unlock() throws InterruptedException;
}