package com.rfa.algs.exercises.affix;

import java.util.HashMap;
import java.util.Map;

import com.rfa.algs.structures.Stack;

public class InfixToPostfix {
	private static final String OPERATOR = "+-*/";

	Map<Character, Integer> precedence = new HashMap<Character, Integer>() {
		private static final long serialVersionUID = -1229296391778032120L;
		{
			put('(', 1);
			put('+', 2);
			put('-', 2);
			put('*', 3);
			put('/', 3);
		}
	};

	public String convert(String infixExpression) {
		char[] expression = infixExpression.trim().toCharArray();
		Stack<Character> operatorStack = new Stack<Character>();
		String postfix = "";
		for (char symbol : expression) {
			String strSymbol = String.valueOf(symbol);
			if (!OPERATOR.contains(strSymbol)
					&& !strSymbol.equalsIgnoreCase("(")
					&& !strSymbol.equalsIgnoreCase(")")) {
				postfix += strSymbol;
			} else if (strSymbol.equalsIgnoreCase("(")) {
				operatorStack.push(symbol);
			}else if (strSymbol.equalsIgnoreCase(")")) {
				String strOperator = "";
				while (!(strOperator = String.valueOf(operatorStack.pop()))
						.equalsIgnoreCase("(")) {
					postfix += strOperator;
				}
			} else if (OPERATOR.contains(strSymbol)) {
				while (!operatorStack.isEmpty()
						&& precedence.get(operatorStack.peek()) >= precedence
								.get(symbol)) {
					postfix += String.valueOf(operatorStack.pop());
				}
				operatorStack.push(symbol);
			}
		}
		while (!operatorStack.isEmpty()) {
			postfix += String.valueOf(operatorStack.pop());
		}
		return postfix;
	}
}
