package game.gui;

import game.logic.GameLogic;
import game.logic.Player;

import javax.swing.*;
import java.awt.*;

public class CharacterExistsConfirmationCard extends Card {

    private final JLabel characterExistsLabel2;
    private final GameLogic gameLogic;

    public CharacterExistsConfirmationCard(GameWindow gameWindow, GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(GuiUtils.makeTitle("Save game already exists for character", 18));

        add(Box.createVerticalStrut(5));

        characterExistsLabel2 = GuiUtils.makeTitle("", 24);
        add(characterExistsLabel2);

        add(Box.createVerticalStrut(20));

        JButton newGameButton = GuiUtils.makeButton("Start New Game", Color.BLACK);
        add(newGameButton);

        add(Box.createVerticalStrut(10));

        JButton loadSavedGameButton = GuiUtils.makeButton("Load Saved Game", Color.BLACK);
        add(loadSavedGameButton);

        add(Box.createVerticalStrut(10));

        JButton cancelButton = GuiUtils.makeButton("Cancel", Color.BLACK);
        add(cancelButton);

        newGameButton.addActionListener(e -> {
            // create a new player with the same name
            gameLogic.setPlayer(new Player(gameLogic.getPlayer().name));
            gameWindow.showGameCard();
        });

        loadSavedGameButton.addActionListener(e -> {
            gameWindow.showGameCard();
        });

        cancelButton.addActionListener(e -> {
            gameLogic.setPlayer(null);
            gameWindow.showWelcome();
        });
    }

    @Override
    public void notifyCardShown() {
        characterExistsLabel2.setText(gameLogic.getPlayer().name);
    }
}
