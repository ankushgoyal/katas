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
	
	

}
