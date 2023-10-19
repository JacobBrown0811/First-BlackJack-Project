
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public int calculateTotal() {
        int total = 0;
        int numAces = 0;

        for (Card card : cards) {
            String rank = card.toString().split(" ")[0];
            if (rank.equals("Ace")) {
                numAces++;
                total += 11;
            } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
                total += 10;
            } else {
                total += Integer.parseInt(rank);
            }
        }

        while (total > 21 && numAces > 0) {
            total -= 10;
            numAces--;
        }

        return total;
    }

    public void displayHand() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    public String getVisibleCard() {
        if (!cards.isEmpty()) {
            return cards.get(0).toString();
        }
        return "No visible card";
    }

    public void clear() {
        cards.clear();
    }
}