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
		for (int i = 0; i < 20; i++) {
			game.roll(0);
		}
		assertThat(game.score(), is(0));
	}

}
