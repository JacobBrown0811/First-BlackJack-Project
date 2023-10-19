import java.util.Scanner;

public class BlackjackApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Casino");

        // Create a deck of cards
        Deck deck = new Deck();
        deck.shuffle();

        // Create a player with an initial $500
        int playerMoney = 500;
        Player player = new Player();

        // Create a game and pass the deck and player to it
        Game game = new Game(deck, player, playerMoney);

        Scanner scanner = new Scanner(System.in);

        while (playerMoney > 0) {
            playerMoney = game.play();
            if (playerMoney == 0) {
                System.out.println("Out of money. Thanks for playing!");
                break;
            }

            System.out.print("Play another hand? (Yes/No) ");
            String playAgain = scanner.next().toLowerCase();

            if (playAgain.equals("yes")) {
                continue;
            } else if (playAgain.equals("no")) {
                break;
            } else {
                System.out.println("Invalid input.");
            }

            // Check if the player's bet is greater than their remaining money
            if (playerMoney < 5) {
                System.out.println("Invalid input. You don't have enough money to bet.");
                break;
            }
        }

        System.out.println("Thanks for playing!");
    }}