package com.rfa.algs.structures.tree;

public class NodeRB<Key extends Comparable<Key>, Value> extends AbstractNode<Key, Value>{

	public static enum Color {
		RED, BLACK
	};

	private Color color;
	private NodeRB<Key, Value> left;
	private NodeRB<Key, Value> right;

	public NodeRB(Key key, Value value) {
		super(key, value);
	}

	public NodeRB(Key key, Value value, Color color) {
		super(key, value);
		this.color = color;
	}

	public NodeRB<Key, Value> getLeft() {
		return left;
	}

	public NodeRB<Key, Value> getRight() {
		return right;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
