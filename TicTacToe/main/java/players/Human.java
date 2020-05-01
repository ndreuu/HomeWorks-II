package players;

import com.TTT.Square;

import java.util.Scanner;

public class Human extends Player {
	Scanner in = new Scanner(System.in);

	public Human(char mark) {
		super(mark);
		super.type = "Human";
	}

	public int stepX() {
		if (desktop) {
			return desktopX;
		}
		return in.nextInt();
	}

	public int stepY() {
		if (desktop) {
			return desktopY;
		}
		return in.nextInt();
	}

	public void setSquare(Square square) {
		super.square = square;
	}

	public void setEnemyX(int enemyX) {
		super.enemyX = enemyX;
	}

	public void setEnemyY(int enemyY) {
		super.enemyY = enemyY;
	}

	public void setStepNumber(int stepNumber) {
		super.stepNumber = stepNumber;
	}
}
