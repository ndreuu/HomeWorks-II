package players;

import com.TTT.Square;

public interface IPlugin {
	public String printName();

	public void setSquare(Square square);

	public void setEnemyX(int enemyX);

	public void setEnemyY(int enemyY);

	public void setStepNumber(int stepNumber);

	public void setMark(int ind);

	public int stepX();
	public int stepY();


}
