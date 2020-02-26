// Author : Trey Foehner
// Date   : 10/31/2019
// Purpose: Create a program that allows you to play War with a bot

import java.util.*;

public class War {
    //Static method returning random number 1-13
    private static int returnNum(){
        return (int) (Math.random() * 13 + 1);
    }
    public static void main(String[] args) {

        System.out.println("Get ready for a game of WAR!");

        //Declaring constant
        final int TOTAL_CARDS = 52;

        //Declare new scanner object
        Scanner keyboard = new Scanner(System.in);

        //Initializing scores as splitting the deck up between 2 players
        int score1 = TOTAL_CARDS / 2;
        int score2 = TOTAL_CARDS / 2;

        //Ask user for name & store value
        System.out.println("Enter user name: ");
        String name1 = keyboard.nextLine();
        String name2 = "Enemy";

        //For as long as score1 & 2 are not equal to 0:
        while (score1 > 0 && score2 > 0) {

            int card1 = (returnNum());
            int card2 = (returnNum());

            System.out.println("\nPress enter to assign your card.");

            //For assigning a card when enter is pressed
            String enterKey;
            enterKey = keyboard.nextLine();
            if (enterKey.equals("")) {

                System.out.println(name1+" : "+card1);
                System.out.println(name2+" : "+ card2);
                System.out.println("______________");

                //If Player1 wins:
                if (card1 > card2) {
                    score1 += 1;
                    score2 -= 1;
                    System.out.println(name1+" wins!");
                    System.out.println("The score for "+name1+" is: " + score1 + "\nThe score for "+name2+" is: " + score2);
                }
                //If Player2 wins:
                else if (card1 < card2) {
                    score2 += 1;
                    score1 -= 1;
                    System.out.println(name2+" wins!");
                    System.out.println("The score for "+name2+" 1 is: " + score1 + "\nThe score for "+name2+" is: " + score2);
                }
                //If WAR is declared:
                while (card1 == card2) {
                    System.out.println("\nWAR is declared!");
                    card1 = (int) (returnNum());
                    card2 = (int) (returnNum());
                    System.out.println("\n"+name1+" : "+ card1);
                    System.out.println(name2+" : "+ card2);
                    //If Player1 wins war:
                    if (card1 > card2) {
                        score1 += 3;
                        score2 -= 3;
                        System.out.println(name1+" wins!");
                        System.out.println("The score for "+name1+" is: " + score1 + "\nThe score for "+name2+" is: " + score2);
                    }
                    //If Player2 wins war:
                    else if (card1 < card2) {
                        score2 += 3;
                        score1 -= 3;
                        System.out.println(name2+" wins!");
                        System.out.println("The score for "+name1+" is: " + score1 + "\nThe score for "+name2+" is: " + score2);
                    }
                }
            //If Player1 or Player2 wins
            if (score2 == 0)
                System.out.println("\n"+name1+" Wins!");
            else if (score1 == 0)
                System.out.println("\n"+name2+" Wins!");
            }
        }
        System.out.println("\nThanks for playing");
    }
}
