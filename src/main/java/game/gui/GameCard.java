package game.gui;

import game.logic.GameLogic;
import game.logic.Room;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public abstract class GameCard extends JPanel {

    protected GameLogic gameLogic;

    public GameCard(GameLogic gameLogic) {
        setBorder(new EmptyBorder(10, 20, 10, 20));
        this.gameLogic = gameLogic;
        setLayout(new BorderLayout());
        StatsPanel statsPanel = new StatsPanel(gameLogic);
        add(statsPanel, BorderLayout.NORTH);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                statsPanel.update();
                notifyCardShown();
            }
        });
    }

    protected void notifyCardShown() {
        // optional method
    }

}
