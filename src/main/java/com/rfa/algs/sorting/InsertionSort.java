package com.rfa.algs.sorting;

public class InsertionSort<T> extends BaseSort<T> {

	@Override
	public void sort(Comparable<T>[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

}
