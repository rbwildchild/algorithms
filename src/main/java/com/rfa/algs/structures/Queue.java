package com.rfa.algs.structures;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.rfa.algs.structures.iterator.LinkedListIterator;

public class Queue<Item> implements Iterable<Item>{
	private Node<Item> first; // link to least recently added node
	private Node<Item> last; // link to most recently added node
	private int N;

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	// Or: N == 0.
	public void enqueue(Item item) { // Add item to the end of the list.
		Node<Item> oldlast = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (isEmpty())
			first = last;
		else
			oldlast.next = last;
		N++;
	}

	public Item dequeue() { // Remove item from the beginning of the list.
		Item item = first.item;
		first = first.next;
		if (isEmpty())
			last = null;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator() {
		return new LinkedListIterator<Item>(first);
	}
	
	public void forEach(Consumer<? super Item> action) {
		action.accept(first.item);		
	}

	public Spliterator<Item> spliterator() {
		return null;
	}
}
