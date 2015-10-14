package com.rfa.algs.exercises.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rfa.algs.exercises.affix.InfixToPostfix;

public class InfixToPostfixTest {
	@Test
	public void convertTest() {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		assertEquals("AB+", infixToPostfix.convert("A+B"));
	}

	@Test
	public void convertTest2() {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		assertEquals("AB+C-", infixToPostfix.convert("(A+B)-C"));
	}

	@Test
	public void convertTest3() {
		InfixToPostfix infixToPostfix = new InfixToPostfix();
		assertEquals("AB+C*DE-FG+*-",
				infixToPostfix.convert("(A+B)*C-(D-E)*(F+G)"));
	}
}
