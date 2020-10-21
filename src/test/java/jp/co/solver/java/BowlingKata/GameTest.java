package jp.co.solver.java.BowlingKata;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void 全てガター() {
		Game game = new Game();
		for (int i = 0; i < 20; i++) {
			// すべてのフレームで0
			game.roll(0);
		}
		assertThat(game.score(), is(0));
	}

}
