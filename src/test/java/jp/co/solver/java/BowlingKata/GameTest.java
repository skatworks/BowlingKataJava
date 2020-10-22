package jp.co.solver.java.BowlingKata;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void 全てガター() {
		Game game = new Game();
		for (int i = 0; i < 20; i++) {
			rollGutter(game);
		}
		assertThat(game.score(), is(0));
	}

	@Test
	public void 全て1ピンの場合() {
		Game game = new Game();
		for (int i = 0; i < 20; i++) {
			game.roll(1);
		}
		assertThat(game.score(), is(20));
	}

	@Test
	public void ストライクを含む場合() {
		Game game = new Game();
		// 1フレーム目でストライク
		game.roll(10);
		// 3、4フレーム目でスペアならず
		game.roll(3);
		game.roll(4);
		// 以降全てのフレームでガター
		for (int i = 0; i < 18; i++) {
			game.roll(0);
		}
		assertThat(game.score(), is(24));
	}

	@Test
	public void スペアを含む場合() {
		Game game = new Game();
		rollSpare(game);
		game.roll(4);
		game.roll(3);
		for (int i = 0; i < 16; i++) {
			rollGutter(game);
		}
		assertThat(game.score(), is(21));
	}

	@Test
	public void パーフェクトの場合() {
		Game game = new Game();
		for (int i = 0; i < 12; i++) {
			rollStrike(game);
		}
		assertThat(game.score(), is(300));
	}

	@Test
	public void 受入テスト() {
		Game game = new Game();
		int[] pins = new int[] {1,4,4,5,6,4,5,5,10,0,1,7,3,6,4,10,2,8,6};
		for (int pin : pins) {
			game.roll(pin);
		}
		assertThat(game.score(), is(133));
	}

	// すべてガターの場合のメソッド
	private void rollGutter(Game game) {
		game.roll(0);
	}

	// スペアのメソッド
	private void rollSpare(Game game) {
		game.roll(5);
		game.roll(5);
	}

	// すべてストライクの場合のメソッド
	private void rollStrike(Game game) {
		game.roll(10);
	}
}
