package jp.co.solver.java.BowlingKataJava;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;

	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void すべてガターの場合() {
		rollMany(20, 0);
		assertThat(game.score(), is(0));
	}

	@Test
	public void すべて1ピンの場合() {
		rollMany(20, 1);
		assertThat(game.score(), is(20));
	}

	// 同じピン数を連続して倒すメソッド
	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			game.roll(pins);
		}
	}

}
