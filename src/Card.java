/**
 * This class will contain one card
 * CardValue 2-10 Jack, Queen, King, Ace
 * Suit Heart, Club, Spade, Diamond
 */
public class Card {
        private String cardValue; //  "2", "10", "Jack", "Ace"
        private String suit; //"Heart", "Club", "Spade", "Diamond"
    
        public Card(String cardValue, String suit) {
            this.cardValue = cardValue;
            this.suit = suit;
        }
    
        public String getCardValue() {
            return cardValue;
        }
    
        public String getSuit() {
            return suit;
        }
    
        @Override
        public String toString() {
            return cardValue + " of " + suit;
        }
    }

