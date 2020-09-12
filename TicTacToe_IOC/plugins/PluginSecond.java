package plugins;

import players.IPlugin;
import players.Player;

public class PluginSecond extends Player implements IPlugin {

	protected final int PRIME = 9973;
	protected final int SIZE = square.SIZE;

	@Override
	public int stepX() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (square.square[i][j] == square.EMPTY) {
					y = j;
					return i;
				}
			}
		}
		return 0;
	}

	@Override
	public int stepY() {
		return y;
	}


	private int y;

	public static void info() {
		System.out.println("enter 5 to choose Plugin");
	}



	public PluginSecond() {
		super.type = "Bot";
	}

	@Override
	public String printName() {
		return "SecondPlugin";
	}
}
