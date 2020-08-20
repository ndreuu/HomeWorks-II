package players;

public class HardBot extends GreedyBot implements IPlugin {
	@Override
	public String printName() {
		return "Hard";
	}

	private void checkCritical() {
		enemyMark = takeEnemyMark();
		int[] sCheck = {0, 0, 0};
		int[] cCheck = {0, 0, 0};
		int[] dCheck = {0, 0};
		for (int i = 0; i < square.SIZE; i++) {
			for (int j = 0; j < square.SIZE; j++) {
				if (square.square[i][j] == enemyMark) {
					sCheck[i]++;
					cCheck[j]++;
					if (i == j) {
						dCheck[0]++;
					}
					if (i == 1 && j == 1 || i == 0 && j == 2 || i == 2 && j == 0) {
						dCheck[1]++;
					}
				}
			}
		}
		for (int i = 0; i < square.SIZE; i++) {
			for (int j = 0; j < square.SIZE; j++) {
				if (square.square[i][j] == EMPTY && (sCheck[i] == 2 || cCheck[j] == 2)) {
					this.coordX = i;
					this.coordY = j;
					return;
				}
				if (square.square[i][j] == EMPTY && i == j && dCheck[0] == 2) {
					this.coordX = i;
					this.coordY = j;
					return;
				}
				if (square.square[i][j] == EMPTY && (i == 1 && j == 1 || i == 0 && j == 2 || i == 2 && j == 0) && dCheck[1] == 2) {
					this.coordX = i;
					this.coordY = j;
					return;
				}
			}
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

	public HardBot() {
		type = "Bot";
	}
}
