package game.gui;

import game.logic.GameLogic;
import game.logic.encounters.BattleEncounter;
import game.logic.encounters.Encounter;
import game.logic.encounters.RestEncounter;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    public static final String TITLE = "DOJO FIGHTER";

    private static final String CARD_WELCOME = "WELCOME_CARD";
    private static final String CARD_CHARACTER_EXISTS_CONFIRMATION = "CHARACTER_EXISTS_CONFIRMATION";
    private static final String CARD_ROOM_DESCRIPTION = "ROOM_DESCRIPTION";
    private static final String CARD_BATTLE = "BATTLE";
    private static final String CARD_SUCCESSFUL_FLEE = "SUCCESSFUL_FLEE";
    private static final String CARD_GAME_WON = "GAME_WON";
    private static final String CARD_REST = "REST";
    private static final String CARD_EMPTY = "EMPTY";
    private static final String CARD_SAVE_PROMPT = "SAVE_PROMPT";

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel cardPanel = new JPanel(cardLayout);
    private final GameLogic gameLogic;

    public GameWindow(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
        setTitle(TITLE);
        setSize(600, 500);
        setLocationByPlatform(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        cardPanel.setLayout(cardLayout);
        add(cardPanel, BorderLayout.CENTER);
        cardPanel.add(new CenteredCard(new WelcomeCard(this, gameLogic)), CARD_WELCOME);
        cardPanel.add(new CenteredCard(new GameWonCard(this, gameLogic)), CARD_GAME_WON);
        cardPanel.add(new CenteredCard(new SavePromptCard(this, gameLogic)), CARD_SAVE_PROMPT);
        cardPanel.add(new CenteredCard(new CharacterExistsConfirmationCard(this, gameLogic)), CARD_CHARACTER_EXISTS_CONFIRMATION);
        cardPanel.add(new BattleCard(this, gameLogic), CARD_BATTLE);
        cardPanel.add(new RestCard(this, gameLogic), CARD_REST);
        cardPanel.add(new SuccessfulFleeCard(this, gameLogic), CARD_SUCCESSFUL_FLEE);
        cardPanel.add(new EmptyCard(), CARD_EMPTY);
        cardPanel.add(new RoomDescriptionCard(this, gameLogic), CARD_ROOM_DESCRIPTION);
        showWelcome();
    }

    public void showWelcome() {
        showCard(CARD_WELCOME);
    }

    private void showCard(String cardId) {
        cardLayout.show(cardPanel, CARD_EMPTY); // make card get reshown by clearing it first
        cardLayout.show(cardPanel, cardId);
    }

    public void showCharacterExistsConfirmation() {
        showCard(CARD_CHARACTER_EXISTS_CONFIRMATION);
    }

    public void showGameCard() {
        Encounter currentEncounter = gameLogic.currentEncounter;
        if (currentEncounter == null) {
            showCard(CARD_ROOM_DESCRIPTION);
        }
        else if (currentEncounter instanceof BattleEncounter) {
            showBattleCard();
        }
        else if (currentEncounter instanceof RestEncounter) {
            showCard(CARD_REST);
        }
        else {
            throw new IllegalStateException();
        }
    }

    public void showBattleCard() {
        showCard(CARD_BATTLE);
    }

    public void showSuccessfulFleeCard() {
        showCard(CARD_SUCCESSFUL_FLEE);
    }

    public void showGameWonCard() {
        showCard(CARD_GAME_WON);
    }

    public void showSavePrompt() {
        showCard(CARD_SAVE_PROMPT);
    }
}
