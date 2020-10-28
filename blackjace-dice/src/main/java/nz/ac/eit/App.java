package nz.ac.eit;

import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    /*REQ-1:  Establish the pt values for each number in a method called numberValue*/
    public static int numberValue(int numberRolled, String whosTurn){
        int valueOfRolledNumber = numberRolled; //REQ-1.b
        Scanner scanner=new Scanner(System.in);


        if(numberRolled == 0) {
            valueOfRolledNumber = 10; //REQ-1.a
        } else if (numberRolled == 1) {
            if(whosTurn.equals("player")) {
                //REQ-1.c
                System.out.println("You've rolled a 1. Would you like it to be worth 1 or 11?");
                int usersValueChoiceForNum1 = scanner.nextInt();
                //Validate for invalid input

                if (usersValueChoiceForNum1 == 11) {
                    valueOfRolledNumber = 11; //REQ-1.d
                }
            } else if (whosTurn.equals("dealer")) {
                valueOfRolledNumber = 11;
            }
        }

        return valueOfRolledNumber;
    }

    //sum the playerHand or the dealerHand
    public static int sumOfHand(int[] hand){
        int sum = 0;

        for (int value : hand) {
            sum += value;
        }
        return sum;
    }

    //REQ-2: Establish what is required to win in a method called blackjackOrBust
    public static String blackjackOrBust(int[] hand){
        String outcome = "play on";
        int sumOfHand = sumOfHand(hand);

        if (sumOfHand > 21) {
            outcome = "bust";
        } else if (sumOfHand == 21) {
            outcome = "blackjack";
        }

        return outcome;
    }

    //REQ-3:  Establish the rules for dealer's move in a method called dealersMove
    public static String dealersMove (int[] dealersHand) {
        String outcome = null;

        if(sumOfHand(dealersHand) >= 17) {
            outcome = "hold";
        } else if (sumOfHand(dealersHand) < 17) {
            outcome = "roll";
        }
        return outcome;
    }

    public static int diceRoll () {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber;
    }

    public static void main( String[] args ) {
        //Although the player has the first turn, we deal the dealer's cards first so need to set this variable to 'dealer'
        String whosTurn = "dealer";
        int[] dealersHand;
        int[] playersHand;


        System.out.println(diceRoll());
        System.out.println(diceRoll());
        System.out.println(diceRoll());
    }
}
