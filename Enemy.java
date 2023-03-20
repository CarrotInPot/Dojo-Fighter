package ense600_assignment1;

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

//Enemy class with enemy specific traits that extends character  
public class Enemy extends Character {
    int playerXp; 
    
    //enemy hp changers with player xp
    public Enemy(String name, int playerXp){
        super(name, (int)(Math.random()*playerXp+ playerXp/3+5), (int)(Math.random()*(playerXp/4+2) + 1));
        //assigning variable 
        this.playerXp = playerXp; 
    }
    
    // enemy specific attack and defense calculations that change with player xp 
    @Override
   public int attack() {
        return (int)(Math.random()*(playerXp/4+1) + xp/4+3 );
    }

    @Override
    public int defend() {
        return (int)(Math.random() * (playerXp/4+1) + xp/4+3);
    }
    
}
