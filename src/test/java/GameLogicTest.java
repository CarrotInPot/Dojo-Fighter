import game.logic.GameLogic;
import game.logic.Player;
import game.logic.encounters.BattleEncounter;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void testCreatePlayer() throws SQLException {
        GameLogic gameLogic = new GameLogic();
        assertNull(gameLogic.getPlayer());
        gameLogic.setPlayer(new Player("foo"));
        Player player = gameLogic.getPlayer();
        assertNotNull(player);
        assertEquals("foo", player.name);
        assertEquals(100, player.hp);
        assertEquals(100, player.maxHP);
        assertEquals(0, player.xp);
        assertEquals(0, player.roomCount);
    }

    @Test
    public void testGameplay() throws SQLException {
        GameLogic gameLogic = new GameLogic();
        assertNull(gameLogic.getPlayer());
        Player player = new Player("foo");
        gameLogic.setPlayer(player);
        assertSame(player, gameLogic.getPlayer());
        assertNull(gameLogic.currentEncounter);
        while (gameLogic.currentEncounter == null) {
            // continue until we have an encounter
            player.roomCount = 0;
            gameLogic.continueAdventure();
        }
        assertSame(BattleEncounter.class, gameLogic.currentEncounter.getClass());
        BattleEncounter currentEncounter = (BattleEncounter) gameLogic.currentEncounter;
        player.maxHP = Integer.MAX_VALUE; // Hopefully Invulnerable
        player.hp = Integer.MAX_VALUE; // Hopefully Invulnerable
        while (currentEncounter.enemy.hp > 0 && player.hp > 0) {
            gameLogic.fight();
        }
        assertTrue(currentEncounter.enemy.hp <= 0);
        assertTrue(player.hp > 0);
        assertNotNull(gameLogic.currentEncounter);
        assertEquals(1, player.roomCount);
        gameLogic.continueAdventure();
        assertEquals(2, player.roomCount);
        player.maxHP = Integer.MAX_VALUE; // Hopefully Invulnerable
        player.hp = Integer.MAX_VALUE; // Hopefully Invulnerable
        while (currentEncounter.enemy.hp > 0 && player.hp > 0) {
            gameLogic.flee();
        }
        // we haven't done any damage to this enemy
        assertNotEquals(currentEncounter.enemy.hp, currentEncounter.enemy.maxHP);
        assertEquals(2, player.roomCount);
    }

}
