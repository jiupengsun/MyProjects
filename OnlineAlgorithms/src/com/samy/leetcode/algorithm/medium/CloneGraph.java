package com.samy.leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {

	/**
	 * 
	 * @param node
	 * @return
	 * 2016年4月28日
	 * @author Jiupeng
	 * @description 12 test cases, 8ms beats 56.02%
	 * @reference https://leetcode.com/problems/clone-graph/
	 * @interpretation
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null)
			return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Set<Integer> set = new HashSet<Integer>();
		helper(node, map, set);
		return map.get(node.label);
	}

	private void helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map, Set<Integer> set){
		set.add(node.label);
		UndirectedGraphNode copy = map.get(node.label);
		if(copy == null){
			copy = new UndirectedGraphNode(node.label);
			map.put(node.label, copy);
		}
		// generate topology
		for(UndirectedGraphNode n : node.neighbors){
			UndirectedGraphNode c = map.get(n.label);
			if(c == null){
				c = new UndirectedGraphNode(n.label);
				map.put(n.label, c);
			}
			copy.neighbors.add(c);
		}
		// go to the next node
		for(UndirectedGraphNode n : node.neighbors){
			if(!set.contains(n.label))	
				helper(n, map, set);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode n1 = new UndirectedGraphNode(0);
		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
		UndirectedGraphNode n3 = new UndirectedGraphNode(2);
		n1.neighbors.add(n2);
		n2.neighbors.add(n1);
		n2.neighbors.add(n3);
		n3.neighbors.add(n3);
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode copy = cg.cloneGraph(n1);
		UndirectedGraphNode neibor = copy.neighbors.get(0);
		for(UndirectedGraphNode nei : neibor.neighbors){
			System.out.println(nei.label);
		}
	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
