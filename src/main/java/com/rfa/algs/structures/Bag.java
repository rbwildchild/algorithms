package com.rfa.algs.structures;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import com.rfa.algs.structures.iterator.LinkedListIterator;

public class Bag<Item> implements Iterable<Item> {
	private Node<Item> first; // first node in list

	public void add(Item item) { // same as push() in Stack
		Node<Item> oldfirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldfirst;
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
