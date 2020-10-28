# blackjack-dice
Simple console based blackjack dice game created for the purpose of ITPR6.598 2020 Assignment 2 in the language Java.

### Set-up Rules/Methods
* REQ-1: The game must be able to determine what the real point value is for each number. The point values are to be implemented as set out below: \
      a. #0 = 10pts \
      b. For dealer: #1 = 11 pts \
      c. Player can choose if #1 = 1pt or 11pts (input should be validated) \
      d. #2 - #9 = pts are the same as their face value. Eg: #2 = 2pts 

* REQ-2:  The game must be able to determine if the player or dealer has gone bust. If yes, then the game ends and the other player wins. 
(To go bust means their ‘hand’ or accumulative dice rolls exceed the total of 21pts)

* REQ-3:  The game must be able to determine if the player or dealer has ‘rolled a blackjack’.  If yes, then the game ends and the other player loses.
(Blackjack means that they are the first to reach a total of exactly 21pts)

* REQ-4:  The game must be able to decide how the dealer should play by determining whether based on the dealer’s hand if the dealer should hold or roll.
(To ‘hold’ means that the player/dealer is satisfied with their total and want to end their turn. To ‘roll’ means that the player/dealer wants to take their chances and roll the dice again.)\
      a. If the dealer’s hand totals < 17 then the dealer must roll\
      b. f the dealer’s hand totals >= 17 then the dealer must hold

* REQ-5:  The game must be able to ‘roll the dice’ and provide random numbers between 0 and 9 in order to simulate a rolled 10-sided dice.

* REQ-6:  The game must be able to calculate the point totals of the player and dealer.

* REQ-7:  The game should welcome the player to the game

* REQ-8:  The game must then be set-up by ‘dealing’ the first dice roll to the dealer and displaying the dealt number and the total of the dealer’s hand to the screen.

* REQ-9:  To continue set-up the game must then deal the player two dice rolls and print the two numbers and the combined total to the screen.

### Player's Turn
* REQ-10:  Then the player takes the first turn. If player hasn’t busted or rolled a blackjack yet (game should check as per REQ 2 – 3), then the player must be prompted and asked whether they want to hold or roll the dice. (If the players input is invalid then it should be validated)

* REQ-11:  If the player chooses to roll the dice again, then the dice must be rolled again and the new random number dealt to the player. The updated player’s hand and total must now be printed to the screen

* REQ-12:  If the player hasn’t gone bust or rolled blackjack yet (game should check as per REQ 2 – 3),  then the player is asked again whether they want to roll or hold, and req-11 is repeated.

* REQ-13:  REQ-11 and 12 must be repeated sequentially until the player either rolls blackjack, goes bust or chooses to hold. (The game should check blackjack and bust as per REQ 2 – 3),

### Dealer's Turn
* REQ-14:  If the player chooses to hold then it is now the dealer’s turn. The game must then decide what the dealer’s move must be, as outlined in REQ-4.

* EQ-15:  If the dealer must roll, then the game must deal another dice roll to the dealer and then display the updated dealer’s hand and total.

* EQ-16:  The game then checks whether the dealer has now gone bust or rolled blackjack. (game should check as per REQ 2 – 3). If not, then REQ-14 – 15 is repeated until dealer goes blackjack or bust, or must hold.

### Outcome of Game
* EQ-17:  When the dealer must hold, then the game ends and the outcome of the game, and the dealer/player’s scores must be displayed to the screen\
      a. I player and dealer tie, then dealer wins\
      b. f player score > dealer, player wins\
      c. f dealer score> player, dealer wins

