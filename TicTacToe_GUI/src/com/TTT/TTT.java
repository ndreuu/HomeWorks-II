package com.TTT;

import players.*;
import java.util.Scanner;

public class TTT {
	public Player player1;
	public Player player2;
	public Square square = new Square();
	private Scanner in = new Scanner(System.in);
	private Player[] players = new Player[5];
	public int out;

	public void menu() {
		while (true) {
			int pick;
			do {
				System.out.println("Choose side first player");
				System.out.println("click 0 to choose: 'O'");
				System.out.println("click 1 to choose: 'X'");
				pick = in.nextInt();
				if (pick != 0 || pick != 1) {
					System.out.println("incorrect input, try again");
				}
			} while (pick != 0 && pick != 1);
			char mark;
			if (pick == 0) {
				mark = 'O';
			} else {
				mark = 'X';
			}
			System.out.println("Choose first player");
			System.out.println("click 0 to choose: 'Human'");
			System.out.println("click 1 to choose: 'Easy Bot'");
			System.out.println("click 2 to choose: 'Medium Bot'");
			System.out.println("click 3 to choose: 'Hard Bot'");             //add new
			pick = in.nextInt();
			if (pick == 0) {
				this.players[0] = new Human(mark);
				break;
			} else if (pick == 1) {
				this.players[0] = new BotRandom(mark);
				break;
			} else if (pick == 2) {
				this.players[0] = new GreedyBot(mark);
				break;
			} else if (pick == 3) {
				this.players[0] = new HardBot(mark);
				break;
			} else {
				System.out.println("incorrect input, try again");
			}
		}
			char enemyMark;
			if (players[0].mark == 'O') {
				enemyMark = 'X';
			} else {
				enemyMark = 'O';
			}
			int enemyNumb;
			while (true) {
				System.out.println("Choose second player");
				System.out.println("click 0 to choose: 'Human'");
				System.out.println("click 1 to choose: 'Easy Bot'");
				System.out.println("click 2 to choose: 'Medium Bot'");
				System.out.println("click 3 to choose: 'Hard Bot'");
				//enemyNumb = in.nextInt();
				int pick = in.nextInt();
				if (pick == 0) {
					enemyNumb = 1;
					this.players[1] = new Human(enemyMark);
					break;
				} else if (pick == 1) {
					enemyNumb = 2;
					this.players[2] = new BotRandom(enemyMark);
					break;
				} else if (pick == 2) {
					enemyNumb = 3;
					this.players[3] = new GreedyBot(enemyMark);
					break;
				} else if (pick == 3) {
					enemyNumb = 4;
					this.players[4] = new HardBot(enemyMark);
					break;
				} else {
					System.out.println("incorrect input, try again");
				}
			}
			if (players[0].mark == 'X') {
				this.player1 = players[0];
				this.player2 = players[enemyNumb];
				//	square.setSecondPlayer(player2);
			} else {
				this.player1 = players[enemyNumb];
				this.player2 = players[0];
				//	square.setSecondPlayer(player1);
			}
	}
	public void start() {
		menu();
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
