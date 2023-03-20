package ense600_assignment1;

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

// player class with player specific traits that extends character 
public final class Player extends Character{
    public int numAtkUpgrades, numDefUpgrades; 
    
    //additional player stats
    int gold, rests, pots; 
    
    //Arrays to store stat names 
    public String atkUpgrades = "Attack";
    public String defUpgrades = "Defence"; 
    
    //getters
    public String getName(){
        return name; 
    }
    
    public int getHp(){
        return hp; 
    }
    
    public int getXp(){
        return xp; 
    }
    
    //player specific constructor 
    public Player(String name){
        // calling constructors of superclass
        super(name, 50, 5); 
        //Setting the number of upgrades 
       this.numAtkUpgrades = 0; 
       this.numDefUpgrades = 0; 
       //set additional stats
       this.gold = 10; 
       this.rests = 1;
       this.pots = 0; 
       chooseStat(); 
    }
    
    //player specific methods for attack and defend that change depending on xp and upgrades  
    @Override
    public int attack() {
        return (int)(Math.random()*(xp/4 + numAtkUpgrades*4 + 3) + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int)(Math.random()*(xp/4 + numDefUpgrades*4 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }
    
    // choosing stat to increase 
    public void chooseStat(){
        GameLogic.clearSpace(); 
        GameLogic.printHeading("Choose a stat to increase!");
        System.out.println("(1) Attack");
        System.out.println("(2) Defence");
        //react accordingly to user input
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearSpace(); 
        if (input == 1){
            GameLogic.printHeading("Attack stat increased.");
            numAtkUpgrades++; 
        } else {
            GameLogic.printHeading("Defense stat increased.");
            numDefUpgrades++;
        }
        GameLogic.pressEnterToContinue(); 
    }
}
