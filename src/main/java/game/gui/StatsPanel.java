package game.gui;

import game.logic.GameLogic;
import game.logic.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatsPanel extends JPanel {
    private final JLabel nameLabel = new JLabel();
    private final JLabel hpLabel = new JLabel();
    private final JLabel xpLabel = new JLabel();

    private final GameLogic gameLogic;

    public StatsPanel(GameLogic gameLogic) {
        setLayout(new GridLayout(1, 3));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        this.gameLogic = gameLogic;
        add(nameLabel);
        add(hpLabel);
        add(xpLabel);
    }

    public void update() {
        Player player = gameLogic.getPlayer();
        nameLabel.setText("Name: " + player.name);
        hpLabel.setText("HP: " + player.hp + "/" + player.maxHP);
        xpLabel.setText("XP: " + player.xp);
    }

}
