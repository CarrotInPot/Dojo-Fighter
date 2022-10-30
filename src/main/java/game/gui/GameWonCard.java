package game.gui;

import game.logic.GameLogic;

import javax.swing.*;
import java.awt.*;

public class GameWonCard extends Card {

    public GameWonCard(GameWindow gameWindow, GameLogic gameLogic) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(GuiUtils.makeTitle("Thanks for playing!", 24));

        add(Box.createVerticalStrut(40));

        JPanel buttonBar = new JPanel();

        JButton exitButton = GuiUtils.makeButton("Exit", Color.BLACK);
        buttonBar.add(exitButton);

        JButton restartButton = GuiUtils.makeButton("Restart", Color.BLACK);
        buttonBar.add(restartButton);

        add(buttonBar);

        add(Box.createVerticalStrut(40));

        add(GuiUtils.makeTitle("Created by Samuel Meads, 20113456"));

        exitButton.addActionListener(e -> System.exit(0));
        restartButton.addActionListener(e -> {
            gameLogic.setPlayer(null);
            gameLogic.currentEncounter = null;
            gameWindow.showWelcome();
        });
    }

}
