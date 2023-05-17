package game.logic;

public abstract class Character {
    
    public String name;
    public int maxHP;
    public int hp;

    //constructor
    public Character(String name, int hp, int maxHP){
        this.name = name;
        this.hp = hp;
        this.maxHP = maxHP;
    }

}
