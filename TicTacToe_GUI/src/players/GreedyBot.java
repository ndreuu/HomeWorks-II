package players;

import com.TTT.Square;

public class GreedyBot extends Player {
	public final char EMPTY = square.EMPTY;
	private final int SIZE = square.SIZE;
	private final int PRIME = 9973;
	public char enemyMark;
	public int coordX;
	public int coordY;
	private int preEnemyX;
	private int preEnemyY;
	private boolean scene1 = false;

	public void setStepNumber(int stepNumber) {
		super.stepNumber = stepNumber;
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

	public char takeEnemyMark() {
		if (super.mark == 'X') {
			return 'O';
		}
		return 'X';
	}

	public void checkWinEnd() {
		if (square.square[0][0] == EMPTY &&
				(
								(square.square[0][1] == super.mark && square.square[0][2] == super.mark) ||
								(square.square[1][1] == super.mark && square.square[2][2] == super.mark) ||
								(square.square[1][0] == super.mark && square.square[2][0] == super.mark)
				)
		) {
			this.coordX = 0;
			this.coordY = 0;
			return;
		}
		if (square.square[0][2] == EMPTY &&
				(
								(square.square[0][0] == super.mark && square.square[0][1] == super.mark) ||
								(square.square[1][1] == super.mark && square.square[2][0] == super.mark) ||
								(square.square[1][2] == super.mark && square.square[2][2] == super.mark)
				)
		) {
			this.coordX = 0;
			this.coordY = 2;
			return;
		}
		if (square.square[2][0] == EMPTY &&
				(
								(square.square[0][0] == super.mark && square.square[1][0] == super.mark) ||
								(square.square[1][1] == super.mark && square.square[0][2] == super.mark) ||
								(square.square[2][1] == super.mark && square.square[2][2] == super.mark)
				)
		) {
			this.coordX = 2;
			this.coordY = 0;
			return;
		}
		if (square.square[2][2] == EMPTY &&
				(
								(square.square[0][2] == super.mark && square.square[1][2] == super.mark) ||
								(square.square[0][0] == super.mark && square.square[1][1] == super.mark) ||
								(square.square[2][0] == super.mark && square.square[2][1] == super.mark)
				)
		) {
			this.coordX = 2;
			this.coordY = 2;
			return;
		}
		if (square.square[0][1] == EMPTY &&
				(
								(square.square[0][0] == super.mark && square.square[0][2] == super.mark) ||
								(square.square[1][1] == super.mark && square.square[2][1] == super.mark)
				)
		) {
			this.coordX = 0;
			this.coordY = 1;
			return;
		}
		if (square.square[2][1] == EMPTY &&
				(
								(square.square[2][0] == super.mark && square.square[2][2] == super.mark) ||
								(square.square[0][1] == super.mark && square.square[1][1] == super.mark)
				)
		) {
			this.coordX = 2;
			this.coordY = 1;
			return;
		}
		if (square.square[1][0] == EMPTY &&
				(
								(square.square[0][0] == super.mark && square.square[2][0] == super.mark) ||
								(square.square[1][1] == super.mark && square.square[1][2] == super.mark)
				)
		) {
			this.coordX = 1;
			this.coordY = 0;
			return;
		}
		if (square.square[1][2] == EMPTY &&
				(
								(square.square[0][2] == super.mark && square.square[2][2] == super.mark) ||
								(square.square[1][1] == super.mark && square.square[1][0] == super.mark)
				)
		) {
			this.coordX = 1;
			this.coordY = 2;
			return;
		}
		if (square.square[1][1] == EMPTY &&
				(
								(square.square[0][0] == super.mark && square.square[2][2] == super.mark) ||
								(square.square[0][1] == super.mark && square.square[2][1] == super.mark) ||
								(square.square[0][2] == super.mark && square.square[2][0] == super.mark) ||
								(square.square[1][0] == super.mark && square.square[1][2] == super.mark)
				)
		) {
			this.coordX = 1;
			this.coordY = 1;
			return;
		}
	}

	private boolean SquareIsEmpty() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (square.square[i][j] != EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	private void distantionStep() {
		int maxDistantion = -1;
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				if (square.square[x][y] == EMPTY && maxDistantion < ((enemyX - x) * (enemyX - x) + (enemyY - y) * (enemyY - y))) {
					maxDistantion = ((enemyX - x) * (enemyX - x) + (enemyY - y) * (enemyY - y));
					this.coordX = x;
					this.coordY = y;
				}
			}
		}
	}

