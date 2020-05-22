package players;

import com.TTT.Square;

public abstract class Player {
	public boolean desktop;
	public int desktopX = -1;
	public int desktopY = -1;
	public char mark;
	public int enemyX;
	public int enemyY;
	public int stepNumber;
	public Square square;
	public String type = "";

	public void setSquare(Square square) {
		this.square = square;
	}

	public void setEnemyX(int enemyX) {
		this.enemyX = enemyX;
	}

	public void setEnemyY(int enemyY) {
		this.enemyY = enemyY;
	}

	public void setStepNumber(int stepNumber) {
		this.stepNumber = stepNumber;
	}

	public void setMark(int ind) {
		if (ind == 2) {
			mark = 'O';
		} else {
			mark = 'X';
		}
	}

	public abstract int stepX();
	public abstract int stepY();

	protected Player() {
		this.square = new Square();
		this.desktop = false;
	}
}
