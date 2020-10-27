# blackjack-dice
Simple console based blackjack dice game created for the purpose of ITPR6.598 2020 Assignment 2 in the language Java.

##Establish Methods
_REQ-1:_ Establish the pt values for each number in a method called numberValue
       a)0 = 10pts
       b)2 - 9 = pts are their number value
       c)1 = either 1 or 11 players choice. Determine value by prompting player: "You've rolled a 1. Would you like it to be worth 1 or 11?"
              *If answer 1 or 11 relevant number choosen and used
              *If invalid input is entered then the user is prompted again until valid data is inputed
       d)If dealer roles a 1, it always means 11

_REQ-2:_ Establish what is required to win in a method called blackjackOrBust
    * a)If the hand exceeds 21 the player/dealer goes bust and the other party wins
    * b)If the hand equals 21 then they have a blackjack, party with the blackjack wins and the round is over
    
_REQ-3:_ Establish the rules for dealer's move in a method called dealersMove
       a)If the dealers hand is >= 17 they must hold
       b)If the dealers hand is < 17 they must continue to roll until either they exceed 17 or goes bust
       
_REQ-4:_ Create a method called diceRoll that returns a random number between 0 - 9 
     
    
    
##Start game - Game Set-up  
_REQ-5:_Title of the Application and welcome message is displayed as "Welcome to Blackjack Dice. Please press any key to contine"

_REQ-6:_  Once a key is pressed the diceRoll method is called and the number is dealt to the dealer, it's value is determined by running it through the numberValue method. Then the number and it's value is printed to the screen.

_REQ-7.1:_ The player has the first turn and is dealt 2 random numbers by running the diceRoll method twice 
_REQ-7.2:_ After each roll the random number's value is determined by running it through the numberValue method and their values are summed up
_REQ-7.3:_ Then the numbers and the player's total sum is displayed

_REQ-8:_ Check if the player has Won by rolling blackjack or whether the player has gone bust by running the sum through the blackjackOrBust method 
_REQ-8.1:_If the player hasn't gone bust or won proceed to req 9. Otherwise skip to REQ-12.3


###Player's Turn
_REQ-9:_ Player is prompted to either hold their turn or roll the dice again. "Would you like to hold your turn or roll the dice again? Please type hold or roll to choose."
       a) Player's input is validated: if hold or choose is chosen (case insenstive) then proceed in game
       b) If input invalid keep prompting till the correct value is entered.
    
_REQ-10:_ If the player chooses to roll the dice again a random number is choosen by running the diceRoll method, 
_REQ-10.1:_ It's value is determined by running the numberValue method and the number added to the players hand, and the value added to the player's sum. 
_REQ-10.2:_ The player's hand and the sum are then printed to the screen.

_REQ-11:_ Check if the player has won or gone bust by running the blackjackOrBust method.
_REQ-11.1:_ If the player hasn't won or lost the game yet, then the user returns to req 9 and they choose hold or roll again

### Dealer's Turn
_REQ-12:_ If the player chooses to hold then their turn ends and it is the dealer's turn. Recall the value of the dealer's card 
_REQ-12.1:_ Run the dealer's sum through the blackjackOrBust method
       a) If the dealer has a blackjack or has gone bust then skip to REQ 12.3
       b)  _REQ-12.2:_  Else, then run sum through dealersMove method to determine whether the dealer has to hold or roll
                 * If the dealer has to roll, then the diceRoll class is run and the random number added to the dealer's hand.
                 * The number's value is determined and the value added to the dealer's total sum. 
                 * The dealer's hand and sum are then both printed to the screen.
                 
                 ###Outcome of Game
                 * _REQ-12.3:_ If the dealer has to hold then the game has ended and the outcome of the game is calculated.
                            * If the dealer goes bust then the player wins that round
                            * If the player goes bust then the dealer wins that round
                            * If the player and the dealer’s scores tie, then the dealer wins
                            * If the player’s score is higher than the dealer, the player wins
                            * If the dealer’s score is higher than the player, the dealer wins.

_REQ-13:_ At the end of the round the game will display the winner and their score 

_REQ-14:_ Then the user will be prompted either to restart the game or quit.
       * If the user chooses to restart the game then the console is cleared and the game resets to REQ-5
       * Else the user chooses to quit the app will close.
