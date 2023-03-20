package ense600_assignment1;

import static ense600_assignment1.GameLogic.pressEnterToContinue;
import static ense600_assignment1.GameLogic.printSeperator;

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

//class that uses polymorphism to use animalSound to create different sounds 
public class Animals{
    public void animalSound(){
        System.out.println("Sounds of the night can be heard in the distance");
    }
                                                                                        
    //cricket sounds
    public static class Crickets extends Animals{
        @Override
        public void animalSound(){
            printSeperator(20);
            System.out.println("*cricket noises*");
            printSeperator(20);
            pressEnterToContinue();
        }
    }
    
    //wolf sounds
    public static class Wolves extends Animals{
        @Override
        public void animalSound(){
            printSeperator(20);
            System.out.println("*barking, whimpering, growling, and howling*");
            printSeperator(20);
            pressEnterToContinue();
        }
    }
    
    //owl sounds
    public static class Owls extends Animals{
        @Override
        public void animalSound(){
            printSeperator(20);
            System.out.println("*whistles, shrieks, hisses, coos, and wavering cries.*");
            printSeperator(20);
            pressEnterToContinue();
        }
    }
    
    //raven sounds
    public static class Ravens extends Animals{
        @Override
        public void animalSound(){
            printSeperator(20);
            System.out.println("*CAW CAW CAW CAW CAW*");
            printSeperator(20);
            pressEnterToContinue();
        }
    }
}
