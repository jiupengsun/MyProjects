package com.samy.leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

	/**
	 * 
	 * @param tickets
	 * @return
	 * 2016年5月1日
	 * @author Jiupeng
	 * @description 79 test cases, 21ms beats 33.30%
	 * @reference https://leetcode.com/problems/reconstruct-itinerary/
	 * @interpretation When facing the graph problem, dfs and bfs are the most common used methods
	 */
	public List<String> findItinerary(String[][] tickets) {
		Map<String, List<String[]>> route = new HashMap<String, List<String[]>>();
		List<String> order = new LinkedList<String>();
		for (String[] ss : tickets) {
			String[] f = new String[2];
			f[0] = ss[1];
			f[1] = "0";
			List<String[]> l = route.get(ss[0]);
			if (l != null) {
				int i = 0, length = l.size();
				while (i < length && f[0].compareTo(l.get(i)[0]) > 0)
					++i;
				l.add(i, f);
			} else {
				l = new LinkedList<String[]>();
				l.add(f);
				route.put(ss[0], l);
			}
		}
		order.add("JFK");
		dfs(route, order, "JFK", tickets.length + 1);
		return order;
	}

	private boolean dfs(Map<String, List<String[]>> route, List<String> order, String flight, int total) {
		if (order.size() == total)
			return true;
		List<String[]> next = route.get(flight);
		if (next == null || next.size() == 0)
			return false;
		for (String[] ss : next) {
			if (ss[1].equals("0")) {// not visited yet
				ss[1] = "1";
				order.add(ss[0]);
				if (dfs(route, order, ss[0], total))
					return true;
				order.remove(order.size() - 1);
				ss[1] = "0";
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String[][] tickets = { { "EZE", "TIA" }, { "EZE", "HBA" }, { "AXA", "TIA" }, { "JFK", "AXA" }, { "ANU", "JFK" },
				{ "ADL", "ANU" }, { "TIA", "AUA" }, { "ANU", "AUA" }, { "ADL", "EZE" }, { "ADL", "EZE" }, { "EZE", "ADL" },
				{ "AXA", "EZE" }, { "AUA", "AXA" }, { "JFK", "AXA" }, { "AXA", "AUA" }, { "AUA", "ADL" }, { "ANU", "EZE" },
				{ "TIA", "ADL" }, { "EZE", "ANU" }, { "AUA", "ANU" } };*/
		String[][] tickets = { { "EZE", "AXA" }, { "TIA", "ANU" }, { "ANU", "JFK" }, { "JFK", "ANU" }, { "ANU", "EZE" },
				{ "TIA", "ANU" }, { "AXA", "TIA" }, { "TIA", "JFK" }, { "ANU", "TIA" }, { "JFK", "TIA" } };
		ReconstructItinerary ri = new ReconstructItinerary();
		ri.findItinerary(tickets);
	}

}
