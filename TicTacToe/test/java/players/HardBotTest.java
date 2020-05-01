package players;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HardBotTest {
	HardBot bot = new HardBot('X');

	@BeforeEach
	void setUp() {
		for (int i = 0; i < bot.square.SIZE; i++) {
			for (int j = 0; j < bot.square.SIZE; j++) {
				bot.square.square[i][j] = bot.square.EMPTY;
			}
		}
	}

	@Test
	void string1checkCritical() {
		bot.square.square[0][0] = bot.enemyMark;
		bot.square.square[0][1] = bot.enemyMark;
		bot.checkCritical();
		int[] check = {0, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}


	@Test
	void string2checkCritical() {
		bot.square.square[1][0] = bot.enemyMark;
		bot.square.square[1][1] = bot.enemyMark;
		bot.checkCritical();
		int[] check = {1, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void string3checkCritical() {
		bot.square.square[2][0] = bot.enemyMark;
		bot.square.square[2][1] = bot.enemyMark;
		bot.checkCritical();		int[] check = {2, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void column1checkCritical() {
		bot.square.square[0][0] = bot.enemyMark;
		bot.square.square[1][0] = bot.enemyMark;
		bot.checkCritical();
		int[] check = {2, 0};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void column2checkCritical() {
		bot.square.square[0][1] = bot.enemyMark;
		bot.square.square[1][1] = bot.enemyMark;
		bot.checkCritical();
		int[] check = {2, 1};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void column3checkCritical() {
		bot.square.square[0][2] = bot.enemyMark;
		bot.square.square[1][2] = bot.enemyMark;
		bot.checkCritical();
		int[] check = {2, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void diagonal1ccheckCritical() {
		bot.square.square[0][0] = bot.enemyMark;
		bot.square.square[1][1] = bot.enemyMark;
		bot.checkCritical();
		int[] check = {2, 2};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

	@Test
	void diagonal2checkCritical() {
		bot.square.square[0][2] = bot.enemyMark;
		bot.square.square[1][1] = bot.enemyMark;
		bot.checkCritical();
		int[] check = {2, 0};
		int[] now = {bot.coordX, bot.coordY};
		Assert.assertArrayEquals(check, now);
	}

}