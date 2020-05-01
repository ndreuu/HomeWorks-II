package players;

import com.TTT.Square;

public class BotRandom extends Player {
	private final int PRIME = 9973;
	private final int SIZE = square.SIZE;

	public int stepX() {
		int x = (int) (Math.random() * PRIME);
		return x % SIZE;
	}

	public void setEnemyX(int enemyX) {
		super.enemyX = enemyX;
	}

	public void setEnemyY(int enemyY) {
		super.enemyY = enemyY;
	}

	public int stepY() {
		int y = (int) (Math.random() * PRIME);
		return y % SIZE;
	}

	public BotRandom(char mark) {
		super(mark);
		super.type = "Bot";
	}

	public void setStepNumber(int stepNumber) {
		super.stepNumber = stepNumber;
	}

	public void setSquare(Square square) {
		super.square = square;
	}
}
