package com.TTT;

import players.*;
import plugins.Plugin;

import java.util.ServiceLoader;

public class PlayerFactory {
	private final static int Human = 1;
	private final static int RandomBot = 2;
	private final static int GreedyBot = 3;
	private final static int HardBot = 4;
	private final static int Plugin = 5;

	private static ServiceLoader<Player> codecSetLoader = ServiceLoader.load(Player.class);

	public static Player getPlayer (int typeOfPlayer, int index, boolean isPlugin, String PluginName) {
		if (isPlugin) {
			for (IPlugin iPlugin : ServiceLoader.load(IPlugin.class)) {
				if (iPlugin.printName().equals(PluginName)) {
					Player player = (Player) iPlugin;
					player.setMark(index);
					return player;
				}
			}
		}
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
			try {
				//Player player = ServiceLoader.load(Player.class).findFirst().get();
				IPlugin player = ServiceLoader.load(IPlugin.class).findFirst().get();
				player.setMark(index);
				return (Player) player;
			} catch (Throwable t) {
				System.out.println("Firstly install your plugin");
			}
			//Player player = ServiceLoader.load(Player.class).findFirst().get();
			//player.setMark(index);
			///return player;
			//Player player = ServiceLoader.load(Player.class).findFirst().get();
			//player.setMark(index);
			//return player;
		}
		return null;
	}
}
