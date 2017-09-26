package com.sap.uc.Sorting;

public class MergeSort {

	static int a[] = { 22, 43, 6, 1, 41, 5 };

	public static void main(String[] args) {
		mergeSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}

	static void mergeSort(int[] a) {
		int mid = (a.length) / 2;
		int leftArray[] = new int[mid];
		int rightArray[] = new int[a.length - mid];

		if (a.length < 2)
			return;
		for (int i = 0; i < mid; i++) {
			leftArray[i] = a[i];
		}
		for (int j = 0; j < a.length - mid; j++) {
			rightArray[j] = a[j+mid];
		}

		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(a, leftArray, rightArray);

	}

	static void merge(int[] a, int left[], int right[]) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				a[k] = left[i];
				k++;
				i++;
			} else {
				if (right[j] < left[i]) {
					a[k] = right[j];
					k++;
					j++;
				}
			}
		}
		while (i < left.length) {
			a[k] = left[i];
			k++;
			i++;
		}
		while (j < right.length) {
			a[k] = right[j];
			k++;
			j++;
		}
	}
}
