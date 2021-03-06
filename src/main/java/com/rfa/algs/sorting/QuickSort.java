package com.rfa.algs.sorting;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort<T> extends BaseSort<T> {

	@Override
	public void sort(Comparable<T>[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private void sort(Comparable<T>[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private int partition(Comparable<T>[] a, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable<T> v = a[lo];
		while (true) {
			while (less(a[++i], v) && i < hi) ;
			while (less(v, a[--j]) && j > lo) ;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

}
