package com.rfa.algs.assignments.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	private final int TOP = 0, BOTTOM;
	private int[] matrix;
	private int N;
	private WeightedQuickUnionUF uf;

	public Percolation(int N) {
		if (N <= 0)
			throw new IllegalArgumentException();
		this.N = N;
		BOTTOM = N * N + 1;
		uf = new WeightedQuickUnionUF(N * N + 2);
		matrix = new int[N * N + 2];
		for (int i = 0; i < N * N + 2; i++) {
			matrix[i] = 0;
		}
	}

	public void open(int i, int j) {
		if (isOpen(i, j))
			return;
		i -= 1;
		j -= 1;
		if (i >= N || j >= N || i < 0 || j < 0)
			throw new IndexOutOfBoundsException();
		int index = two2OneDimension(i, j);
		matrix[index] = 1;
		if (i == 0)
			uf.union(index, TOP);
		if (i == N - 1)
			uf.union(index, BOTTOM);
		if (i - 1 >= 0 && matrix[two2OneDimension(i - 1, j)] == 1)
			uf.union(index, two2OneDimension(i - 1, j));
		if (i + 1 < N && matrix[two2OneDimension(i + 1, j)] == 1)
			uf.union(index, two2OneDimension(i + 1, j));
		if (j - 1 >= 0 && matrix[two2OneDimension(i, j - 1)] == 1)
			uf.union(index, two2OneDimension(i, j - 1));
		if (j + 1 < N && matrix[two2OneDimension(i, j + 1)] == 1)
			uf.union(index, two2OneDimension(i, j + 1));
	}

	public boolean isOpen(int i, int j) {
		i -= 1;
		j -= 1;
		if (i >= N || j >= N || i < 0 || j < 0)
			throw new IndexOutOfBoundsException();
		return matrix[two2OneDimension(i, j)] == 1;
	}

	public boolean isFull(int i, int j) {
		i -= 1;
		j -= 1;
		if (i >= N || j >= N || i < 0 || j < 0)
			throw new IndexOutOfBoundsException();
		return uf.connected(two2OneDimension(i, j), TOP);
	}

	public boolean percolates() {
		return uf.connected(TOP, BOTTOM);
	}

	private int two2OneDimension(int i, int j) {
		return i * N + j + 1;
	}
}
