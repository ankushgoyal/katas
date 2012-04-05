package test;

import static org.junit.Assert.*;

import main.Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	Game game;
	
	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private void rollMany(int rolls, int pins) {
		for(int i = 0; i < rolls; i++) {
			game.roll(pins);
		}
	}
	
	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
	
	private void rollStrike() {
		game.roll(10);
	}

	@Test
	public void test_gutterGame() throws Exception {
		rollMany(20, 0);
		assertEquals(0,game.score());
	}
	
	@Test
	public void test_allOnes() throws Exception {
		rollMany(20, 1);
		assertEquals(20,game.score());
	}
	
	@Test
	public void test_oneSpare() throws Exception {
		rollSpare();
		game.roll(3);
		rollMany(17, 0);
		assertEquals(16, game.score());
	}
	
	@Test
	public void test_oneStrike() throws Exception {
		rollStrike();
		game.roll(3);
		game.roll(4);
		rollMany(16, 0);
		assertEquals(24, game.score());
	}
	
	@Test
	public void test_perfectGame() throws Exception {
		rollMany(12, 10);
		assertEquals(300, game.score());
	}
}
