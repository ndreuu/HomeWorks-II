package com.TTT;

import players.*;

import java.util.ServiceLoader;

public class PlayerFactory {
	private final static int Human = 1;
	private final static int RandomBot = 2;
	private final static int GreedyBot = 3;
	private final static int HardBot = 4;
	private final static int Plugin = 5;

	public static Player getPlayer(int typeOfPlayer, int index) {
		if (typeOfPlayer == Human) {
			Player player = new Human();
			player.setMark(index);
			return player;
		} else if (typeOfPlayer == RandomBot) {
			Player player = new BotRandom();
			player.setMark(index);
			return player;
		} else if (typeOfPlayer == GreedyBot) {
			Player player = new GreedyBot();
			player.setMark(index);
			return player;
		} else if (typeOfPlayer == HardBot) {
			Player player = new HardBot();
			player.setMark(index);
			return player;
		} else if (typeOfPlayer == Plugin) {
			Player player = ServiceLoader.load(BotRandom.class).findFirst().get();
			player.setMark(index);
			return player;
		}
		return null;
	}
}
