package com.rfa.algs.sorting;

import java.util.Arrays;

public class MergeSort<T> extends BaseSort<T> {

	private Comparable<T>[] aux;

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparable<T>[] a) {
		aux = new Comparable[a.length];
		System.out.println("Merge Sort " + Arrays.deepToString(a));
		sort(a, 0, a.length - 1);
	}

	private void sort(Comparable<T>[] a, int lo, int hi) {
		if (hi <= lo) {
			System.out.println("Sort single: " + " lo " + lo + " hi " + hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		System.out.println("Sort: " + " lo " + lo + " mid " + mid + " hi " + hi);
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	private void merge(Comparable<T>[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		System.out.println("Merge: " + " lo " + lo + " mid " + mid + " hi " + hi);
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

}
