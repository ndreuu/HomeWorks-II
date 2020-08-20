package players;


public class BotRandom extends Player implements IPlugin {
	@Override
	public String printName() {
		return "Random";
	}

	protected final int PRIME = 9973;
	protected final int SIZE = square.SIZE;

	public int stepX() {
		int x = (int) (Math.random() * PRIME);
		return x % SIZE;
	}

	public int stepY() {
		int y = (int) (Math.random() * PRIME);
		return y % SIZE;
	}

	public BotRandom() {
		type = "Bot";
	}
}
