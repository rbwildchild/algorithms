package com.rfa.algs.graph;

import com.rfa.algs.structures.Bag;

public class ALGraph implements Graph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public ALGraph(int V) {
		this.V = V;
		adj = new Bag[V];
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return E;
	}

	@Override
	public void addEdge(int v, int w) {
		if (adj[v] == null)
			adj[v] = new Bag<>();
		adj[v].add(w);
		if (adj[w] == null)
			adj[w] = new Bag<>();
		adj[w].add(v);
		E++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
