package com.TTT;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

	@Test
	void checkFullTrue() {
		Square square = new Square();
		for (int i = 0; i < square.SIZE; i++) {
			for (int j = 0; j < square.SIZE; j++) {
				square.square[i][j] = 'X';
			}
		}
		Assert.assertEquals(true, square.checkFull());
	}

	@Test
	void checkFullFalse() {
		Square square = new Square();
		for (int i = 0; i < square.SIZE; i++) {
			for (int j = 0; j < square.SIZE; j++) {
				square.square[i][j] = '_';
			}
		}
		Assert.assertEquals(false, square.checkFull());
	}

	@Test
	void string1CheckWinO() {
		Square square = new Square();
		square.square[0][0] = 'O';
		square.square[0][1] = 'O';
		square.square[0][2] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void string2CheckWinO() {
		Square square = new Square();
		square.square[1][0] = 'O';
		square.square[1][1] = 'O';
		square.square[1][2] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void string3CheckWinO() {
		Square square = new Square();
		square.square[2][0] = 'O';
		square.square[2][1] = 'O';
		square.square[2][2] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void column1CheckWinO() {
		Square square = new Square();
		square.square[0][0] = 'O';
		square.square[1][0] = 'O';
		square.square[2][0] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void column2CheckWinO() {
		Square square = new Square();
		square.square[0][1] = 'O';
		square.square[1][1] = 'O';
		square.square[2][1] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void column3CheckWinO() {
		Square square = new Square();
		square.square[0][2] = 'O';
		square.square[1][2] = 'O';
		square.square[2][2] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void diagonal1CheckWinO() {
		Square square = new Square();
		square.square[0][0] = 'O';
		square.square[1][1] = 'O';
		square.square[2][2] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void diagonal2CheckWinO() {
		Square square = new Square();
		square.square[0][2] = 'O';
		square.square[1][1] = 'O';
		square.square[2][0] = 'O';
		Assert.assertEquals(true, square.checkWinO());
	}

	@Test
	void string1CheckWinX() {
		Square square = new Square();
		square.square[0][0] = 'X';
		square.square[0][1] = 'X';
		square.square[0][2] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}

	@Test
	void string2CheckWinX() {
		Square square = new Square();
		square.square[1][0] = 'X';
		square.square[1][1] = 'X';
		square.square[1][2] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}

	@Test
	void string3CheckWinX() {
		Square square = new Square();
		square.square[2][0] = 'X';
		square.square[2][1] = 'X';
		square.square[2][2] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}

	@Test
	void column1CheckWinX() {
		Square square = new Square();
		square.square[0][0] = 'X';
		square.square[1][0] = 'X';
		square.square[2][0] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}

	@Test
	void column2CheckWinX() {
		Square square = new Square();
		square.square[0][1] = 'X';
		square.square[1][1] = 'X';
		square.square[2][1] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}

	@Test
	void column3CheckWinX() {
		Square square = new Square();
		square.square[0][2] = 'X';
		square.square[1][2] = 'X';
		square.square[2][2] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}

	@Test
	void diagonal1CheckWinX() {
		Square square = new Square();
		square.square[0][0] = 'X';
		square.square[1][1] = 'X';
		square.square[2][2] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}

	@Test
	void diagonal2CheckWinX() {
		Square square = new Square();
		square.square[0][2] = 'X';
		square.square[1][1] = 'X';
		square.square[2][0] = 'X';
		Assert.assertEquals(true, square.checkWinX());
	}
}