package com.rfa.algs.assignments.percolation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rfa.algs.assignments.percolation.Percolation;

public class PercolationTest {
	@Test
	public void openTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(0, 0);
		percolation.open(0, 1);
		percolation.open(1, 0);
		percolation.open(1, 1);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void openExceptionTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(2, 0);
	}

	@Test
	public void isOpenTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(0, 0);
		assertTrue(percolation.isOpen(0, 0));
		assertFalse(percolation.isOpen(1, 0));
		assertFalse(percolation.isOpen(1, 1));
	}

	@Test
	public void isFullTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(0, 0);
		assertTrue(percolation.isFull(0, 0));
		assertFalse(percolation.isFull(1, 0));
		assertFalse(percolation.isFull(0, 1));
	}

	@Test
	public void isFullTest2() {
		Percolation percolation = new Percolation(2);
		percolation.open(0, 1);
		percolation.open(1, 0);
		assertTrue(percolation.isFull(0, 1));
		assertFalse(percolation.isFull(0, 0));
		assertFalse(percolation.isFull(1, 0));
		assertFalse(percolation.isFull(1, 1));
	}

	@Test
	public void percolatesTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(0, 1);
		percolation.open(1, 1);
		assertTrue(percolation.percolates());
	}

	@Test
	public void percolatesTest2() {
		Percolation percolation = new Percolation(2);
		percolation.open(0, 1);
		percolation.open(1, 0);
		assertFalse(percolation.percolates());
	}

	@Test
	public void percolatesTest3() {
		Percolation percolation = new Percolation(3);
		percolation.open(0, 0);
		percolation.open(1, 0);
		percolation.open(1, 1);
		percolation.open(2, 1);
		assertTrue(percolation.percolates());
	}
	
	@Test
	public void percolatesTest4() {
		Percolation percolation = new Percolation(3);
		percolation.open(0, 0);
		percolation.open(1, 0);
		percolation.open(1, 1);
		percolation.open(1, 2);
		percolation.open(2, 2);
		assertTrue(percolation.percolates());
	}
	
	@Test
	public void percolatesTest5() {
		Percolation percolation = new Percolation(3);
		percolation.open(0, 0);
		percolation.open(1, 1);
		percolation.open(2, 2);
		assertFalse(percolation.percolates());
	}
}
