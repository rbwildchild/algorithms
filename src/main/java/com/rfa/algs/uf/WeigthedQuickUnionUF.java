package com.rfa.algs.uf;

import java.util.Arrays;

public class WeigthedQuickUnionUF implements UF {
	private int[] id;
	private int[] sz;
	private int count;

	public WeigthedQuickUnionUF(int N) {
		id = new int[N];
		sz = new int[N];
		count = N;
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	@Override
	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	@Override
	public int find(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	@Override
	public int count() {
		return count;
	}

	public void printIds() {
		System.out.println("IDS  : " + Arrays.toString(id));
	}

	public void printSizes() {
		System.out.println("SIZES: " + Arrays.toString(sz));
	}

}
