package jp.co.solver.java.BowlingKata;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void testGutterGame() {
		BowlingGame g = new BowlingGame();
		for (int i = 0; i < 20; i ++) {
			g.roll(0);
		}
		assertThat(g.score(), is(0));
	}

	@Test
	public void testAllOnes() {
		BowlingGame g = new BowlingGame();
		for (int i = 0; i < 20; i++) {
			g.roll(1);
		}
		assertThat(g.score(), is(20));
	}
}
