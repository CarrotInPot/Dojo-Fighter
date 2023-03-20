package ense600_assignment1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner; 

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

public class GameLogic {
  public static Scanner sc = new Scanner(System.in);
  public static Player player;
  public static boolean isRunning; 
  
  //random events
  public static String[] events = {"Battle", "Battle", "Battle", "Battle", "Battle", "Rest", "Shop"}; 
  public static String[] enemies = {"Ninja", "Samurai", "Ashigaru", "Wokou", "Sohei", "Yamabushi"}; 

  //story places and acts 
  public static int place = 0, act = 1;
  public static String[] places = {"The steps of Mt Fuji", "Mt Fuji Dojo", "Aokigahara", "Korea", "Fuji Town"};  
  
  //gets user input only accepting integers from cui
  public static int readInt(String prompt, int choice) {
    int i;
    do {
      System.out.println(prompt);
      try {
        i = Integer.parseInt(sc.next());
      } catch (NumberFormatException e) {
        i = -1;
        System.out.println("Enter an integer!");
      }
    }while (i < 1 || i > choice);
    return i;
  }
  
  //method to print a seperator with length j to make it look better 
  public static void printSeperator(int j) {
    for (int i = 0; i < j; i++)
      System.out.print("-");
      System.out.println("");
  }

  //method to use when printing out a heading. 
  public static void printHeading(String title) {
    printSeperator(25);
    System.out.println(title);
    printSeperator(25);
  }

  //method to simulate clearing out spaces in the console (50 spaces) 
  public static void clearSpace() {
    for (int i = 0; i < 50; i++)
      System.out.println();
  }
  
  
  //method to pause the game until user enters anything
 public static void pressEnterToContinue()
 { 
        System.out.println("\nPress Enter key to continue.");
        try{
            System.in.read();
            sc.nextLine();
        }  
        catch(IOException e){
        }  
 }
  
  // gets the name of the user 
  public static String getName() {
      String name;
      boolean nameSet = false;
        do{
            clearSpace();
            printSeperator(20);
            System.out.println("What is your name?");
            printSeperator(20);
            name = sc.next();       
            System.out.println("Is your name " + name + "?" );
            System.out.println("(1) Yes!");
            System.out.println("(2) No, I want to change my name.");
            var input = readInt("->", 2);
            //react accordingly to user input
            if(input != 1) {
          } else {            
                nameSet = true;
          }            
        }
        while(!nameSet); 
            return name;
    } 

  // start of the game 
  public static void startGame() {
    clearSpace();
    printSeperator(30);
    System.out.println("The Dojo Fighter");
    printSeperator(30);
    pressEnterToContinue();
    
       String name = getName();      
       //check if file already exists
        File file = new File("./resources/" + name + ".txt");
        if(file.exists()){
            player = LoadGame.loadPrompt(file, name);
        }else{
        player = new Player(name);
        }
        System.out.println("Your name is " + name);
       if(player.xp == 0){
            clearSpace();
            pressEnterToContinue();
        }
    //print story intro
    Storyline.printIntro();
    //create new player object with the name
    player = new Player(name);
    //print the storoy of first act intro
    Storyline.printFirstActIntro(); 
    //setting to true so the game loop can continue 
    isRunning = true; 
    //start main game loop 
    gameLoop(); 
  }
  
