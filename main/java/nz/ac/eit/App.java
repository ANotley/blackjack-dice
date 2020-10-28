package nz.ac.eit;

import java.util.ArrayList;
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
                System.out.println("You've rolled a 1. Would you like it to be worth 1 or 11?  ");
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
    public static int sumOfHand(ArrayList<Integer> hand){
        int sum = 0;

        for (int value : hand) {
            sum += value;
        }
        return sum;
    }

    //REQ-2: Establish what is required to win in a method called blackjackOrBust
    public static String blackjackOrBust(ArrayList<Integer> hand){
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
    public static String dealersMove (ArrayList<Integer> dealersHand) {
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
        //Set up Variables
        //Although the player has the first turn, we deal the dealer's cards first so need to set this variable to 'dealer'
        String whosTurn = "dealer";
        ArrayList<Integer> dealersHand = new ArrayList<Integer>();
        ArrayList<Integer> valueOfDealersHand = new ArrayList<Integer>();

        ArrayList<Integer> playersHand = new ArrayList<Integer>();
        ArrayList<Integer> valueOfPlayersHand = new ArrayList<Integer>();

        //REQ-5: Welcome Message
        System.out.println("Welcome to Blackjack Dice. Lets Start!\n");

        //REQ-6: Deal the Dealer's first dice roll.
        dealersHand.add(diceRoll());
        valueOfDealersHand.add(numberValue(dealersHand.get(0), whosTurn));

        System.out.println("Dealers First Roll: " + dealersHand.get(0) + "        - DEALER'S TOTAL: " + sumOfHand(valueOfDealersHand));

        //REQ-7: Player's turn. Two dice rolls are dealt to them
        whosTurn = "player";
        System.out.println("_____________________________________________________");
        playersHand.add(diceRoll());
        valueOfPlayersHand.add(numberValue(playersHand.get(0), whosTurn));
        System.out.println("YOUR TURN: " + playersHand.get(0) + "        - YOUR TOTAL: " + sumOfHand(valueOfPlayersHand));

        playersHand.add(diceRoll());
        valueOfPlayersHand.add(numberValue(playersHand.get(1), whosTurn));

        System.out.println("YOUR TURN: " + playersHand.get(1) + "        - YOUR TOTAL: " + sumOfHand(valueOfPlayersHand)+"\n");

        //REQ-8: Check if the player has gone bust or has a blackjack
        String outcome = blackjackOrBust(playersHand);
        if (outcome.equals("bust")){
            System.out.println("Sorry but that's a BUST");
        } else if (outcome.equals("blackjack")){
            System.out.println("Your a winner because thats BLACKJACK!!");
        }

        //REQ-9: Player chooses to hold or roll
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to hold your turn or roll the dice again? Please type hold or roll to choose." );
        String playersChoice = scanner.nextLine();
        playersChoice = playersChoice.toLowerCase();
        if (playersChoice.equals("hold")) {

        } else if (playersChoice.equals("roll")) {
            //REQ-10: Player chooses to roll the dice again.
        }







    }
}
