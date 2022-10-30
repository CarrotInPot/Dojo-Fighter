package game.gui;

import game.logic.GameLogic;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SuccessfulFleeCard extends GameCard {

    private final GameWindow gameWindow;

    public SuccessfulFleeCard(GameWindow gameWindow, GameLogic gameLogic) {
        super(gameLogic);
        this.gameWindow = gameWindow;

        JTextArea fleeDescriptionTextArea = new JTextArea("You successfully escaped!");
        fleeDescriptionTextArea.setEditable(false);
        add(new JScrollPane(fleeDescriptionTextArea), BorderLayout.CENTER);
        add(makeButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel makeButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 20, 20));
        JButton continueButton = GuiUtils.makeButton("Continue", Color.BLACK);
        panel.add(continueButton);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        continueButton.addActionListener(e -> {
            gameWindow.showGameCard();
        });

        return panel;
    }

}
