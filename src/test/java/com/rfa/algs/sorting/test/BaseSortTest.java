package com.rfa.algs.sorting.test;

import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.rfa.algs.sorting.Sortator;

public class BaseSortTest {
	protected Sortator<Integer> sortator;

	@Test
	public void sortTest() {
		Integer[] a = new Integer[] { 5, 4, 8, 2, 1, 9, 3, 6, 7 };
		sortator.sort(a);
		assertThat(a, arrayContaining(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}

	@Test
	public void sortTest2() {
		Integer[] a = new Integer[] { 1, 5, 4, 5, 4, 7, 4, 6 };
		sortator.sort(a);
		assertThat(a, arrayContaining(1, 4, 4, 4, 5, 5, 6, 7));
	}
}
