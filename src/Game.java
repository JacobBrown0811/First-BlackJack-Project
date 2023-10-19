import java.util.Scanner;

public class Game {
    private Deck deck;
    private Player player;
    private Player dealer;
    private int playerMoney; // Player's initial money

    public Game(Deck deck, Player player, int playerMoney) {
        this.deck = deck;
        this.player = player;
        this.dealer = new Player();
        this.playerMoney = playerMoney;
    }

    public Game(Deck deck2, Player player2, int playerBet, int playerBet2) {
    }

    public int play() {
        Scanner scanner = new Scanner(System.in);

        while (playerMoney > 0) {
            // Place a bet
            System.out.println("You have $" + playerMoney + ". Enter your bet (between $5 and $100) or 'Q' to quit:");
            if (scanner.hasNextInt()) {
                int playerBet = scanner.nextInt();

                if (playerBet < 5 || playerBet > 100 || playerBet > playerMoney) {
                    System.out.println("Invalid bet amount. Please bet between $5 and $100.");
                    continue;
                }

                // Deal initial cards
                player.addCardToHand(deck.drawCard());
                dealer.addCardToHand(deck.drawCard());
                player.addCardToHand(deck.drawCard());
                dealer.addCardToHand(deck.drawCard());

                // Player's turn
                while (player.calculateHandTotal() < 21) {
                    System.out.println("Your hand is:");
                    player.getHand().displayHand();
                    System.out.println("Your hand is currently worth " + player.calculateHandTotal() + " points.");
                    System.out.println("The dealer's visible card is: " + dealer.getHand().getVisibleCard());

                    System.out.println("Do you want to Hit (H) or Stand (S)?");
                    String choice = scanner.next();

                    if (choice.equalsIgnoreCase("H")) {
                        player.addCardToHand(deck.drawCard());
                    } else if (choice.equalsIgnoreCase("S")) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter 'H' for Hit or 'S' for Stand.");
                    }
                }

                // Dealer's turn
                while (dealer.calculateHandTotal() < 17) {
                    dealer.addCardToHand(deck.drawCard());
                }

                // Determine the winner and handle bets
                int playerTotal = player.calculateHandTotal();
                int dealerTotal = dealer.calculateHandTotal();

                System.out.println("Your hand is:");
                player.getHand().displayHand();
                System.out.println("Your hand is worth " + playerTotal + " points.");
                System.out.println("Dealer's hand is:");
                dealer.getHand().displayHand();
                System.out.println("Dealer's hand is worth " + dealerTotal + " points.");

                int result = determineWinner(playerTotal, dealerTotal);
                updatePlayerMoney(result, playerBet);

                System.out.println(resultMessage(result, playerMoney));
            }

            // Ask if the user wants to play again
            System.out.print("You have $" + playerMoney + " remaining. Play another hand? (Yes/No) ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }

            // Reset hands for the next round
            player.getHand().clear();
            dealer.getHand().clear();
        }

        System.out.println("Out of money. Thanks for playing!");
        scanner.close();
        return playerMoney;
    }

    private int determineWinner(int playerTotal, int dealerTotal) {
        if (playerTotal > 21 || (dealerTotal <= 21 && dealerTotal > playerTotal)) {
            return -1; // Dealer wins
        } else if (dealerTotal > 21 || playerTotal > dealerTotal) {
            return 1; // Player wins
        } else {
            return 0; // It's a tie
        }
    }

    private void updatePlayerMoney(int result, int playerBet) {
        if (result == -1) {
            playerMoney -= playerBet; // Player lost
        } else if (result == 1) {
            playerMoney += playerBet; // Player won
        }
    }

    private String resultMessage(int result, int playerMoney) {
        if (result == -1) {
            return "Dealer wins!";
        } else if (result == 1) {
            return "Player wins!";
        } else {
            return "It's a tie!";
        }
    }
}