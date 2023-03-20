package ense600_assignment1;

/* 
* @author Samuel Meads
* Student ID: 20113456
*/

// class that stores methods to print out every part of the story 
public class Storyline {
    
    public static void printIntro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("STORY");
        GameLogic.printSeperator(30);
        System.out.println("As a young one you looked up to Yamaguchi Sensei, the greatest Karate master in the world.");
        System.out.println("His dojo, one hundred thousands steps high on Mount Fuji seemed an impossible feat to you at the time.");
        System.out.println("Cut to present day, you just turned 16 and so you packed your things, said your goodbyes, and began the ascent");
        GameLogic.pressEnterToContinue(); 
    }
    
    public static void printFirstActIntro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT I - New Beginnings");
        GameLogic.printSeperator(30);
        System.out.println("The journey ahead is about a 10 day trek, as long as you average 10000 steps per day.");
        System.out.println("Along the way you encounter many others making the trip, some are friendly, some are hostile ");
        System.out.println("You take whatever measures to make it to the top.....");
        GameLogic.pressEnterToContinue(); 
    }
    
    public static void printFirstActOutro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT I END");
        GameLogic.printSeperator(30);
        System.out.println("You finally make it to the top late in the night after 10 long days.");
        System.out.println("You are greeted by the two guards at the entrance and they let you in and nurture you back to full health.");
        System.out.println("The next morning you finally meet Yamaguchi Sensei and he awards you the white belt.");
        System.out.println("WHITE BELT ACQUIRED");
        GameLogic.pressEnterToContinue(); 
    }   
        
    public static void printSecondActIntro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT II - Aokigahara");
        GameLogic.printSeperator(30);
        System.out.println("Your training starts by Sensei telling you to go on a mission to Aokigahara, The suicide Forest.");
        System.out.println("A deeply spiritual and emotional place, the area has been overrun by primarly Samurai and it's your duty to wipe them out");
        System.out.println("Successfully do this and you will be rewarded with a Orange belt.");
        GameLogic.pressEnterToContinue(); 
    }
    
    public static void printSecondActOutro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT II END");
        GameLogic.printSeperator(30);
        System.out.println("You return finally, beated and battered");
        System.out.println("Sensei is not there when you arrive back but an orange belt was already placed on your bed.");
        System.out.println("He believed in you! ");
        System.out.println("You feel a sense of achievement and faith in yourself to continue to perform to the best of your ability for the Dojo.");
        System.out.println("ORANGE BELT ACQUIRED");
        GameLogic.pressEnterToContinue(); 
    }
        
    public static void printThirdActIntro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT III - Korea");
        GameLogic.printSeperator(30);
        System.out.println("Barely having any time to recover you are sent back out on a mission, This time to Korea.");
        System.out.println("A gang of Ashigaru have been causing trouble over there and so you need to go over on the next boat avaliable.");
        System.out.println("Successfully do this and you will be rewarded with a Green Belt");
        GameLogic.pressEnterToContinue(); 
    }
    
        public static void printThirdActOutro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT III END ");
        GameLogic.printSeperator(30);
        System.out.println("It seems as if a year had passed, you learnt Korean and adopted their culture as your own.");
        System.out.println("You looked forward to see your Family and friends again in Japan");
        System.out.println("But something was wrong.. as you approached the town a huge cloud of smoke ");
        System.out.println("GREEN BELT ACQUIRED");
        GameLogic.pressEnterToContinue(); 
    }
        
    public static void printFourthActIntro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT IV - Fuji Town");
        GameLogic.printSeperator(30);
        System.out.println("You burst into action trying to find water to get rid of the fire.");
        System.out.println("At the same time you encounter hecklers trying to stop you on your path.");
        System.out.println("Successfully do this and you will be rewarded with a Brown Belt");
        GameLogic.pressEnterToContinue(); 
    }
    
        public static void printFourthActOutro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT IV END");
        GameLogic.printSeperator(30);
        System.out.println("The town still in flames, you realize the situation is unfixable.");
        System.out.println("You run towards your parents house only to witness Sensei killing your own parents");
        System.out.println("BROWN BELT ACQUIRED");
        GameLogic.pressEnterToContinue(); 
    }
        
        public static void printFifthActIntro(){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT V - Black Belt");
        GameLogic.printSeperator(30);
        System.out.println("You want revenge.");
        System.out.println("In the form of blood.");
        System.out.println("You verse all of the dojo and finally Sensei.");
        GameLogic.pressEnterToContinue(); 
    }
      
    public static void printEnd(Player player){
        GameLogic.clearSpace();
        GameLogic.printSeperator(30);
        System.out.println("ACT V END");
        GameLogic.printSeperator(30);
        System.out.println("You did what you never thought you would do before.");
        System.out.println("The person you always looked up to, now killed by your own hand.");
        System.out.println("Revenge, but at what cost?");
        System.out.println("BLACK BELT ACQUIRED");
        GameLogic.printSeperator(30);
        System.out.println("THE END");
        GameLogic.pressEnterToContinue(); 

    }
    
}
