import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * This class will contain the the playing deck
 * Makes a brand new deck with 52 cards, 13 cards of each suit
 */
public class Deck {


    private List<Card> cards; // The list of cards in the deck

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    // Create a new deck with 52 cards
    private void initializeDeck() {
        String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
        String[] cardValues = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String cardValue : cardValues) {
                cards.add(new Card(cardValue, suit));
            }
        }
    }

    // Shuffle the deck to randomize card order
    public void shuffle() {
        
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    // Draw a card from the deck
    public Card drawCard() {
        if (cards.isEmpty()) {
            // If the deck is empty, you can reshuffle or handle it as needed
            shuffle();
        }
        
        // Remove and return the top card from the deck
        return cards.remove(cards.size() - 1);
    }
}

