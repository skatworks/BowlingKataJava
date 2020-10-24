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
	public void すべて1ピンだった場合() {
		rollMany(20, 1);
		assertThat(game.score(), is(20));
	}

	@Test
	public void スペアが1回の場合() {
		game.roll(5);
		game.roll(5);
		game.roll(3);
		assertThat(game.score(), is(16));
	}

	@Test
	public void ストライクが1回の場合() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		rollMany(17, 0);
		assertThat(game.score(), is(24));
	}

	@Test
	public void パーフェクトゲームの場合() {
		rollMany(12, 10);
		assertThat(game.score(), is(300));
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
			game.roll(pins);
		}
	}
}
