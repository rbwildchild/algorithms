package com.rfa.algs.sorting.pq.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rfa.algs.sorting.pq.MaxPQ;

public class MaxPQTest {

	@Test
	public void insertTest() {
		MaxPQ<Integer> pq = new MaxPQ<>(10);
		pq.insert(2);
		pq.insert(8);
		pq.insert(9);
		pq.insert(5);
		assertEquals(new Integer(9), pq.max());
	}

	@Test
	public void insertTes2() {
		MaxPQ<Integer> pq = new MaxPQ<>(10);
		pq.insert(2);
		pq.insert(10);
		pq.insert(9);
		pq.insert(10);
		assertEquals(new Integer(10), pq.max());
	}

	@Test
	public void delMaxTest() {
		MaxPQ<Integer> pq = new MaxPQ<>(10);
		pq.insert(2);
		pq.insert(8);
		pq.insert(9);
		pq.insert(5);
		assertEquals(new Integer(9), pq.delMax());
		assertEquals(new Integer(8), pq.delMax());
		assertEquals(new Integer(5), pq.max());
	}

	@Test
	public void delMaxTest2() {
		MaxPQ<Integer> pq = new MaxPQ<>(10);
		pq.insert(2);
		pq.insert(10);
		pq.insert(9);
		pq.insert(10);
		assertEquals(new Integer(10), pq.delMax());
		assertEquals(new Integer(10), pq.delMax());
		assertEquals(new Integer(9), pq.max());
	}
}
