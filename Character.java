package ense600_assignment1;

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

//class that intializes the importants stats of all characters, player and enemies
public abstract class Character {
    public String name;
    public int maxHp, hp, xp; 
    
    //attack and defend elements
    public abstract int attack();
    public abstract int defend();
             
    //setter
    public Character(String name, int maxHp, int xp){
        this.name = name;
        this.maxHp = maxHp;
        this.xp = xp; 
        this.hp = maxHp; 
    }
}
