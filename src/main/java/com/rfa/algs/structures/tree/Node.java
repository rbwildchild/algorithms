package com.rfa.algs.structures.tree;

public class Node<Key extends Comparable<Key>, Value> extends AbstractNode<Key, Value>{
	
	public Node(Key key, Value value){
		super(key, value);
	}

}
