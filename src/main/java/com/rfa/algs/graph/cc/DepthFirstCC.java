package com.rfa.algs.graph.cc;

import com.rfa.algs.graph.Graph;

public class DepthFirstCC implements CC {
	private boolean[] marked;
	private int[] id;
	private int count;

	public DepthFirstCC(Graph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int s = 0; s < G.V(); s++)
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v))
			if (!marked[w])
				dfs(G, w);
	}

	@Override
	public boolean connected(int v, int w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int id(int v) {
		// TODO Auto-generated method stub
		return 0;
	}
}
