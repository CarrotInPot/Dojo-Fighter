package game.gui;

import game.logic.GameLogic;
import game.logic.Player;

import javax.swing.*;
import java.awt.*;

public class WelcomeCard extends Card {

    private final JTextField characterNameTextField;

    public WelcomeCard(GameWindow gameWindow, GameLogic gameLogic) {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(GuiUtils.makeTitle(GameWindow.TITLE, 24));

        add(Box.createVerticalStrut(50));

        JLabel newGameButton = GuiUtils.makeLabel("Enter Character Name");
        add(newGameButton);

        add(Box.createVerticalStrut(5));

        characterNameTextField = GuiUtils.makeTextField(20);
        add(characterNameTextField);

        add(Box.createVerticalStrut(10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        JButton continueButton = GuiUtils.makeButton("Continue", Color.BLACK);
        buttonPanel.add(continueButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        JButton exitButton = GuiUtils.makeButton("Exit", Color.BLACK);
        buttonPanel.add(exitButton);

        add(buttonPanel);

        add(Box.createVerticalStrut(50));

        add(GuiUtils.makeTitle("Created by Samuel Meads, 20113456"));

        exitButton.addActionListener(e -> System.exit(0));

        continueButton.addActionListener(e -> {
            String characterName = characterNameTextField.getText().trim();
            Player player = gameLogic.getDBManager().loadPlayer(characterName);
            if (player != null) {
                gameLogic.setPlayer(player);
                gameWindow.showCharacterExistsConfirmation();
            }
            else {
                player = new Player(characterName);
                gameLogic.setPlayer(player);
                gameWindow.showGameCard();
            }
        });
    }

    @Override
    public void notifyCardShown() {
        characterNameTextField.setText("");
        characterNameTextField.requestFocus();
    }

}
