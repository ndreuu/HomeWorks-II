package players;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreedyBotTest {
	GreedyBot bot = new GreedyBot('X');

	@BeforeEach
	void setUp() {
		for (int i = 0; i < bot.square.SIZE; i++) {
			for (int j = 0; j < bot.square.SIZE; j++) {
				bot.square.square[i][j] = bot.square.EMPTY;
			}
		}
	}

	@Test
	void string1checkWinEnd() {
		bot.square.square[0][0] = bot.mark;
		bot.square.square[0][1] = bot.mark;
		bot.checkWinEnd();
		int[] check = {0, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void string2checkWinEnd() {
		bot.square.square[1][0] = bot.mark;
		bot.square.square[1][1] = bot.mark;
		bot.checkWinEnd();
		int[] check = {1, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void string3checkWinEnd() {
		bot.square.square[2][0] = bot.mark;
		bot.square.square[2][1] = bot.mark;
		bot.checkWinEnd();
		int[] check = {2, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void column1checkWinEnd() {
		bot.square.square[0][0] = bot.mark;
		bot.square.square[1][0] = bot.mark;
		bot.checkWinEnd();
		int[] check = {2, 0};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void column2checkWinEnd() {
		bot.square.square[0][1] = bot.mark;
		bot.square.square[1][1] = bot.mark;
		bot.checkWinEnd();
		int[] check = {2, 1};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void column3checkWinEnd() {
		bot.square.square[0][2] = bot.mark;
		bot.square.square[1][2] = bot.mark;
		bot.checkWinEnd();
		int[] check = {2, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void diagonal1checkWinEnd() {
		bot.square.square[0][0] = bot.mark;
		bot.square.square[1][1] = bot.mark;
		bot.checkWinEnd();
		int[] check = {2, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void diagonal2checkWinEnd() {
		bot.square.square[0][2] = bot.mark;
		bot.square.square[1][1] = bot.mark;
		bot.checkWinEnd();
		int[] check = {2, 0};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}
}