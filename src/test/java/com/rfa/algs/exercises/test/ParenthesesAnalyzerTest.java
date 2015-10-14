package com.rfa.algs.exercises.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rfa.algs.exercises.parentheses.ParenthesesAnalyzer;

public class ParenthesesAnalyzerTest {

	@Test
	public void analyzeTest() {
		ParenthesesAnalyzer analyzer = new ParenthesesAnalyzer();
		assertTrue(analyzer.analyze("[()]{}{[()()]()}"));
	}
	
	@Test
	public void analyzeTest2() {
		ParenthesesAnalyzer analyzer = new ParenthesesAnalyzer();
		assertFalse(analyzer.analyze("[(])"));
	}
}
