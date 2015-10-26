package com.rfa.algs.searching.st;

import static com.rfa.algs.structures.tree.NodeRB.Color.BLACK;
import static com.rfa.algs.structures.tree.NodeRB.Color.RED;

import com.rfa.algs.structures.tree.NodeRB;

public class BalancedST<Key extends Comparable<Key>, Value> extends BaseST<Key, Value> {

	@Override
	public void put(Key key, Value val) {
		// TODO Auto-generated method stub

	}

	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Key> keys(Key lo, Key hi) {
		// TODO Auto-generated method stub
		return null;
	}

	private NodeRB<Key, Value> rotateLeft(NodeRB<Key, Value> node) {
		NodeRB<Key, Value> right = node.getRight();
		node.setRight(right.getLeft());
		right.setLeft(node);
		right.setColor(node.getColor());
		node.setColor(NodeRB.Color.RED);
		right.setN(node.getN());
		node.setN(1 + size(node.getLeft()) + size(node.getRight()));
		return right;
	}

	private NodeRB<Key, Value> rotateRight(NodeRB<Key, Value> node) {
		NodeRB<Key, Value> left = node.getLeft();
		node.setLeft(left.getRight());
		left.setRight(node);
		left.setColor(node.getColor());
		node.setColor(RED);
		left.setN(node.getN());
		node.setN(1 + size(node.getLeft()) + size(node.getRight()));
		return left;

	}

	void flipColors(NodeRB<Key, Value> h) {
		h.setColor(RED);
		h.getLeft().setColor(BLACK);
		h.getRight().setColor(BLACK);
	}

	private int size(NodeRB<Key, Value> x) {
		if (x == null)
			return 0;
		else
			return x.getN();
	}

}
