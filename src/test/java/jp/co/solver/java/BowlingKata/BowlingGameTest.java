package jp.co.solver.java.BowlingKata;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	private BowlingGame g;

	@Before
	public void setUp() throws Exception {
		g = new BowlingGame();
	}

	@Test
	public void testGutterGame() throws Exception {
		rollMany(20, 0);
		assertThat(g.score(), is(0));
	}

	@Test
	public void testAllOnes() throws Exception {
		rollMany(20, 1);
		assertThat(g.score(), is(20));
	}

	@Test
	public void testOneSpare() throws Exception {
		g.roll(5);
		g.roll(5);
		g.roll(3);
		rollMany(17,0);
		assertThat(g.score(), is(16));
	}

	// メソッド抽出
	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			g.roll(pins);
		}
	}
}
