package game;

import game.gui.GameWindow;
import game.logic.GameLogic;

import javax.swing.*;

public final class Main {

    public static void main(String[] args) {
        try {
            GameLogic gameLogic = new GameLogic("GameDB_ED");
            SwingUtilities.invokeLater(
                    () -> {
                        GameWindow gameWindow = new GameWindow(gameLogic);
                        gameWindow.setVisible(true);
                    }
            );
        }
        catch (Throwable t) {
            t.printStackTrace();
            System.exit(-1);
        }
    }

}
