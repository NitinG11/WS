package com.sap.uc.ObjectPool;

public class ObjectPool extends ObjectPoolFactory{

	
	
	public ObjectPool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjectPool(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}

	@Override
	Object createObj() {
		// TODO Auto-generated method stub
		Object obj= new ObjectPool();
		return obj;
	}
	
	

}
