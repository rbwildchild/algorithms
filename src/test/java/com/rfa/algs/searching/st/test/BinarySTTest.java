package com.rfa.algs.searching.st.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.rfa.algs.searching.st.BinaryST;
import com.rfa.algs.searching.st.PrintableTree;
import com.rfa.algs.searching.st.SymbolTable;

public class BinarySTTest {
	@Test
	public void putTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(15, "Fifteen");
		st.put(5, "NumberFive");
		assertEquals(3, st.size());
	}

	@Test
	public void getTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(15, "Fifteen");
		st.put(5, "NumberFive");
		assertEquals("Fifteen", st.get(15));
		assertEquals("NumberFive", st.get(5));
		assertEquals("Ten", st.get(10));
	}

	@Test
	public void getMinMaxTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(1, "One");
		st.put(2, "Two");
		st.put(15, "Fifteen");
		st.put(11, "Eleven");
		st.put(18, "Eighteen");
		st.put(50, "Fifty");
		assertEquals(new Integer(1), st.min());
		assertEquals(new Integer(50), st.max());
	}

	@Test
	public void floorTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(1, "One");
		st.put(2, "Two");
		st.put(15, "Fifteen");
		st.put(11, "Eleven");
		st.put(18, "Eighteen");
		st.put(50, "Fifty");
		assertNull(st.floor(0));
		assertEquals(new Integer(15), st.floor(16));
		assertEquals(new Integer(18), st.floor(18));
		assertEquals(new Integer(50), st.floor(51));
	}

	@Test
	public void ceilingTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(1, "One");
		st.put(2, "Two");
		st.put(15, "Fifteen");
		st.put(11, "Eleven");
		st.put(18, "Eighteen");
		st.put(50, "Fifty");
		assertNull(st.ceiling(51));
		assertEquals(new Integer(5), st.ceiling(4));
		assertEquals(new Integer(18), st.ceiling(18));
		assertEquals(new Integer(1), st.ceiling(0));
	}

	@Test
	public void selectTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(1, "One");
		st.put(2, "Two");
		st.put(15, "Fifteen");
		st.put(11, "Eleven");
		st.put(18, "Eighteen");
		st.put(50, "Fifty");
		assertEquals(new Integer(1), st.select(0));
		assertEquals(new Integer(2), st.select(1));
		assertEquals(new Integer(5), st.select(2));
		assertEquals(new Integer(10), st.select(3));
		assertEquals(new Integer(11), st.select(4));
		assertEquals(new Integer(15), st.select(5));
		assertEquals(new Integer(18), st.select(6));
		assertEquals(new Integer(50), st.select(7));
	}

	@Test
	public void rankTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(1, "One");
		st.put(2, "Two");
		st.put(15, "Fifteen");
		st.put(11, "Eleven");
		st.put(18, "Eighteen");
		st.put(50, "Fifty");
		assertEquals(new Integer(0), new Integer(st.rank(1)));
		assertEquals(new Integer(1), new Integer(st.rank(2)));
		assertEquals(new Integer(2), new Integer(st.rank(5)));
		assertEquals(new Integer(3), new Integer(st.rank(10)));
		assertEquals(new Integer(4), new Integer(st.rank(11)));
		assertEquals(new Integer(5), new Integer(st.rank(15)));
		assertEquals(new Integer(6), new Integer(st.rank(18)));
		assertEquals(new Integer(7), new Integer(st.rank(50)));
	}

	@Test
	public void deleteTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(1, "One");
		st.put(2, "Two");
		st.put(15, "Fifteen");
		st.put(11, "Eleven");
		st.put(18, "Eighteen");
		st.put(50, "Fifty");
		st.delete(50);
		assertEquals("Ten", st.get(10));
		assertEquals("Five", st.get(5));
		assertEquals("One", st.get(1));
		assertEquals("Two", st.get(2));
		assertEquals("Fifteen", st.get(15));
		assertEquals("Eleven", st.get(11));
		assertEquals("Eighteen", st.get(18));
		assertNull(st.get(50));
	}

	@Test
	public void printTest() {
		SymbolTable<Integer, String> st = new BinaryST<>();
		st.put(10, "Ten");
		st.put(5, "Five");
		st.put(1, "One");
		st.put(2, "Two");
		st.put(15, "Fifteen");
		st.put(11, "Eleven");
		st.put(18, "Eighteen");
		st.put(50, "Fifty");
		((PrintableTree) st).printInorder();
		((PrintableTree) st).printPreorder();
		((PrintableTree) st).printPostorder();
	}
}
