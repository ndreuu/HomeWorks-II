package com.TTT;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import players.Player;

import java.util.Scanner;

public class Main {
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
		System.out.println("enter 5 to choose Plugin");
		type = in.nextInt();
		Player player1 = PlayerFactory.getPlayer(type, 1);

		System.out.println("Choose type of 1st player:");
		System.out.println("enter 1 to choose Hyman");
		System.out.println("enter 2 to choose EasyBot");
		System.out.println("enter 3 to choose MediumBot");
		System.out.println("enter 4 to choose HardBot");
		System.out.println("enter 5 to choose Plugin");
		type = in.nextInt();
		Player player2 = PlayerFactory.getPlayer(type, 2);

		game.start(player1, player2);
	}
}
