package com.rfa.algs.sorting;

public class SelectionSort<T> extends BaseSort<T> {

	@Override
	public void sort(Comparable<T>[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}

}
