package com.TTT;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import players.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
		ClassLoader system = ClassLoader.getSystemClassLoader();
		ClassLoader ext = system.getParent();
		try {
			Class clazz = Class.forName("plugins.Plugin");
			Method m1 = clazz.getMethod("info");
			Object obj1 = clazz.newInstance();
			m1.invoke(obj1);

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		type = in.nextInt();
		Player player1 = PlayerFactory.getPlayer(type, 1);

		System.out.println("Choose type of 1st player:");
		System.out.println("enter 1 to choose Hyman");
		System.out.println("enter 2 to choose EasyBot");
		System.out.println("enter 3 to choose MediumBot");
		System.out.println("enter 4 to choose HardBot");
		try {
			Class clazz = Class.forName("plugins.Plugin");
			Method m1 = clazz.getMethod("info");
			Object obj1 = clazz.newInstance();
			m1.invoke(obj1);

		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		type = in.nextInt();
		Player player2 = PlayerFactory.getPlayer(type, 2);

		game.start(player1, player2);
	}
}
