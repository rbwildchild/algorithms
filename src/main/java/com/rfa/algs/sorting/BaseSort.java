package com.rfa.algs.sorting;

public abstract class BaseSort<T> implements Sortator<T> {
	@SuppressWarnings("unchecked")
	protected boolean less(Comparable<T> c1, Comparable<T> c2) {
		return c1.compareTo((T) c2) < 0;
	}

	protected void exch(Comparable<T> a[], int i, int j) {
		Comparable<T> t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
