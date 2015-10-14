package com.rfa.algs.structures;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.rfa.algs.structures.iterator.LinkedListIterator;

public class Stack<Item> implements Iterable<Item> {
	private Node<Item> first; // top of stack (most recently added node)
	private int N;

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	// Or: N == 0.
	public void push(Item item) { // Add item to top of stack.
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop() { // Remove item from top of stack.
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	public Iterator<Item> iterator() {
		return new LinkedListIterator<Item>(first);
	}

	public Item peek() {
		return first.item;
	}
	
	public void forEach(Consumer<? super Item> action) {
		action.accept(first.item);		
	}

	public Spliterator<Item> spliterator() {
		return null;
	}

}
