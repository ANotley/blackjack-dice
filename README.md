# blackjack-dice
Simple console based blackjack dice game created for the purpose of ITPR6.598 2020 Assignment 2 in the language Java.

## Establish Methods
**REQ-1:** Establish the pt values for each number in a method called numberValue\
       * 0 = 10pts\
       * 2 - 9 = pts are their number value\
       * 1 = either 1 or 11 players choice. Determine value by prompting player: "You've rolled a 1. Would you like it to be worth 1 or 11?"\
       * If dealer roles a 1, it always means 11\

**REQ-2:** Establish what is required to win in a method called blackjackOrBust
    * If the hand exceeds 21 the player/dealer goes bust and the other party wins
    * If the hand equals 21 then they have a blackjack, party with the blackjack wins and the round is over
    
**REQ-3:** Establish the rules for dealer's move in a method called dealersMove
       * If the dealers hand is >= 17 they must hold
       * If the dealers hand is < 17 they must continue to roll until either they exceed 17 or goes bust
       
**REQ-4:** Create a method called diceRoll that returns a random number between 0 - 9 
     
    
    
## Start game - Game Set-up  
**REQ-5:** Title of the Application and welcome message is displayed as "Welcome to Blackjack Dice. Please press any key to contine"

**REQ-6:** Once a key is pressed the diceRoll method is called and the number is dealt to the dealer, it's value is determined by running it through the numberValue method. Then the number and it's value is printed to the screen.

**REQ-7:** The player has the first turn and is dealt 2 random numbers by running the diceRoll method twice 
**REQ-7.1:** After each roll the random number's value is determined by running it through the numberValue method and their values are summed up
**REQ-7.2:** Then the numbers and the player's total sum is displayed

**REQ-8:** Check if the player has Won by rolling blackjack or whether the player has gone bust by running the sum through the blackjackOrBust method 
**REQ-8.1:** If the player hasn't gone bust or won proceed to req 9. Otherwise skip to REQ-12.3


### Player's Turn
**REQ-9:** Player is prompted to either hold their turn or roll the dice again. "Would you like to hold your turn or roll the dice again? Please type hold or roll to choose."
       a) Player's input is validated: if hold or roll is chosen (case insenstive) then proceed in game
       b) If input invalid keep prompting till the correct value is entered.
    
**REQ-10:** If the player chooses to roll the dice again a random number is choosen by running the diceRoll method, 
**REQ-10.1:** It's value is determined by running the numberValue method and the number added to the players hand, and the value added to the player's sum. 
**REQ-10.2:** The player's hand and the sum are then printed to the screen.

**REQ-11:** Check if the player has won or gone bust by running the blackjackOrBust method.
**REQ-11.1:** If the player hasn't won or lost the game yet, then the user returns to req 9 and they choose hold or roll again

### Dealer's Turn
**REQ-12:** If the player chooses to hold then their turn ends and it is the dealer's turn. Recall the value of the dealer's card 
**REQ-12.1:** Run the dealer's sum through the blackjackOrBust method
       * If the dealer has a blackjack or has gone bust then skip to REQ 12.3
       * **REQ-12.2:**  Else, then run sum through dealersMove method to determine whether the dealer has to hold or roll
                 * If the dealer has to roll, then the diceRoll class is run and the random number added to the dealer's hand.
                 * The number's value is determined and the value added to the dealer's total sum. 
                 * The dealer's hand and sum are then both printed to the screen.
                 
### Outcome of Game
**REQ-12.3:** If the dealer has to hold then the game has ended and the outcome of the game is calculated.
       * If the dealer goes bust then the player wins that round
       * If the player goes bust then the dealer wins that round
       * If the player and the dealer’s scores tie, then the dealer wins
       * If the player’s score is higher than the dealer, the player wins
       * If the dealer’s score is higher than the player, the dealer wins.

**REQ-13:** At the end of the round the game will display the winner and their score 
