package com.rfa.algs.watch;

public class Stopwatch {
	private long start = -1;

	public void start() {
		if (start == -1)
			start = System.currentTimeMillis();
	}

	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}

}
