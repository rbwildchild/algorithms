package com.rfa.algs.exercises.parentheses;

import com.rfa.algs.structures.Stack;

public class ParenthesesAnalyzer {

	private static final String BEGIN = "{[(";
	private static final String END = "}])";

	public boolean analyze(String input) {
		return analyze(input.toCharArray());
	}

	public boolean analyze(char[] input) {
		Stack<Character> stack = new Stack<Character>();
		boolean valid = true;
		for (char par : input) {
			if (BEGIN.contains(String.valueOf(par))) {
				stack.push(par);
			} else if (END.contains(String.valueOf(par))) {
				char first = stack.pop();
				switch (first) {
				case '{':
					valid = par == '}';
					break;
				case '[':
					valid = par == ']';
					break;
				case '(':
					valid = par == ')';
					break;
				}
			}
			if (!valid)
				break;
		}
		return valid;
	}
}
