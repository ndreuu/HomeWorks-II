package players;

public class HardBot extends GreedyBot {

	public void checkCritical() {
		if (super.square.square[0][0] == EMPTY &&
				(
					(square.square[0][1] == enemyMark && square.square[0][2] == enemyMark) ||
					(square.square[1][1] == enemyMark && square.square[2][2] == enemyMark) ||
					(square.square[1][0] == enemyMark && square.square[2][0] == enemyMark)
				)
		) {
			this.coordX = 0;
			this.coordY = 0;
			return;
		}
		if (square.square[0][2] == EMPTY &&
				(
					(square.square[0][0] == enemyMark && square.square[0][1] == enemyMark) ||
					(square.square[1][1] == enemyMark && square.square[2][0] == enemyMark) ||
					(square.square[1][2] == enemyMark && square.square[2][2] == enemyMark)
				)
		) {
			this.coordX = 0;
			this.coordY = 2;
			return;
		}
		if (square.square[2][0] == EMPTY &&
				(
					(square.square[0][0] == enemyMark && square.square[1][0] == enemyMark) ||
					(square.square[1][1] == enemyMark && square.square[0][2] == enemyMark) ||
					(square.square[2][1] == enemyMark && square.square[2][2] == enemyMark)
				)
		) {
			this.coordX = 2;
			this.coordY = 0;
			return;
		}
		if (square.square[2][2] == EMPTY &&
				(
					(square.square[0][2] == enemyMark && square.square[1][2] == enemyMark) ||
					(square.square[0][0] == enemyMark && square.square[1][1] == enemyMark) ||
					(square.square[2][0] == enemyMark && square.square[2][1] == enemyMark)
				)
		) {
			this.coordX = 2;
			this.coordY = 2;
			return;
		}
		if (square.square[0][1] == EMPTY &&
				(
					(square.square[0][0] == enemyMark && square.square[0][2] == enemyMark) ||
					(square.square[1][1] == enemyMark && square.square[2][1] == enemyMark)
				)
		) {
			this.coordX = 0;
			this.coordY = 1;
			return;
		}
		if (square.square[2][1] == EMPTY &&
				(
					(square.square[2][0] == enemyMark && square.square[2][2] == enemyMark) ||
					(square.square[0][1] == enemyMark && square.square[1][1] == enemyMark)
				)
		) {
			this.coordX = 2;
			this.coordY = 1;
			return;
		}
		if (square.square[1][0] == EMPTY &&
				(
					(square.square[0][0] == enemyMark && square.square[2][0] == enemyMark) ||
					(square.square[1][1] == enemyMark && square.square[1][2] == enemyMark)
				)
		) {
			this.coordX = 1;
			this.coordY = 0;
			return;
		}
		if (square.square[1][2] == EMPTY &&
				(
					(square.square[0][2] == enemyMark && square.square[2][2] == enemyMark) ||
					(square.square[1][1] == enemyMark && square.square[1][0] == enemyMark)
				)
		) {
			this.coordX = 1;
			this.coordY = 2;
			return;
		}
		if (square.square[1][1] == EMPTY &&
				(
					(square.square[0][0] == enemyMark && square.square[2][2] == enemyMark) ||
					(square.square[0][1] == enemyMark && square.square[2][1] == enemyMark) ||
					(square.square[0][2] == enemyMark && square.square[2][0] == enemyMark) ||
					(square.square[1][0] == enemyMark && square.square[1][2] == enemyMark)
				)
		) {
			this.coordX = 1;
			this.coordY = 1;
			return;
		}
	}

	public int stepX() {
		hardStep();
		checkCritical();
		checkWinEnd();
		return this.coordX;
	}

	public int stepY() {
		return this.coordY;
	}

	public HardBot(char mark) {
		super(mark);
		this.enemyMark = takeEnemyMark();
	}
}
