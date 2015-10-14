package com.rfa.algs.structures;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ResizableCapacityStack<I> {
	private I[] a;
	// stack entries
	private int N;

	// size

	@SuppressWarnings("unchecked")
	public ResizableCapacityStack(int cap) {
		a = (I[]) new Object[cap];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void push(I item) { // Add item to top of stack.
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;
	}

	public I pop() { // Remove item from top of stack.
		I item = a[--N];
		a[N] = null; // Avoid loitering (see text).
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	@SuppressWarnings("unchecked")
	private void resize(int max) { // Move stack of size N <= max to a new array
									// of size max.
		I[] temp = (I[]) new Object[max];
		for (int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}

	public Iterator<I> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<I> { // Support
																// LIFO
																// iteration.
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public I next() {
			return a[--i];
		}

		public void remove() {
		}

		public void forEachRemaining(Consumer<? super I> action) {
			// TODO Auto-generated method stub

		}
	}

	public void forEach(Consumer<? super I> action) {
		action.accept(a[N - 1]);
	}

	public Spliterator<I> spliterator() {
		return null;
	}
}
