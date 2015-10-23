package com.rfa.algs.sorting.pq;

public abstract class BasePQ<Key extends Comparable<Key>> implements PriorityQueue<Key> {

	protected Key[] pq;
	protected int N = 0;
	protected static final int MAX_PQ_SIZE = 1024;

	protected boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	protected void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	protected void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	protected void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}
}
