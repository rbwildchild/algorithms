package com.rfa.algs.structures;

public class FixedCapacityStack<I> {
	private I[] a;
	// stack entries
	private int N;

	// size
	
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int cap) {
		a = (I[]) new Object[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(I item) {
		a[N++] = item;
	}

	public I pop() {
		return a[--N];
	}

}
