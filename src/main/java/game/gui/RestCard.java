package game.gui;

import game.logic.GameLogic;
import game.logic.encounters.RestEncounter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RestCard extends GameCard {

    private final JTextArea restDescriptionTextArea;
    private final GameWindow gameWindow;

    public RestCard(GameWindow gameWindow, GameLogic gameLogic) {
        super(gameLogic);
        this.gameWindow = gameWindow;

        restDescriptionTextArea = new JTextArea();
        restDescriptionTextArea.setEditable(false);
        add(new JScrollPane(restDescriptionTextArea), BorderLayout.CENTER);
        add(makeButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel makeButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 20, 20));
        JButton continueButton = GuiUtils.makeButton("Continue", Color.BLACK);
        panel.add(continueButton);
        JButton saveButton = GuiUtils.makeButton("Save", Color.BLACK);
        panel.add(saveButton);
        JButton restartButton = GuiUtils.makeButton("Restart", Color.BLACK);
        panel.add(restartButton);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        restartButton.addActionListener(e -> {
            gameLogic.setPlayer(null);
            gameWindow.showWelcome(); // TODO - add confirmation, etc.
        });

        saveButton.addActionListener(e -> {
            gameWindow.showSavePrompt();
        });

        continueButton.addActionListener(e -> {
            gameLogic.currentEncounter = null; // continue to next room
            gameWindow.showGameCard();
        });

        return panel;
    }

    @Override
    protected void notifyCardShown() {
        RestEncounter currentEncounter = (RestEncounter) gameLogic.currentEncounter;
        restDescriptionTextArea.setText(currentEncounter.restMessage);
    }
}
