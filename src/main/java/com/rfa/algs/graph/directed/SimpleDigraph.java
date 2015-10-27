package com.rfa.algs.graph.directed;

import com.rfa.algs.structures.Bag;

public class SimpleDigraph implements Digraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public SimpleDigraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new Bag[V];
		for (int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
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
		adj[v].add(w);
		E++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	@Override
	public Digraph reverse() {
		Digraph digraphReverse = new SimpleDigraph(V);
		for (int v = 0; v < V; v++) {
			for (Integer w : adj[v]) {
				digraphReverse.addEdge(w, v);
			}
		}
		return digraphReverse;
	}

}
