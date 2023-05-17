package game.gui;

import game.logic.Enemy;
import game.logic.GameLogic;
import game.logic.encounters.BattleEncounter;
import game.logic.encounters.Encounter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BattleCard extends GameCard {

    private final GameWindow gameWindow;

    private final JTextArea battleDescriptionTextArea;
    private final JLabel enemyLabel = new JLabel();

    private static final String BATTLE_BOSS = "BOSS";
    private static final String BATTLE_NORMAL = "NORMAL";
    private static final String BATTLE_WON = "WON";
    private static final String BATTLE_LOST = "LOST";
    private final CardLayout battleButtonCardLayout = new CardLayout();
    private final JPanel battleButtonCardLayoutPanel = new JPanel(battleButtonCardLayout);

    public BattleCard(GameWindow gameWindow, GameLogic gameLogic) {
        super(gameLogic);
        this.gameWindow = gameWindow;

        battleDescriptionTextArea = new JTextArea();
        battleDescriptionTextArea.setEditable(false);
        add(new JScrollPane(battleDescriptionTextArea), BorderLayout.CENTER);
        add(makeSouthPanel(), BorderLayout.SOUTH);
    }

    private JPanel makeSouthPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(enemyLabel, BorderLayout.NORTH);
        panel.add(makeButtonPanel(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel makeButtonPanel() {
        battleButtonCardLayoutPanel.add(makeBossButtonPanel(), BATTLE_BOSS);
        battleButtonCardLayoutPanel.add(makeNormalButtonPanel(), BATTLE_NORMAL);
        battleButtonCardLayoutPanel.add(makeWonButtonPanel(), BATTLE_WON);
        battleButtonCardLayoutPanel.add(makeLostButtonPanel(), BATTLE_LOST);
        return battleButtonCardLayoutPanel;
    }

    private void showButtonBar(String cardId) {
        battleButtonCardLayout.show(battleButtonCardLayoutPanel, cardId);
    }

    private JPanel makeNormalButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 20, 20));
        JButton fightButton = GuiUtils.makeButton("Fight!", Color.RED);
        panel.add(fightButton);
        JButton fleeButton = GuiUtils.makeButton("Flee!", Color.GREEN);
        panel.add(fleeButton);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        fightButton.addActionListener(e -> {
            gameLogic.fight();
            gameWindow.showBattleCard();
        });

        fleeButton.addActionListener(e -> {
            gameLogic.flee();
            if (gameLogic.currentEncounter == null) {
                gameWindow.showSuccessfulFleeCard();
            }
            else {
                gameWindow.showBattleCard();
            }
        });

        return panel;
    }

    private JPanel makeBossButtonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 20, 20));
        JButton fightButton = GuiUtils.makeButton("Fight!", Color.RED);
        panel.add(fightButton);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        fightButton.addActionListener(e -> {
            gameLogic.fight();
            gameWindow.showBattleCard();
        });

        return panel;
    }

    private JPanel makeWonButtonPanel() {
        JPanel panel = new JPanel();
        JButton continueButton = GuiUtils.makeButton("Continue", Color.BLACK);
        panel.add(continueButton);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        continueButton.addActionListener(e -> {
            BattleEncounter currentEncounter = (BattleEncounter) gameLogic.currentEncounter;
            if (currentEncounter.enemy.isBoss) {
                gameLogic.currentEncounter = null;
                gameWindow.showGameWonCard();
            }
            else {
                gameLogic.currentEncounter = null;
                gameWindow.showGameCard();
            }
        });

        return panel;
    }

    private JPanel makeLostButtonPanel() {
        JPanel panel = new JPanel();
        JButton restartButton = GuiUtils.makeButton("Restart", Color.BLACK);
        panel.add(restartButton);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        restartButton.addActionListener(e -> {
            gameLogic.setPlayer(null);
            gameLogic.currentEncounter = null;
            gameWindow.showWelcome();
        });

        return panel;
    }

    @Override
    protected void notifyCardShown() {
        BattleEncounter battleEncounter = (BattleEncounter) gameLogic.currentEncounter;
        Enemy enemy = battleEncounter.enemy;
        battleDescriptionTextArea.setText(battleEncounter.description);
        enemyLabel.setText(enemy.name + " HP: " + enemy.hp + "/" + enemy.maxHP);
        if (battleEncounter.won == null) {
            if (battleEncounter.enemy.isBoss) {
                showButtonBar(BATTLE_BOSS);
            }
            else {
                showButtonBar(BATTLE_NORMAL);
            }
        }
        else if (battleEncounter.won) {
            showButtonBar(BATTLE_WON);
        }
        else {
            showButtonBar(BATTLE_LOST);
        }
    }
}
