package game.logic;

public class Player extends Character {

    public int xp;
    public int roomCount;

    public Player(String name, int hp, int maxHP, int xp, int roomCount) {
        super(name, hp, maxHP);
        this.xp = xp;
        this.roomCount = roomCount;
    }

    public Player(String name) {
        this(name, 100, 100, 0, 0);
    }
}
