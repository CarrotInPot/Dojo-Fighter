package game.logic;

import game.db.DBManager;
import game.logic.encounters.BattleEncounter;
import game.logic.encounters.Encounter;
import game.logic.encounters.RestEncounter;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public final class GameLogic {

    //variables
    private final DBManager dbManager;
    private final Map map = new Map();
    private Player player;
    public Encounter currentEncounter;
    private static final int NUM_ACTS = 5;
    private static final String[] ENEMY_NAMES = new String[]{"Ninja", "Samurai", "Sohei", "Ashigaru", "Wokou"};
    private static final Random rand = new Random();

    public GameLogic() throws SQLException {
        dbManager = new DBManager();
    }

    public GameLogic(String databaseName) throws SQLException {
        dbManager = new DBManager(databaseName);
    }
    
    //getter and setters 
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player pc) {
        player = pc;
    }

    //continue 
    public void continueAdventure() {
        player.roomCount++;
        currentEncounter = null;
        //If not fighting sensei
        if (player.roomCount < NUM_ACTS) {
            //random encounter
            int num = rand.nextInt(5);
            if (num < 3) {
                int numEnemy = rand.nextInt(3);
                Enemy enemy = Enemy.summonMob(ENEMY_NAMES[numEnemy]);
                currentEncounter = new BattleEncounter(enemy);
            } else {
                if (player.hp < player.maxHP) { //rest restores hp 
                    String restMessage = "You find a moment to rest.";
                    int healed = rand.nextInt(player.maxHP / 2);
                    player.hp += healed;
                    if (player.hp >= player.maxHP) { 
                        restMessage += "\n\nYour hp is restored to max!";
                        player.hp = player.maxHP;
                    } else { //hp healed 
                        restMessage += "\n\nYour hp is restored by " + healed + " points!";
                    }
                    currentEncounter = new RestEncounter(restMessage);
                } else {
                    currentEncounter = null;
                }
            }
        } else {
            currentEncounter = new BattleEncounter( //final boss encounter
                    new Enemy("Yamaguchi Sensei", 100, 100, true)
            );
        }
    }
     
    //getters 
    public DBManager getDBManager() {
        return dbManager;
    }

    public Map getMap() {
        return map;
    }

    public Room getCurrentRoom() {
        return map.getRoom(player.roomCount);
    }
 
        // run away from battle
    public void flee() { 
        if (!(currentEncounter instanceof BattleEncounter)) {
            throw new IllegalStateException();
        }
        BattleEncounter battleEncounter = (BattleEncounter) currentEncounter;
        Enemy opp = battleEncounter.enemy;

        int escapeChance = rand.nextInt(100);
        if (escapeChance > 50) {
            //success
            currentEncounter = null;
        } else {
            //fail
            String dmg = "You failed to flee!";
            int dmgTaken = attack();
            dmg += "\n\nYou took " + dmgTaken + " damage when trying to escape!";

            player.hp -= dmgTaken;

            //if player loses
            if (player.hp <= 0) {
                dmg += "\n\nYou were killed by the " + opp.name;
                dmg += "\n\nThank you for playing!";
                battleEncounter.won = false;
            }
            battleEncounter.description = dmg;
        }
    }

    //fight scenario 
    public void fight() {
        if (!(currentEncounter instanceof BattleEncounter)) {
            throw new IllegalStateException();
        }
        BattleEncounter battleEncounter = (BattleEncounter) currentEncounter;
        Enemy opp = battleEncounter.enemy;
        int dmgDealt = attack();
        String dmg = "You dealt " + dmgDealt + " damage to the enemy!";
        opp.hp -= dmgDealt;
        if (opp.hp > 0) {
            // if we kill the enemy, they cant kill us too
            int dmgTaken = attack();
            dmg += "\n\nThe enemy did " + dmgTaken + " damage to you!";
            player.hp -= dmgTaken;
        }

        //if player wins the battle
        if (opp.hp <= 0) {
            dmg += "\n\nYou defeated the " + opp.name + "! You gained " + opp.xpValue + "XP";
            battleEncounter.won = true;
            player.xp += opp.xpValue;
            // if wins final battle 
            if (opp.isBoss) { 
                dmg += "\n\nYou defeated Yamaguchi Sensei!";
            }
        }

        //if player dies
        else if (player.hp <= 0) {
            dmg += "\n\nYou were killed by the " + opp.name;
            dmg += "\n\nThank you for playing!";
            battleEncounter.won = false;
        }

        battleEncounter.description = dmg;
    }
    
    //random attack value 
    public static int attack() {
        return rand.nextInt(15) + 1;
    }

}
