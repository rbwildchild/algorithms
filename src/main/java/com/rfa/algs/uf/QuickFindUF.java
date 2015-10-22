package com.rfa.algs.uf;

import java.util.Arrays;

public class QuickFindUF implements UF {

	private int[] a;
	private int count;

	public QuickFindUF(int N) {
		a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = i;
		count = N;
	}

	@Override
	public void union(int p, int q) {
		int compP = find(p);
		int compQ = find(q);
		if (compP == compQ)
			return;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == compQ)
				a[i] = compP;
		}
		count--;
	}

	@Override
	public int find(int p) {
		return a[p];
	}

	@Override
	public boolean connected(int p, int q) {
		return a[p] == a[q];
	}

	@Override
	public int count() {
		return count;
	}

	public void printIds() {
		System.out.println("IDS  : " + Arrays.toString(a));
	}
}
