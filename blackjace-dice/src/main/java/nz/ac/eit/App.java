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
    //REQ-1:  The game must be able to determine what the real point value is for each number.
    public static int numberValue(int numberRolled, String whosTurn){
        int valueOfRolledNumber = numberRolled; //REQ-1.b
        if(numberRolled == 0) {
            valueOfRolledNumber = 10; //REQ-1.a
        } else if (numberRolled == 1) {
            if(whosTurn.equals("player")) {
                    //REQ-1.c
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("You've rolled a 1. Would you like it to be worth 1 or 11?  ");
                    int usersValueChoiceForNum1 = scanner.nextInt(); //needs validation.

                //Assign the amount of points to the variable depending on what the user has typed.
                if (usersValueChoiceForNum1 == 11) {
                    valueOfRolledNumber = 11; //REQ-1.d
                } else if (usersValueChoiceForNum1 == 1){
                    valueOfRolledNumber = 1; //only specify as was having problems
                }
            //Assign the value 11 to the variable if it is the dealer who rolled the dice.
            } else if (whosTurn.equals("dealer")) {
                valueOfRolledNumber = 11;
            }
        }
        return valueOfRolledNumber;
    }

    //REQ-2 & 3: Determine if player/dealer has gone blackjack or bust
    public static String blackjackOrBust(ArrayList<Integer> hand, String whosTurn){
        String outcome = "play on";
        int sumOfHand = sumOfHand(hand);
        if (sumOfHand > 21) {
            outcome = "bust";
        } else if (sumOfHand == 21) {
            outcome = "blackjack";
        }

        if (whosTurn.equals("dealer") && outcome.equals("bust")){
            System.out.println("OUTCOME: Dealer's gone bust, but you're a WINNER!!");
        } else if (whosTurn.equals("dealer") && outcome.equals("blackjack")) {
            System.out.println("OUTCOME: Dealer rolls blackjack. You lose");
        } else if (whosTurn.equals("player") && outcome.equals("bust")) {
            System.out.println("Sorry but that's a BUST");
            System.out.println("Game over man. Game over.");
        } else if (whosTurn.equals("player") && outcome.equals("blackjack")){
            System.out.println("Your a winner because that's BLACKJACK!!");
        }
        //End the program if the player goes blackjack or bust
        if (!(outcome.equals("play on"))) {
            System.exit(0);
        }
        return outcome;
    }
    //REQ-4: Decide how the dealer should play should hold or roll.
    public static String dealersMove (ArrayList<Integer> dealersHand) {
        String outcome = null;
        if(sumOfHand(dealersHand) >= 17) {
            outcome = "hold";
        } else if (sumOfHand(dealersHand) < 17) {
            outcome = "roll";
        }
        return outcome;
    }

    //REQ-5: Simulate the dice roll of a 10 sided dice.
    public static int diceRoll () {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        return randomNumber;
    }

    //REQ-6: sum the playerHand or the dealerHand
    public static int sumOfHand(ArrayList<Integer> hand){
        int sum = 0;
        for (int value : hand) {
            sum += value;
        }
        return sum;
    }

    public static void main( String[] args ) throws NoSuchElementException {
        //////////////////////// Set-up ////////////////////////
        // //Variables needed in game
        String whosTurn = "dealer";
        ArrayList<Integer> dealersHand = new ArrayList<Integer>();
        ArrayList<Integer> valueOfDealersHand = new ArrayList<Integer>();

        ArrayList<Integer> playersHand = new ArrayList<Integer>();
        ArrayList<Integer> valueOfPlayersHand = new ArrayList<Integer>();

        //REQ-7: Welcome Message
        System.out.println("\nWelcome to Blackjack Dice. Lets Start!\n");

        //REQ-8: Deal the Dealer's first dice roll and print hand + total
        //dealersHand.add(diceRoll());
        dealersHand.add(0);
        valueOfDealersHand.add(numberValue(dealersHand.get(0), whosTurn));
        System.out.println("DEALER: " + dealersHand + "        - DEALER'S TOTAL: " + sumOfHand(valueOfDealersHand));
        blackjackOrBust(valueOfDealersHand, whosTurn);

        //REQ-9: Set-up Player's turn. Two dice rolls are dealt to them
        whosTurn = "player";
        System.out.println("_____________________________________________________");

        //First dice roll
        playersHand.add(diceRoll());
        valueOfPlayersHand.add(numberValue(playersHand.get(0), whosTurn));
        System.out.println("YOUR TURN: " + playersHand + "        - YOUR TOTAL: " + sumOfHand(valueOfPlayersHand));

        //Second dice roll
        playersHand.add(diceRoll());
        valueOfPlayersHand.add(numberValue(playersHand.get(1), whosTurn));
        System.out.println("YOUR TURN: " + playersHand + "        - YOUR TOTAL: " + sumOfHand(valueOfPlayersHand)+"\n");

        //////////////////////// Player's Turn ////////////////////////
        //REQ-10a: Check if the player has gone bust or has a blackjack
        String outcome = blackjackOrBust(valueOfPlayersHand, whosTurn);

        //REQ-13: Repeat the player's turn until they either go bust, roll blackjack, or player holds.
        String playersChoice = "undetermined";
        int i = 0;

        do {
            //REQ-10b: Player chooses to hold or roll
            Scanner scanner = new Scanner(System.in);
            System.out.println("Would you like to hold your current hand, or roll the dice again? Please type hold or roll to choose.  ");
            playersChoice = scanner.nextLine(); //.toLowerCase();

            if (playersChoice.equals("roll")) {
                //REQ-11: Player chooses to roll the dice again.
                playersHand.add(diceRoll());
                valueOfPlayersHand.add(numberValue(playersHand.get(i + 2), whosTurn));
                System.out.println("YOUR TURN: " + playersHand + "        - YOUR TOTAL: " + sumOfHand   (valueOfPlayersHand) + "\n");
                i++;
            }
            //REQ-12: Check if player has rolled blackjack or bust
            outcome = blackjackOrBust(valueOfPlayersHand, whosTurn);
        }
        //While the player hasn't rolled a blackjack, hasn't busted and hasn't chosen to hold their    hand, continue the loop.
        while (!(outcome.equals("blackjack")) && !(outcome.equals("bust")) && !(playersChoice.equals("hold")));

        //////////////////////// Dealer's turn ////////////////////////
        whosTurn = "dealer";
        System.out.println("_____________________________________________________");
        //REQ-14:Decide on dealer's move
        String dealersNextMove = "undetermined";
        int g = 0;
        do {
            dealersNextMove = dealersMove(dealersHand);
            if (dealersNextMove.equals("roll")) {
                //REQ-15: Dealer has to roll the dice again.
                dealersHand.add(diceRoll());
                valueOfDealersHand.add(numberValue(dealersHand.get(g + 1), whosTurn));
                System.out.println("DEALER: " + dealersHand + "        - DEALER'S TOTAL: " + sumOfHand(valueOfDealersHand) + "\n");
            }
            //REQ-16a
            outcome = blackjackOrBust(valueOfDealersHand, whosTurn);
            i++;
        }

        //REQ-16b: repeat dealer's turn until dealer reaches blackjack or bust, or must hold.
        while (!(outcome.equals("blackjack")) && !(outcome.equals("bust")) && !(playersChoice.equals("hold")));

        //////////////////////// Check Outcome ////////////////////////
        //REQ-17: Outcome of Game
        System.out.println("_____________________________________________________");
        //REQ-17a
        if (sumOfHand(valueOfDealersHand) == sumOfHand(valueOfPlayersHand)) {
                System.out.println("OUTCOME: You've tied with the dealer. The dealer wins the round.");
            System.out.println("Dealer: " + sumOfHand(valueOfDealersHand) + " |  Your Score: " + sumOfHand(valueOfPlayersHand));

            //REQ-17b
        } else if (sumOfHand(valueOfDealersHand) < sumOfHand(valueOfPlayersHand)) {
            System.out.println("OUTCOME: You beat the dealer. Your a WINNER");
            System.out.println("Dealer: " + sumOfHand(valueOfDealersHand) + " | Your Score: " + sumOfHand(valueOfPlayersHand));

            //REQ-17c
        } else if (sumOfHand(valueOfDealersHand) > sumOfHand(valueOfPlayersHand)) {
            System.out.println("OUTCOME: The dealer wins! Better luck next time.");
            System.out.println("Dealer: " + sumOfHand(valueOfDealersHand) + " | Your Score: " + sumOfHand(valueOfPlayersHand));
        }
    }
}