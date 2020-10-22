package jp.co.solver.java.BowlingKata;

public class BowlingGame {

	private int score = 0;

	public void roll(int pins) {
		score += pins;
	}

	public int score() {
		return score;
	}

}
