package com.sap.uc.ObjectPool;

public class ObjectPoolDriver {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ObjectPool op = new ObjectPool(4);
		System.out.println("Added 4 objects to the pool");
		System.out.println(op.queue.size());
		System.out.println("Retriving an object from the pool");
		Object o = op.borrowObject();
		System.out.print("Size of the pool after an element has been borrowed ");
		System.out.println(op.queue.size());
		System.out.println("element borrowed has been readded to the pool");
		op.addObjectBackToPool(o);
	}
}
