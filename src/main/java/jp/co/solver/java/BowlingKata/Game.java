package jp.co.solver.java.BowlingKata;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Integer> rolls = new ArrayList<Integer>();

	public void roll(int pins) {
		rolls.add(pins);
	}

	public int score() {
		int score = 0;
		int rollIdx = 0;
		for (int i = 0; i < 10; i++) {
			if (rolls.get(rollIdx) == 10) {
				int next = ((rollIdx + 1) < rolls.size()) ? rolls.get(rollIdx + 1) : 0;
				int nextNext = ((rollIdx + 2) < rolls.size()) ? rolls.get(rollIdx + 2) : 0;
				score += 10 + next + nextNext;
				rollIdx += 1;
			} else if (rolls.get(rollIdx) + rolls.get(rollIdx + 1) == 10) {
				int next = ((rollIdx + 2) < rolls.size()) ? rolls.get(rollIdx + 2) : 0;
				score += 10 + next;
				rollIdx += 2;
			} else {
				score += rolls.get(rollIdx) + rolls.get(rollIdx + 1);
				rollIdx += + 2;
			}
		}
		return score;
	}

}
