package com.rfa.algs.searching.st;

import com.rfa.algs.structures.Queue;
import com.rfa.algs.structures.tree.AbstractNode;
import com.rfa.algs.structures.tree.Node;

import edu.princeton.cs.algs4.StdOut;

public class BinaryST<Key extends Comparable<Key>, Value> extends BaseST<Key, Value> implements PrintableTree {

	private AbstractNode<Key, Value> root;

	@Override
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	public AbstractNode<Key, Value> put(AbstractNode<Key, Value> node, Key key, Value val) {
		if (node == null)
			return new Node<>(key, val);
		int cmp = key.compareTo(node.getKey());
		if (cmp < 0)
			node.setLeft(put(node.getLeft(), key, val));
		else if (cmp > 0)
			node.setRight(put(node.getRight(), key, val));
		else
			node.setValue(val);
		node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
		return node;
	}

	@Override
	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(AbstractNode<Key, Value> node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.getKey());
		if (cmp < 0)
			return get(node.getLeft(), key);
		else if (cmp > 0)
			return get(node.getRight(), key);
		else
			return node.getValue();
	}

	private AbstractNode<Key, Value> deleteMin(AbstractNode<Key, Value> x) {
		if (x.getLeft() == null)
			return x.getRight();
		x.setLeft(deleteMin(x.getLeft()));
		x.setN(size(x.getLeft()) + size(x.getRight()) + 1);
		return x;
	}

	@Override
	public void delete(Key key) {
		root = delete(root, key);
	}

	private AbstractNode<Key, Value> delete(AbstractNode<Key, Value> node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.getKey());
		if (cmp < 0)
			node.setLeft(delete(node.getLeft(), key));
		else if (cmp > 0)
			node.setRight(delete(node.getRight(), key));
		else {
			if (node.getRight() == null)
				return node.getLeft();
			if (node.getLeft() == null)
				return node.getRight();
			AbstractNode<Key, Value> t = node;
			node = (AbstractNode<Key, Value>) min(t.getRight());
			node.setRight(deleteMin(t.getRight()));
			node.setLeft(t.getLeft());
		}
		node.setN(size(node.getLeft()) + size(node.getRight()) + 1);
		return node;
	}

	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(AbstractNode<Key, Value> x) {
		if (x == null)
			return 0;
		else
			return x.getN();
	}

	@Override
	public Key min() {
		AbstractNode<Key, Value> min = min(root);
		if (min == null)
			return null;
		return min.getKey();
	}

	public AbstractNode<Key, Value> min(AbstractNode<Key, Value> node) {
		if (node == null)
			return null;
		else if (node.getLeft() == null)
			return node;
		else
			return min(node.getLeft());
	}

	@Override
	public Key max() {
		return max(root);
	}

	public Key max(AbstractNode<Key, Value> node) {
		if (node == null)
			return null;
		else if (node.getRight() == null)
			return node.getKey();
		else
			return max(node.getRight());
	}

	@Override
	public Key floor(Key key) {
		AbstractNode<Key, Value> floor = floor(root, key);
		if (floor == null)
			return null;
		return floor.getKey();
	}

	private AbstractNode<Key, Value> floor(AbstractNode<Key, Value> node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.getKey());
		if (cmp == 0)
			return node;
		else if (cmp < 0)
			return floor(node.getLeft(), key);
		AbstractNode<Key, Value> rightFloor = floor(node.getRight(), key);
		if (rightFloor != null)
			return rightFloor;
		else
			return node;
	}

	@Override
	public Key ceiling(Key key) {
		AbstractNode<Key, Value> ceiling = ceiling(root, key);
		if (ceiling == null)
			return null;
		return ceiling.getKey();
	}

	private AbstractNode<Key, Value> ceiling(AbstractNode<Key, Value> node, Key key) {
		if (node == null)
			return null;
		int cmp = key.compareTo(node.getKey());
		if (cmp == 0)
			return node;
		else if (cmp > 0)
			return ceiling(node.getRight(), key);
		AbstractNode<Key, Value> leftFloor = ceiling(node.getLeft(), key);
		if (leftFloor != null)
			return leftFloor;
		else
			return node;
	}

	@Override
	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(AbstractNode<Key, Value> node, Key key) {
		if (node == null)
			return 0;
		int cmp = key.compareTo(node.getKey());
		if (cmp < 0)
			return rank(node.getLeft(), key);
		else if (cmp > 0)
			return size(node.getLeft()) + rank(node.getRight(), key) + 1;
		else
			return size(node.getLeft());
	}

	@Override
	public Key select(int k) {
		AbstractNode<Key, Value> select = select(root, k);
		if (select == null)
			return null;
		return select.getKey();
	}

	private AbstractNode<Key, Value> select(AbstractNode<Key, Value> node, int k) {
		if (node == null)
			return null;
		int s = size(node.getLeft());
		if (k < s)
			return select(node.getLeft(), k);
		else if (k > s)
			return select(node.getRight(), k - s - 1);
		else
			return node;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> queue = new Queue<Key>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(AbstractNode<Key, Value> node, Queue<Key> queue, Key lo, Key hi) {
		if (node == null)
			return;
		int cmplo = lo.compareTo(node.getKey());
		int cmphi = hi.compareTo(node.getKey());
		if (cmplo < 0)
			keys(node.getLeft(), queue, lo, hi);
		if (cmplo <= 0 && cmphi >= 0)
			queue.enqueue(node.getKey());
		if (cmphi > 0)
			keys(node.getRight(), queue, lo, hi);
	}

	public void printInorder() {
		StdOut.println("Inorder");
		printInorder(root);
	}

	public void printInorder(AbstractNode<Key, Value> node) {
		if (node == null)
			return;
		printInorder(node.getLeft());
		StdOut.println(node.getKey() + ": " + node.getValue());
		printInorder(node.getRight());
	}

	@Override
	public void printPreorder() {
		StdOut.println("Preorder");
		printPreorder(root);
	}

	public void printPreorder(AbstractNode<Key, Value> node) {
		if (node == null)
			return;
		StdOut.println(node.getKey() + ": " + node.getValue());
		printPreorder(node.getLeft());
		printPreorder(node.getRight());
	}

	@Override
	public void printPostorder() {
		StdOut.println("Postorder");
		printPostorder(root);
	}

	public void printPostorder(AbstractNode<Key, Value> node) {
		if (node == null)
			return;
		printPostorder(node.getLeft());
		printPostorder(node.getRight());
		StdOut.println(node.getKey() + ": " + node.getValue());
	}

}
