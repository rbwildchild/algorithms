package com.rfa.algs.structures.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

import com.rfa.algs.structures.Node;

public class LinkedListIterator<Item> implements Iterator<Item> {
	private Node<Item> current;

	public LinkedListIterator(Node<Item> first) {
		current = first;
	}

	public boolean hasNext() {
		return current != null;
	}

	public Item next() {
		Item item = current.item;
		current = current.next;
		return item;
	}

	public void remove() {
	}

	public void forEachRemaining(Consumer<? super Item> action) {
		// TODO Auto-generated method stub
		
	}
}
