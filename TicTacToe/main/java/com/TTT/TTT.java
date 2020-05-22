package com.TTT;

import players.*;
import java.util.Scanner;

public class TTT {
	public Player player1;
	public Player player2;
	public Square square = new Square();
	private Scanner in = new Scanner(System.in);
	private Player[] players = new Player[6];
	public int out;

	public void start(Player player1, Player player2) {
		square.printSquare();
		System.out.println();
		int number = 1;
		while (true) {
			player1.setStepNumber(number);
			player2.setStepNumber(number);
			int x;
			int y;
			do {
				x = player1.stepX();
				y = player1.stepY();
				player2.setEnemyX(x);
				player2.setEnemyY(y);
				square.setSecondPlayer(player1);
				square.step(x, y, player1.mark);
				player1.setSquare(square);
				player2.setSquare(square);
			} while (square.stayAtThisStep);
			do {
				x = player2.stepX();
				y = player2.stepY();
				player1.setEnemyX(x);
				player1.setEnemyY(y);
				square.setSecondPlayer(player2);
				square.step(x, y, player2.mark);
				player1.setSquare(square);
				player2.setSquare(square);
			} while (square.stayAtThisStep);
			number++;
		}
	}

	public void stepX(int number) {
		if (player1.desktop) {
			player1.desktopX = -1;
			player1.desktopY = -1;
		}
		if (square.won == 'X' || square.won == 'O' || square.won == '_') {
			return;
		}
		player1.setStepNumber(number);
		player2.setStepNumber(number);
		int x;
		int y;
		do {
			x = player1.stepX();
			y = player1.stepY();
			player2.setEnemyX(x);
			player2.setEnemyY(y);
			square.setSecondPlayer(player1);
			square.step(x, y, player1.mark);
			player1.setSquare(square);
			player2.setSquare(square);
		} while (square.stayAtThisStep);
		if (x == 0 && y == 0) {
			out = 0;
		}
		if (x == 0 && y == 1) {
			out = 1;
		}
		if (x == 0 && y == 2) {
			out = 2;
		}
		if (x == 1 && y == 0) {
			out = 3;
		}
		if (x == 1 && y == 1) {
			out = 4;
		}
		if (x == 1 && y == 2) {
			out = 5;
		}
		if (x == 2 && y == 0) {
			out = 6;
		}
		if (x == 2 && y == 1) {
			out = 7;
		}
		if (x == 2 && y == 2) {
			out = 8;
		}
	}
	public void stepO(int number) {
		if (player2.desktop) {
			player2.desktopX = -1;
			player2.desktopY = -1;
		}
		if (square.won == 'X' || square.won == 'O' || square.won == '_') {
			return;
		}
		player1.setStepNumber(number);
		player2.setStepNumber(number);
		int x;
		int y;
		do {
			x = player2.stepX();
			y = player2.stepY();
			player1.setEnemyX(x);
			player1.setEnemyY(y);
			square.setSecondPlayer(player2);
			square.step(x, y, player2.mark);
			player1.setSquare(square);
			player2.setSquare(square);
		} while (square.stayAtThisStep);
		if (x == 0 && y == 0) {
			out = 0;
		}
		if (x == 0 && y == 1) {
			out = 1;
		}
		if (x == 0 && y == 2) {
			out = 2;
		}
		if (x == 1 && y == 0) {
			out = 3;
		}
		if (x == 1 && y == 1) {
			out = 4;
		}
		if (x == 1 && y == 2) {
			out = 5;
		}
		if (x == 2 && y == 0) {
			out = 6;
		}
		if (x == 2 && y == 1) {
			out = 7;
		}
		if (x == 2 && y == 2) {
			out = 8;
		}
	}
}
