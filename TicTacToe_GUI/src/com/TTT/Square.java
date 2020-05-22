package com.TTT;

import players.Player;
import java.util.Scanner;

public class Square {
	public final int SIZE = 3;
	public final char EMPTY = '_';
	public char[][] square = new char[SIZE][SIZE];
	public Player secondPlayer;
	private Scanner in = new Scanner(System.in);
	public char won;
	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	private void initSquare() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				square[i][j] = EMPTY;
			}
		}
	}

	public void printSquare() {
		if (!stop) {
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) {
					System.out.print(square[i][j]);
					System.out.print(" ");
				}
				System.out.println();
			}
		}
	}

	boolean checkFull() {
		int check = 0;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (square[i][j] != EMPTY) {
					check++;
				}
			}
		}
		if (check < SIZE * 3) {
			return false;
		}
		return true;
	}

	boolean checkWinO() {
		for (int i = 0; i < SIZE; i++) {
			int check = 0;
			for (int j = 0; j < SIZE; j++) {
				if (square[i][j] == 'O') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		for (int j = 0; j < SIZE; j++) {
			int check = 0;
			for (int i = 0; i < SIZE; i++) {
				if (square[i][j] == 'O') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		{
			int check = 0;
			for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) {
				if (square[i][j] == 'O') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		{
			int check = 0;
			for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) {
				if (square[i][j] == 'O') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		return false;
	}

	boolean checkWinX() {
		for (int i = 0; i < SIZE; i++) {
			int check = 0;
			for (int j = 0; j < SIZE; j++) {
				if (square[i][j] == 'X') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		for (int j = 0; j < SIZE; j++) {
			int check = 0;
			for (int i = 0; i < SIZE; i++) {
				if (square[i][j] == 'X') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		{
			int check = 0;
			for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) {
				if (square[i][j] == 'X') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		{
			int check = 0;
			for (int i = 0, j = SIZE - 1; i < SIZE && j >= 0; i++, j--) {
				if (square[i][j] == 'X') {
					check++;
				}
			}
			if (check == SIZE) {
				return true;
			}
		}
		return false;
	}

	public boolean stayAtThisStep;
	public boolean stop = false;
	public void step(int coordX, int coordY, char value) {
		if (coordX >= 0 && coordX < SIZE && coordY >= 0 && coordY < SIZE && square[coordX][coordY] == EMPTY) {
			square[coordX][coordY] = value;
		} else {
			stayAtThisStep = true;
			if (secondPlayer.type.equals("Human") && !secondPlayer.desktop) {
				printSquare();
				System.out.println("Incorrect value");
				System.out.println(secondPlayer.type);
			}
			return;
		}

		if (checkWinO()) {
			printSquare();
			System.out.println("~~~~~~~");
			System.out.println("O - WON");
			won = 'O';
			System.exit(0);
		}
		else if (checkWinX()) {
			printSquare();
			System.out.println("~~~~~~~");
			System.out.println("X - WON");
			won = 'X';
			System.exit(0);
		}
		else if (checkFull()) {
			printSquare();
			System.out.println("~~~~~~~");
			System.out.println("DRAW");
			won = '_';
			System.exit(0);
		}
		this.printSquare();
		System.out.println();
		stayAtThisStep = false;
	}

	public Square() {
		initSquare();
		this.stayAtThisStep = false;
	}
}
