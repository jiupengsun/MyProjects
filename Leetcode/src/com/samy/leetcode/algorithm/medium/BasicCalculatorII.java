package com.samy.leetcode.algorithm.medium;

public class BasicCalculatorII {

	/**
	 * 
	 * @param s
	 * @return
	 * Apr 25, 2016
	 * @author Jiupeng
	 * @description It words, while may overflow if the input sequence is too long
	 * @reference https://leetcode.com/problems/basic-calculator-ii/
	 * @interpretation
	 */
	public int calculate(String s) {
		// construct the tree
		Tree root = parseTree(s);
		return calculate(root);
	}

	private Tree parseTree(String s) {
		int l = s.length(), i = 0, j = 0;
		Tree root = null;
		while (i < l) {
			char c = 0;
			while (i < l) {
				c = s.charAt(i);
				if (c == ' ' || c <= '9' && c >= '0')
					++i;
				else
					break;
			}
			// truncate and transform to int
			Tree num = new Tree(Integer.parseInt(s.substring(j, i).trim()), true);
			if (root == null)
				root = num;
			else {
				// always add data node to the rightmost
				Tree tmp = root;
				while (tmp.right != null)
					tmp = tmp.right;
				tmp.right = num;
			}

			if (i < l) {
				// contains next operator
				Tree oper = new Tree(c, false);
				// if root.type is true, which means root is a value node,
				// the root should be an operator node if there are more than one numbers
				// in the formula, thus we should replace root with new operator node
				// on the other hand, if the root is an operator node with a non-lower priority
				// let's say, the root is a + operator and new node is a - operator
				// then we should replace root with new operator, and append root to 
				// the left of the new operator
				if (root.type || !hasHigherPriority(root, oper)) {
					Tree tmp = root;
					root = oper;
					oper.left = tmp;
				} else {
					// otherwise, we should append the right node of root to the left of
					// the new operator node, and replace right node of root with this
					// new operator node
					oper.left = root.right;
					root.right = oper;
				}
			}
			j = ++i;
		}
		return root;
	}

	private boolean hasHigherPriority(Tree node1, Tree node2) {
		return ((node1.val == '+' || node1.val == '-')
				&& (node2.val == '*' || node2.val == '/'));
	}

	private int calculate(Tree root) {
		if (root == null)
			return 0;
		if (root.type)
			return root.val;
		char c = (char) root.val;
		int left = calculate(root.left);
		int right = calculate(root.right);
		switch (c) {
		case '+':
			return left + right;
		case '-':
			return left - right;
		case '*':
			return left * right;
		case '/':
			return left / right;
		default:
			return 0;
		}

	}

	/**
	 * 
	 * @param s
	 * @return
	 * Apr 26, 2016
	 * @author Jiupeng
	 * @description
	 * @reference 
	 * @interpretation
	 */
	public int calculate2(String s) {
		int l = s.length(), i = 0, j = 0;
		Tree root = null;
		while (i < l) {
			char c = 0;
			while (i < l) {
				c = s.charAt(i);
				if (c == ' ' || c <= '9' && c >= '0')
					++i;
				else
					break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "3+2*2";
		String s2 = " 3/2 ";
		String s3 = " 3+5 / 2";
		String s4 = "100000000/1/2/3/4/5/6/7/8/9/10";
		String s5 = "1*2-3/4+5*6-7*8+9/10";
		BasicCalculatorII bc = new BasicCalculatorII();
		System.out.println(bc.calculate(s1));
		System.out.println(bc.calculate(s2));
		System.out.println(bc.calculate(s3));
		System.out.println(bc.calculate(s4));
		System.out.println(bc.calculate(s5));
	}

}

class Tree {

	public Tree(int v, boolean t) {
		val = v;
		type = t;
	}

	int val;
	// false means operator, then val is the value of operator
	// true means number
	boolean type;
	Tree left;
	Tree right;
}
