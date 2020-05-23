package players;


import java.util.Scanner;

public class Human extends Player {
	Scanner in = new Scanner(System.in);

	public Human() {
		type = "Human";
	}

	public int stepX() {
		if (desktop) {
			return desktopX;
		}
		return in.nextInt();
	}

	public int stepY() {
		if (desktop) {
			return desktopY;
		}
		return in.nextInt();
	}

}
