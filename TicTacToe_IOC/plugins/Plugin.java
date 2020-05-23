package plugins;

import players.BotRandom;

import java.util.ArrayList;
import java.util.Random;

public class Plugin extends BotRandom {
    private int y;

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

    public int stepY() {
        return y;
    }

    public Plugin() {
        super.type = "Bot";
    }
}
