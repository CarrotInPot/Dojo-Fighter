package game.logic.encounters;

import game.logic.Enemy;

public class BattleEncounter extends Encounter {

    public String description;
    public Enemy enemy;
    public Boolean won;

    public BattleEncounter(Enemy enemy) {
        this.enemy = enemy;
        description = "You encounter a " + enemy.name + " what do you want to do?";
    }

}
