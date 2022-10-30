import game.db.DBManager;
import game.logic.Player;
import org.junit.Test;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void testInsertUpdatePlayer() throws SQLException {
        String uniqueName = UUID.randomUUID().toString();
        DBManager dbManager = new DBManager();
        assertNull(dbManager.loadPlayer("foo"));
        dbManager.savePlayer(new Player("foo", 1, 2, 3, 4));
        Player player = dbManager.loadPlayer("foo");
        assertNotNull(player);
        assertEquals("foo", player.name);
        assertEquals(1, player.hp);
        assertEquals(2, player.maxHP);
        assertEquals(3, player.xp);
        assertEquals(4, player.roomCount);
        player.hp = 1000;
        player.maxHP = 2000;
        player.xp = 3000;
        player.roomCount = 4000;
        dbManager.savePlayer(player);
        player = dbManager.loadPlayer("foo");
        assertEquals("foo", player.name);
        assertEquals(1000, player.hp);
        assertEquals(2000, player.maxHP);
        assertEquals(3000, player.xp);
        assertEquals(4000, player.roomCount);
    }

}