  //changes the act based on player xp
  public static void checkAct(){
      if (player.xp >= 10 && act == 1 ){
          //change act and place 
          act = 2; 
          place = 2;
          //story 
          Storyline.printFirstActOutro();
          // let the player choose a stat to increase every act change 
          player.chooseStat();  
          //animal noises
          Animals myAnimal = new Animals();
          Animals myWolf = new Animals.Wolves();
          myAnimal.animalSound();
          myWolf.animalSound(); 
          //story
          Storyline.printSecondActIntro(); 
          //enemy encounters that change every act 
          enemies[0] = "Ninja";
          enemies[1] = "Ninja";
          enemies[2] = "Ninja";
          enemies[3] = "Ninja";
          enemies[4] = "Samurai";
          enemies[5] = "Ashigaru";
          //assign new values to events
          events[0] = "Battle";
          events[1] = "Battle";
          events[2] = "Battle";
          events[3] = "Rest";
          events[4] = "Shop";
          //fully restore the players hp
          player.hp = player.maxHp; 
          //all acts apart from act 5 follow this same methodology 
      }else if(player.xp >= 20 && act == 2){
          act = 3; 
          place = 3;
          Storyline.printSecondActOutro();
          player.chooseStat();  
          Animals myAnimal = new Animals();
          Animals myCricket = new Animals.Crickets();
          myAnimal.animalSound();
          myCricket.animalSound(); 
          Storyline .printThirdActIntro();
          enemies[0] = "Samurai";
          enemies[1] = "Samurai";
          enemies[2] = "Samurai";
          enemies[3] = "Samurai";
          enemies[4] = "Ashigaru";
          enemies[5] = "Wokou";
          events[0] = "Battle";
          events[1] = "Battle";
          events[2] = "Battle";
          events[3] = "Rest"; 
          events[4] = "Shop";
      }else if(player.xp >= 40 && act == 3){
          act = 4; 
          place = 4;
          Storyline.printThirdActOutro();
          player.chooseStat(); 
          Animals myAnimal = new Animals();
          Animals myOwl = new Animals.Owls();
          myAnimal.animalSound();
          myOwl.animalSound(); 
          Storyline.printFourthActIntro();
          enemies[0] = "Ashigaru";
          enemies[1] = "Ashigaru";
          enemies[2] = "Ashigaru";
          enemies[3] = "Ashigaru";
          enemies[4] = "Wokou";
          events[0] = "Battle";
          events[1] = "Battle";
          events[2] = "Battle";
          events[3] = "Rest";
          events[4] = "Shop";
          player.hp = player.maxHp; 
      }else if(player.xp >= 60 && act == 4){
          act = 5; 
          place = 1;
          Storyline.printFourthActOutro();
          player.chooseStat(); 
          Animals myAnimal = new Animals();
          Animals myRaven = new Animals.Ravens();
          myAnimal.animalSound();
          myRaven.animalSound(); 
          Storyline.printFifthActIntro();
          enemies[0] = "Wokou"; 
          enemies[1] = "Wokou";
          enemies[2] = "Wokou";
          enemies[3] = "Sohei";
          enemies[4] = "Yamabushi";
          events[0] = "Battle";
          events[1] = "Battle";
          events[2] = "Battle";
          events[3] = "Rest";
          events[4] = "Shop";
          player.hp = player.maxHp; 
      }else if(player.xp >= 65 && act == 5){
          finalBattle(); 
        }
   } 
  
     //final battle, after this the game ends 
      public static void finalBattle(){
        //enemy object
        battle(new Enemy("Yamaguchi Sensei", 200));
        //print the ending 
        Storyline.printEnd(player);
        //ends the game
        isRunning = false;
    } 
  
    //common battle loop
   public static void battle(Enemy enemy){
      OUTER:
      while (true) {
          clearSpace();
          printHeading(enemy.name + "\n HP: " + enemy.hp + "/" + enemy.maxHp);
          printHeading(player.name + "\n HP: " + player.hp + "/" + player.maxHp);
          System.out.println("Choose an Action:");
          printSeperator(20);
          System.out.println("(1) Battle");
          System.out.println("(2) Use an item");
          System.out.println("(3) Run away");
          int input = readInt("-> ", 3);
          //react accordingly to user input
          switch (input) {
              case 1 -> {
                  //calulate damage and damagetaken(dmg enemy deals to player)
                  int dmg = player.attack() - enemy.defend();
                  int dmgTook = enemy.attack() - player.defend();
                  //check that damage and damage taken isnt negative
                  if(dmgTook < 0){
                      //add some dmg if player defends very well
                      dmg -= dmgTook/2;
                      dmgTook = 0;
                  } if(dmg<0)
                      dmg = 0;
                  //deal damage to both parties
                  player.hp -= dmgTook;
                  enemy.hp -= dmg;
                  //print the info of this battle round
                  clearSpace();
                  printHeading("BATTLE");
                  System.out.println("You Dealt " + dmg + " damage to the " + enemy.name + ".");
                  printSeperator(15);
                  System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                  pressEnterToContinue();
                  //check if player is alive
                  if (player .hp <= 0) {
                      playerDied();
                      break OUTER;
                  } else if (enemy.hp <= 0) {
                      // tell the player they won
                      clearSpace();
                      printHeading("You defeated the " + enemy.name + "!");
                      player.xp += enemy.xp;
                      // grants xp equal to the enemies'
                      System.out.println("You earned " + enemy.xp + "XP!");
                      //random drops
                      boolean addRest = (Math.random()*5 + 1  <= 2.25);
                      int goldEarned = (int) (Math.random()*enemy.xp);
                      if(addRest){
                          player.rests++;
                          System.out.println("You earned the chance to get an additional rest!");
                      } if(goldEarned > 0){
                          player.gold += goldEarned;
                          System.out.println("You collected " + goldEarned + " gold from defeating the " + enemy.name + "!");
                      } pressEnterToContinue();
                      break OUTER;
                  }
              }
              case 2 -> {
                  //use an item
                  clearSpace();
                  if(player.pots > 0 && player.hp < player.maxHp){
                      printHeading("Are you sure you want to drink a potion? (" + player.pots + " left)." );
                      System.out.println("(1) Yes");
                      System.out.println("(2) No ");
                      input = readInt("-> ", 2);
                      //react accordingly to user input
                      if(input == 1){
                          player.hp = player.maxHp;
                          clearSpace();
                          printHeading("Your health is restored back to full!");
                          pressEnterToContinue();
                      }
                  }else{
                      //player cannot take an item
                      printHeading("You dont have any items or you're at full hp.");
                      pressEnterToContinue();
                  }
              }
              default -> {
                  clearSpace();
                      // chance of 20 percent to escape
                      if (Math.random()*10 + 1 <= 2.0) {
                          printHeading("You ran away!");
                          pressEnterToContinue();
                          break OUTER;
                      } else {
                          printHeading("You failed to run away!");
                          //takes damage if fails 
                          int dmgTook = enemy.attack();
                          System.out.println("You took " + dmgTook + " damage whilst trying to run away!");
                          pressEnterToContinue();
                          if(player.hp<=0){
                              playerDied();
                          } 
                      }
                      
                }
            }
        }
    }
    
  
  //method to generate a random event
  public static void randomEvent(){
      //random number between 0 and the length of the events array
      int event = (int)(Math.random()*events.length);
      //calling the respective methods
      switch (events[event]) {
          case "Battle" -> RandomBattle();
          case "Rest" -> takeRest();
          default -> shop();
      }
  }
  
