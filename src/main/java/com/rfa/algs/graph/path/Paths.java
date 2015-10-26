package com.rfa.algs.graph.path;

public interface Paths {
	boolean hasPathTo(int v);

	Iterable<Integer> pathTo(int v);
}
