package com.TTT;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import players.IPlugin;
import players.Player;

import javax.lang.model.type.IntersectionType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.ServiceLoader;


public class Main {
	private static int countOfSystemBots = 5;
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int type;
		MutablePicoContainer container = new DefaultPicoContainer();
		container.addComponent(TTT.class);
		TTT game = container.getComponent(TTT.class);

		System.out.println("Choose type of 1st player:");
		System.out.println("enter 1 to choose Hyman");
		System.out.println("enter 2 to choose EasyBot");
		System.out.println("enter 3 to choose MediumBot");
		System.out.println("enter 4 to choose HardBot");
		int it = countOfSystemBots;
		ArrayList<String> pair = new ArrayList<String>();
		boolean isPlugin = false;
		String pluginName = null;
		for (IPlugin iPlugin : ServiceLoader.load(IPlugin.class)) {
			System.out.print("enter " + it + " to choose " );
			System.out.println(iPlugin.printName());
			it++;
			pair.add(iPlugin.printName());
		}


		type = in.nextInt();
		if (type > countOfSystemBots) {
			isPlugin = true;
			pluginName = pair.get(type - countOfSystemBots - 1);
		}

		Player player1 = PlayerFactory.getPlayer(type, 1, isPlugin, pluginName);

		System.out.println("Choose type of 1st player:");
		System.out.println("enter 1 to choose Hyman");
		System.out.println("enter 2 to choose EasyBot");
		System.out.println("enter 3 to choose MediumBot");
		System.out.println("enter 4 to choose HardBot");
		it = countOfSystemBots;
		pair = new ArrayList<>();
		isPlugin = false;
		pluginName = null;
		for (IPlugin iPlugin : ServiceLoader.load(IPlugin.class)) {
			System.out.print("enter " + it + " to choose " );
			System.out.println(iPlugin.printName());
			it++;
			pair.add(iPlugin.printName());
		}
		type = in.nextInt();
		if (type > countOfSystemBots) {
			isPlugin = true;
			pluginName = pair.get(type - countOfSystemBots - 1);
		}

		Player player2 = PlayerFactory.getPlayer(type, 2, isPlugin, pluginName);

		game.start(player1, player2);
	}
}
