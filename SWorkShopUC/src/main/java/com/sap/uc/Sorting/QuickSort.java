package com.sap.uc.Sorting;

public class QuickSort {

	static int []a = {23,55,2,1,5,98,54,11};
	public static void main(String[] args) {
		int start= 0;
		int end = a.length-1;
		quickSort(a, start, end);
		
		for(int i : a){
			System.out.println(i);
		}
	}
	
	static void quickSort(int a[], int start, int end) {
		if(start<end) {
			int pIndex = partition(a, start, end);
			quickSort(a, start, pIndex-1);
			quickSort(a, pIndex+1, end);
		}
	}
	
	static int partition(int a[], int start, int end) {
		int pivot = a[end];
		int pIndex = start;

		for(int i =start;i<end;i++) {
			if(a[i]<=pivot) {
				int temp = a[i];
				a[i] = a[pIndex];
				a[pIndex] = temp;
				pIndex ++;
			}
		}
		int temp = a[pIndex];
		a[pIndex] = a[end];
		a[end] = temp;
		return pIndex;
	}
}
