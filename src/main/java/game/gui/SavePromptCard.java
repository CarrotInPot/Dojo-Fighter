package game.gui;

import game.logic.GameLogic;
import game.logic.Player;

import javax.swing.*;
import java.awt.*;

public class SavePromptCard extends Card {

    private final JLabel savePromptLabel;
    private GameLogic gameLogic;

    public SavePromptCard(GameWindow gameWindow, GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        savePromptLabel = GuiUtils.makeTitle("", 24);
        add(savePromptLabel);

        add(Box.createVerticalStrut(40));

        JPanel buttonBar = new JPanel();

        JButton yesButton = GuiUtils.makeButton("Yes", Color.BLACK);
        buttonBar.add(yesButton);

        JButton noButton = GuiUtils.makeButton("No", Color.BLACK);
        buttonBar.add(noButton);

        add(buttonBar);

        yesButton.addActionListener(e -> {
            gameLogic.getDBManager().savePlayer(gameLogic.getPlayer());
            gameWindow.showGameCard();
        });
        noButton.addActionListener(e -> {
            gameWindow.showGameCard();
        });
    }

    @Override
    public void notifyCardShown() {
        Player existingPlayer = gameLogic.getDBManager().loadPlayer(gameLogic.getPlayer().name);
        savePromptLabel.setText(existingPlayer == null ? "Save?" : "Overwrite Saved Game?");
    }
}
