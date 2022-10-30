package game.logic;

public class Enemy extends Character {

    public final int xpValue;
    public final boolean isBoss;

    public Enemy(String name, int maxHP, int xpValue, boolean isBoss) {
        super(name, maxHP, maxHP);
        this.xpValue = xpValue;
        this.isBoss = isBoss;
    }

    static Enemy summonMob(String enemy) {

        Enemy mob = null;
        switch (enemy) {   //creating diffferent enemies 
            case "Ninja":
                mob = new Enemy("Ninja", 10, 20, false);
                break;
            case "Samurai":
                mob = new Enemy("Samurai", 15, 30, false);
                break;
            case "Sohei":
                mob = new Enemy("Sohei", 20, 40, false);
                break;
            case "Ashigaru":
                mob = new Enemy("Ashigaru", 30, 45, false);
                break;
            case "Wokou":
                mob = new Enemy("Wokou", 40, 55, false);
                break;
        }
        return mob;

    }
}
