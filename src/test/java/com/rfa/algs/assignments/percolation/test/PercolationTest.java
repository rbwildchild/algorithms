package com.rfa.algs.assignments.percolation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rfa.algs.assignments.percolation.Percolation;

public class PercolationTest {
	@Test
	public void openTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(1, 1);
		percolation.open(1, 2);
		percolation.open(2, 1);
		percolation.open(2, 2);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void openExceptionTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(3, 1);
		percolation.open(0, 1);
		percolation.isOpen(0, 1);
	}

	@Test
	public void isOpenTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(1, 1);
		assertTrue(percolation.isOpen(1, 1));
		assertFalse(percolation.isOpen(2, 1));
		assertFalse(percolation.isOpen(2, 2));
	}

	@Test
	public void isFullTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(1, 1);
		assertTrue(percolation.isFull(1, 1));
		assertFalse(percolation.isFull(2, 1));
		assertFalse(percolation.isFull(1, 2));
	}

	@Test
	public void isFullTest2() {
		Percolation percolation = new Percolation(2);
		percolation.open(1, 2);
		percolation.open(2, 1);
		assertTrue(percolation.isFull(1, 2));
		assertFalse(percolation.isFull(1, 1));
		assertFalse(percolation.isFull(2, 2));
		assertFalse(percolation.isFull(2, 2));
	}
	
	@Test
	public void isFullTest4() {
		Percolation percolation = new Percolation(4);
		percolation.open(4, 2);
		percolation.open(4, 3);
		assertFalse(percolation.isFull(4, 2));
		assertFalse(percolation.isFull(4, 3));
	}

	@Test
	public void percolatesTest() {
		Percolation percolation = new Percolation(2);
		percolation.open(1, 2);
		percolation.open(2, 2);
		assertTrue(percolation.percolates());
	}

	@Test
	public void percolatesTest2() {
		Percolation percolation = new Percolation(2);
		percolation.open(1, 2);
		percolation.open(2, 1);
		assertFalse(percolation.percolates());
	}

	@Test
	public void percolatesTest3() {
		Percolation percolation = new Percolation(3);
		percolation.open(1, 1);
		percolation.open(2, 1);
		percolation.open(2, 2);
		percolation.open(3, 2);
		assertTrue(percolation.percolates());
	}
	
	@Test
	public void percolatesTest4() {
		Percolation percolation = new Percolation(3);
		percolation.open(1, 1);
		percolation.open(2, 1);
		percolation.open(2, 2);
		percolation.open(2, 3);
		percolation.open(3, 3);
		assertTrue(percolation.percolates());
	}
	
	@Test
	public void percolatesTest5() {
		Percolation percolation = new Percolation(3);
		percolation.open(1, 1);
		percolation.open(2, 2);
		percolation.open(3, 3);
		assertFalse(percolation.percolates());
	}
}
