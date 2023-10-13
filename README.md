# Blackjack

Welcome to the Casino. The manager needs a new Blackjack game. So you have been hired to write a program the will handle 1 - 5 players and can bet 5 to 100 dollars. You will start with a shoe of 4 decks and shuffle the decks when you get below 30% left in the shoe you will reshuffle.

The Casino owner want to see a prototype of the application, proof of concept. Using only 1 deck and one player, no beating. Just to make sure that the basic logic of the application works before moving forward with the application.

## The rules are simple...

Once all cards are drawn, whoever has a total closer to 21 than the dealer wins. If player’s hand and dealer’s hand have an equal value, it’s a tie.

All winning bets are paid 1/1 but when you get Blackjack you get paid 3/2.

## Deal phase
1. Each player will recieve two cards
   - if a player draws 21 he wins 3/2
   - if the dealer gets 21 the player lose and play ends
2. The dealers first card face down
3. The player will be able to Hit or Stand
    - if a player Hits the player gets an additonal card
    - if a player Stands the play ends
    - if a player gets 21 or above his play ends (Bust)
4. The dealer continues to draw cards until
   - Dealer gets above 16
   - Dealer gets above 21 (Bust)
5. When all play ends
   - Bust hands lose
   - Hands that do not beat the dealer lose
   - Hands that beat the dealers hand win 1/1
   - Hands that tie with the dealer don't lose or win
6. Play resumes with new deal
7. Prompt Player Prompt Player to play again (Yes/No)
   
Sample Display
```
Your hand is:
Six of Diamonds
Four of Hearts
Your hand is currently worth 10 points.
The dealer's visible card is: Ten of Diamonds
Do you want to Hit or Stand?
```
