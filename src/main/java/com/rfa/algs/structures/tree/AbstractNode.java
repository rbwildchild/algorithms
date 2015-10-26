package com.rfa.algs.structures.tree;

public abstract class AbstractNode<Key extends Comparable<Key>, Value> {
	private Key key;
	private Value value;
	private int N = 1;
	private AbstractNode<Key, Value> left;
	private AbstractNode<Key, Value> right;

	public AbstractNode(Key key, Value value){
		this.key = key;
		this.value = value;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public AbstractNode<Key, Value> getLeft() {
		return left;
	}

	public void setLeft(AbstractNode<Key, Value> left) {
		this.left = left;
	}

	public AbstractNode<Key, Value> getRight() {
		return right;
	}

	public void setRight(AbstractNode<Key, Value> right) {
		this.right = right;
	}
}