	private void defendStepO() {
		if (square.square[0][0] == EMPTY || square.square[0][2] == EMPTY || square.square[2][0] == EMPTY || square.square[2][2] == EMPTY) {
			int[][] randAngle = {
					{0, 0, 2, 2},
					{0, 2, 0, 2}};
			int j = (int) (Math.random() * PRIME) % 4;
			this.coordX = randAngle[0][j];
			this.coordY = randAngle[1][j];
		} else {
			int[][] randAngle = {
					{0, 1, 1, 2},
					{1, 0, 2, 1}};
			int j = (int) (Math.random() * PRIME) % 4;
			this.coordX = randAngle[0][j];
			this.coordY = randAngle[1][j];
		}
	}

	private boolean firstXinMid() {
		if (square.square[1][1] == 'X' &&
				(
								(square.square[0][0] == EMPTY && square.square[2][2] == EMPTY) &&
								(square.square[0][1] == EMPTY && square.square[2][1] == EMPTY) &&
								(square.square[0][2] == EMPTY && square.square[2][0] == EMPTY) &&
								(square.square[1][0] == EMPTY && square.square[1][2] == EMPTY)
				)
		) {
			return true;
		}
		return false;
	}

	private void angleStep() {
		if (enemyX == 0 && enemyY == 0) {
			coordX = 2;
			coordY = 0;
		}
		if (enemyX == 0 && enemyY == 2) {
			coordX = 2;
			coordY = 2;
		}
		if (enemyX == 2 && enemyY == 0) {
			coordX = 0;
			coordY = 0;
		}
		if (enemyX == 2 && enemyY == 2) {
			coordX = 0;
			coordY = 2;
		}
	}

	public void hardStep() {
		if (mark == 'X') {

			if (stepNumber == 1) {
				this.coordX = 1;
				this.coordY = 1;
				return;
			}
			distantionStep();
		}
		if (mark == 'O') {
			if (stepNumber == 1) {
				if (firstXinMid()) {
					scene1 = true;
				}
			}
			if (scene1) {
				defendStepO();
			} else {
				if (stepNumber == 1) {
					this.coordX = 1;
					this.coordY = 1;
					preEnemyX = enemyX;
					preEnemyY = enemyY;
				} else {
					if (enemyX == 0 && enemyY == 0 || enemyX == 0 && enemyY == 2 || enemyX == 2 && enemyY == 0 || enemyX == 2 && enemyY == 2) {
						angleStep();
					} else if ( enemyX == 0 && enemyY == 1 && preEnemyX == 2 && preEnemyY == 1 ||
							enemyX == 1 && enemyY == 2 && preEnemyX == 1 && preEnemyY == 0 ||
							enemyX == 2 && enemyY == 1 && preEnemyX == 0 && preEnemyY == 1 ||
							enemyX == 1 && enemyY == 0 && preEnemyX == 1 && preEnemyY == 2
					) {
						defendStepO();
					} else {
						if (enemyX == 0 && enemyY == 1 && preEnemyX == 1 && preEnemyY == 0 || preEnemyX == 0 && preEnemyY == 1 && enemyX == 1 && enemyY == 0) {
							this.coordX = 0;
							this.coordY = 0;
						}
						if (enemyX == 0 && enemyY == 1 && preEnemyX == 1 && preEnemyY == 2 || preEnemyX == 0 && preEnemyY == 1 && enemyX == 1 && enemyY == 2) {
							this.coordX = 0;
							this.coordY = 2;
						}
						if (enemyX == 1 && enemyY == 2 && preEnemyX == 2 && preEnemyY == 1 || preEnemyX == 1 && preEnemyY == 2 && enemyX == 2 && enemyY == 1) {
							this.coordX = 2;
							this.coordY = 2;
						}
						if (enemyX == 2 && enemyY == 1 && preEnemyX == 1 && preEnemyY == 0 || preEnemyX == 2 && preEnemyY == 1 && enemyX == 1 && enemyY == 0) {
							this.coordX = 2;
							this.coordY = 0;
						}
						distantionStep();
					}
				}
			}
		}
	}



	public int stepX() {
		hardStep();
		checkWinEnd();
		return this.coordX;
	}

	public int stepY() {
		return this.coordY;
	}

	public GreedyBot(char mark) {
		super(mark);
		this.enemyMark = takeEnemyMark();
	}
}
