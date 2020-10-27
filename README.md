# blackjack-dice
Simple console based blackjack dice game created for the purpose of ITPR6.598 2020 Assignment 2.

##Establish Methods
* _REQ-:_ Establish the pt values for each number.
       0 = 10pts
       2 - 9 = their number value
       1 = either 1 or 11 players choice - prompt  "You've rolled a 1. Would you like it to be worth 1 or 11?"
            If answer 1 or 11 relevant number choosen and used       
       If dealer roles a 1, it always means 11

Establish what is required to win
    * 1)If the hand exceeds 21 they go bust and the other party wins
    * 2)If the hand equals 21 then they have a blackjack, they win and the round is over
    * 3)If the players hand is under 21 prompt for hold or roll again
    
Establish the rules for dealer's move
    a)If the dealers hand is >= 17 they must hold
    b)If the dealers hand is < 17 they must continue to roll until either they exceed 17 or goes bust
    
    
 ##Start game   
Title of the Application and welcome message is displayed as "Welcome to Blackjack Dice. Please press any key to contine"

*_REQ-:_  Once a key is pressed a number is dealt to the dealer, it's value determined and printed to the screen.

* _REQ-:_ Player has the first turn and is dealt 2 random numbers between 0 and 9. After each roll the random number's value is determined and then the numbers are displayed and summed up and the total sum also displayed

player's sum is checked if it has won or gone bust. Else Preceeds to the next step

*_REQ-:_ Player is prompted to either hold their turn or roll the dice again. "Would you like to hold your turn or roll the dice again? Please type hold or roll to choose."
    Player's input is validated: if hold or choose is chosen (case insenstive) then proceed in game
    if input invalid keep prompting till the correct value is entered.
    
* _REQ-:_ If the player chooses to roll the dice again, again a random number between 0 - 9 is choosen, it's value determined and the number added to the players hand, and the value added to the player's sum. Both of which are then printed to the screen.

Check if the player has won, gone bust or can contine. If they can continue, then the user returns to req _ and they choose again

If the player chooses to hold then their turn ends and it is the dealer's turn
    
* _REQ-:_ check the value of the dealer's card and determine whether to hold or roll

if the dealer rolls a random number between 0 - 9 is choosen, it's value determined and the number added to the dealer's hand, and the value added to the dealer's sum. Both of which are then printed to the screen.

determine whether the dealer must hold or roll - return to req _

if the dealer holds, then the outcome of the game is calculated

* _REQ-:_ 12.At the end of the round the game will display the winner and their score 

Then the user will be prompted either to restart the game or quit

If the user chooses to restart the game then the console is cleared and the game reset to #1

If the user chooses to quit the app will close.