  //method to continue journey unless game is in last act
    public static void continueGame() {
        //check if act must be increased 
        checkAct(); 
        if (act !=5)
            randomEvent();
    }
    
    //display for characterinfo 
    public static void characterInfo(){
        clearSpace();
        printHeading("CHARACTER INFO");
        //player hp
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);        
        printSeperator(20);
        //player xp and gold
        System.out.println("XP: " + player.xp + "\tGold: "+ player.gold);
        printSeperator(20);
        // number of pots you have
        System.out.println("Potions: " + player.pots);
        printSeperator(20);
        //printing the chosen stats upgraded 
            System.out.println("Attack stats: " + player.numAtkUpgrades);
            printSeperator(20);
            System.out.println("Defensive stats: " + player.numDefUpgrades);
        pressEnterToContinue(); 
    }

//encountering a travelling trader 
    public static void shop(){
        clearSpace(); 
        printHeading("You meet a wandering traveller.\nHe offers you something in exchange for gold."); 
        int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots); 
        System.out.println("1 Magic Potion: " + price + " gold.");
        printSeperator(20);
        System.out.println("Do you want to buy one?"); 
        System.out.println("(1) Yes.");
        System.out.println("(2) No.");
        //react accordingly to user input
        int input = readInt("-> ", 2); 
        if(input == 1){
            clearSpace(); 
            //check if player has enough gold
            if(player.gold >= price){ 
                printHeading("You bought a magical potion for " + price + "gold.");
                player.pots++;
                player.gold -= price; 
            }else printHeading("You don't have enough gold to buy this...");
            pressEnterToContinue();
        }
    }
    
    //taking a rest
    public static void takeRest(){
        clearSpace();
        if(player.rests >= 1){
            printHeading("Do you want to take a rest? (" + player.rests + "rest(s) left.");
            System.out.println("(1) Yes");
            System.out.println("(2) No");
            int input = readInt("--> ", 2);
            //react accordingly to user input
            if(input == 1){
                clearSpace(); 
                //checks if user is at full hp 
                if(player.hp <= player.maxHp){
                    int Restoredhp = (int)((player.xp/4+1) + 10);
                    player.hp += Restoredhp;
                    //if rest restores more than maxhp, sets hp to max. 
                    if(player.hp > player.maxHp){
                        player.hp = player.maxHp;
                    }
                    System.out.println("You took a rest and restored " + Restoredhp + "Hp");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
                    //takes away 1 rest avaliable
                    player.rests--; 
                }
            }else  //if user is at full hp, cannot rest
                System.out.println("You're already at full Hp.");
            pressEnterToContinue(); 
        }   
    }
    
    //random battle 
    public static void RandomBattle(){
        clearSpace(); 
        printHeading("You have encountered an enemy!");
        pressEnterToContinue(); 
        //creating new enemy object from avaliable names in the act. 
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }
  
    // main display menu 
    public static void printMenu(){
        clearSpace();
        printHeading("Main Menu"); 
        //displays current place
        printHeading("You are currently at: " + places[place]);
        System.out.println("Choose an action:");
        printSeperator(15);
        System.out.println("(1) Continue on the journey");
        System.out.println("(2) Your Character Info");
        System.out.println("(3) Exit the Game");
    }
  
  //main game loop
    public static void gameLoop() {
        while(isRunning){
            printMenu();
            // get the players choice:
            int input = readInt("-> ", 3);
            switch(input){
                //react accordingly to user input
                case 1 -> continueGame();
                case 2 -> characterInfo();
                case 3 -> {
                    SaveGame.savePrompt(player);
                    isRunning = false; 
                    break;  
                }
                default -> { break;
                }
            }
        }
    }
    
    //method that gets called when the player is dead (hp = 0 or less than 0)
    public static void playerDied(){
        clearSpace();
        printHeading("You died.");
        printHeading("You earned " + player.xp + "XP on your journey.");
        printHeading("Thanks for playing.");
        isRunning = false; 
    }
}
