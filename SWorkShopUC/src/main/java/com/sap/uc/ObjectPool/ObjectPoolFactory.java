package com.sap.uc.ObjectPool;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ObjectPoolFactory<E> {
	ConcurrentLinkedQueue<E> queue;
	
	public ObjectPoolFactory() {
		super();
	}
	
	public ObjectPoolFactory(int num) {
		queue = new ConcurrentLinkedQueue<>();
		init(num);
		
	}
	
	abstract E createObj();
	
	void init(int numOfObj) {
		for(int i =0; i<numOfObj; i++) {
			queue.add(createObj());
		}
	}
	
	void addObjectBackToPool(E e) {
		if(e == null) {
			return;
		}
		queue.add(e);
	}
	
	E borrowObject() {
		E e;
		if((e= queue.poll())== null){
			e = createObj();
		}
		return e;
	}
}
