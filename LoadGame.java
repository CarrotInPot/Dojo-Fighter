package ense600_assignment1;

import static ense600_assignment1.GameLogic.readInt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*; 

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

//class that allows the user to load progress if the user was already found in the files. 
public class LoadGame {
   static Player loadPrompt(File file, String name) {
       Player pc;
        System.out.println("We found a save file with this name. Load?");
        System.out.println("(1) Yes!");
        System.out.println("(2) No, I want to start a new game.");
        int input = readInt("->", 2);
        if(input != 1) {
            //wants to start new game. Print warning
            System.out.println("If you save upon exit, you will overwrite the current save.");
            pc = new Player(name);
            GameLogic.pressEnterToContinue();
       } else
            pc = loadSave(file, name);
        return pc;
    }

    static Player loadSave(File file, String name) {
        Player player = new Player(name);          
            try (BufferedReader inStream = new BufferedReader(new FileReader(file))) {
                String str;
                while((str=inStream.readLine())!=null){
                    Scanner sc = new Scanner(str);
                    sc.useDelimiter(",,*|\\. *|: *|\\*\\**");             
                    while(sc.hasNext()){                                                      
                        String next = sc.next();
                        switch(next){
                            case "NAME" -> {
                                next = sc.next();
                                player.name = (next);
                                System.out.println(player.name);
                            }
                            case "HP" -> {
                                next = sc.next();
                                player.hp = (Integer.parseInt(next));
                            }
                            case "XP" -> {
                                next = sc.next();
                                player.xp = (Integer.parseInt(next));
                            }
                            default -> {
                                break;
                            }
                        }
                    }
                }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(LoadGame.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(LoadGame.class.getName()).log(Level.SEVERE, null, ex);
       }
            return player;
    }
}
