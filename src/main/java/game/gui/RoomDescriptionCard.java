package game.gui;

import game.logic.GameLogic;
import game.logic.Room;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoomDescriptionCard extends GameCard {

    private final JTextArea roomDescriptionTextArea;
    private final GameWindow gameWindow;

    public RoomDescriptionCard(GameWindow gameWindow, GameLogic gameLogic) {
        super(gameLogic);
        this.gameWindow = gameWindow;

        roomDescriptionTextArea = new JTextArea();
        roomDescriptionTextArea.setEditable(false);
        add(new JScrollPane(roomDescriptionTextArea), BorderLayout.CENTER);
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
            gameLogic.continueAdventure();
            gameWindow.showGameCard();
        });

        return panel;
    }

    @Override
    protected void notifyCardShown() {
        int roomCount = gameLogic.getPlayer().roomCount;
        Room room = gameLogic.getMap().getRoom(roomCount);
        roomDescriptionTextArea.setText(room.getDesc());
    }
}
