package com.samy.leetcode.algorithm.medium;

public class BasicCalculatorII {

	/**
	 * 
	 * @param s
	 * @return
	 * Apr 25, 2016
	 * @author Jiupeng
	 * @description
	 * @reference https://leetcode.com/problems/basic-calculator-ii/
	 * @interpretation
	 */
	public int calculate(String s){
		// construct the tree
		TreeNode root = parseTree(s);
		return calculate(root);
	}

	private TreeNode parseTree(String s){
		TreeNode root, right;
		int i=0, j=0, l=s.length();
		while(i < l){
			char c;
			while(i < l){
				c = s.charAt(i);
				if(c != ' ' && c >= '9' || c <= '0')
					break;
				++i;
			}
			TreeNode num = new TreeNode(Integer.parseInt(s.substring(j, i)), true);
			if(root == null){
				root = num;
				right = root;
			} else {
				right.right = num;
			}

			if(i < l){
				// c is an operator
				TreeNode oper = new TreeNode(c, false);
				if(right.type){
					// operator
					if (right.val == '+' || right.val == '-' && oper.val == '*' || oper.val == '/'){
						// high priority
						oper.left = right.left;
						right.left = 
					}
				}
			}
			++i;
		}
		return root;
	}

	private int calculate(TreeNode root){
		if(root == null)
			return 0;
		if(root.type)	
			return root.val;
		char c = (char)root.val;
		int left = calculate(root.left);
		int right = calculate(root.right);
		switch(c){
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "3+2*2";
		String s2 = " 3/2 ";
		String s3 = " 3+5 / 2";
		String s4 = "100000000/1/2/3/4/5/6/7/8/9/10";
		BasicCalculatorII bc = new BasicCalculatorII();
		System.out.println(bc.calculate(s1));
		System.out.println(bc.calculate(s2));
		System.out.println(bc.calculate(s3));
		System.out.println(bc.calculate(s4));
	}

}

class TreeNode {
	
	public TreeNode(int v, boolean t){
		val = v;
		type = t;
	}

	int val;
	// false means operator, then val is the value of operator
	// true means number
	boolean type;
	TreeNode left;
	TreeNode right;
}
