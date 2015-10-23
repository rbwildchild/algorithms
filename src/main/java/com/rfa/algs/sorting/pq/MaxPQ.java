package com.rfa.algs.sorting.pq;

public class MaxPQ<Key extends Comparable<Key>> extends BasePQ<Key> {

	public MaxPQ() {
		this(MAX_PQ_SIZE);
	}

	@SuppressWarnings("unchecked")
	public MaxPQ(int max) {
		pq = (Key[]) new Comparable[max];
	}

	public MaxPQ(Key[] a) {
		pq = a;
	}

	@Override
	public void insert(Key k) {
		pq[++N] = k;
		swim(N);
	}

	@Override
	public Key max() {
		return pq[1];
	}

	@Override
	public Key delMax() {
		Key key = pq[1];
		exch(1, N--);
		pq[N+1] = null;
		sink(1);
		return key;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

}
