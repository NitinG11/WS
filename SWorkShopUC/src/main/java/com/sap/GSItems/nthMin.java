package com.sap.GSItems;

import java.util.PriorityQueue;

public class nthMin {

	public static void main(String[] args) {
		int a[] = {32,42,1,-9,3,33,42,-4};
		findNthMin(-6,a);
		find2ndMin(a);
	}
	
	static void findNthMin(int num,int ...a) {
		if(num>a.length || num<a.length){
			System.out.println("Trying to find a number outside range ");
			return;
		}
		PriorityQueue queue = new PriorityQueue<>();
		for(int x :a) {
			queue.add(x);
		}
		while(num>1){
			queue.poll();
			num--;
		}
		System.out.println(queue.peek());
	}
	
	static void find2ndMin(int ...a) {
		int max= a[0];
		int min =0;
		for(int i : a){
			if(i<max) {
				min = max;
				max = i;
			} else {
				if(i < min)
					min = i;
			}
		}
		System.out.println("2nd Smallest Number in the array is "+min);
	}
}
