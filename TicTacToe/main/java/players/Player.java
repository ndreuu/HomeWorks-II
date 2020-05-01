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


	public abstract void setSquare(Square square);
	public abstract void setEnemyX(int enemyX);
	public abstract void setEnemyY(int enemyY);
	public abstract void setStepNumber(int stepNumber);
	public abstract int stepX();
	public abstract int stepY();

	Player(char mark) {
		this.mark = mark;
		this.square = new Square();
		this.desktop = false;
	}
}
