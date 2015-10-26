package com.rfa.algs.graph.cc;

public interface CC {
	boolean connected(int v, int w);

	int count();

	int id(int v);
}
