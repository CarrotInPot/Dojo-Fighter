package ense600_assignment1;

import static ense600_assignment1.GameLogic.readInt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

//class that allows the user to save the game at any point. 
public class SaveGame {
     static void savePrompt(Player player) {
        String name = player.getName();
        String fileName = name + ".txt";
        File file = new File("./resources/" + fileName);
         if(file.exists()){
                System.out.println("You have an existing save. Overwrite it?");
                System.out.println("(1) Yes.");
                System.out.println("(2) No, exit without saving.");
                 int input = readInt("->", 2);
                 //react accordingly to user input
                        if(input == 1){
                            saveInfoInitialize(player);
                                saveGame(file);
                                System.out.println("File Overwritten, thanks for playing.");
         }
         else{
                    saveInfoInitialize(player);
                                saveGame(file); 
                                System.out.println("File not overwritten");
            }               
        } else{ 
            saveInfoInitialize(player);
            saveGame(file);  
            System.out.println("Thanks for playing");
         }
    }
     
    static Map<String, String> playerInfo = new HashMap<>();
   
    //prints stats to the file 
    public static void saveInfoInitialize(Player player) {
        playerInfo.put("NAME", player.getName()) ;
        playerInfo.put("HP", String.valueOf(player.getHp())) ;
        playerInfo.put("XP", String.valueOf(player.getXp())) ;
    }

    //saves game
      private static void saveGame(File fileName) {
        try {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))
            ) {
                for (Map.Entry<String, String> entry : playerInfo.entrySet()) {
                    pw.write(entry.getKey() + ":" + entry.getValue());
                    pw.println();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
