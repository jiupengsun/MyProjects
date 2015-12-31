package com.samy.ucr.project.Comparable.pageRank;

public class Page implements Comparable<Page> {

	private int id;
	private float rankValue;

	public Page(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setRankValue(float rv) {
		rankValue = rv;
	}

	public float getRankValue() {
		return rankValue;
	}

	@Override
	public int compareTo(Page o) {
		// TODO Auto-generated method stub
		float r = o.getRankValue();
		return rankValue < r ? -1 : (rankValue == r ? 0 : 1);
	}

}
