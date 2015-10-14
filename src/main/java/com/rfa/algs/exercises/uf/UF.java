package com.rfa.algs.exercises.uf;

public interface UF {
	void union(int p, int q);

	int find(int p);

	boolean connected(int p, int q);

	int count();
	
	void printIds();
}
