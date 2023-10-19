/**
 * This class will contain a player
 * blackjack player, either the user or the dealer.
 */
public class Player {
    private final Hand hand;

    public Player() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public int calculateHandTotal() {
        return hand.calculateTotal();
    }
}
    
