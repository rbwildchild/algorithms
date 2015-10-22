package com.rfa.algs.sorting.pq;

public interface PriorityQueue<Key extends Comparable<Key>> {
	void insert(Key k);

	Key max();

	Key delMax();

	boolean isEmpty();

	int size();
}
