package Card;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        // Draw and display five cards from the deck
        System.out.println("Drawing 13 cards from the deck:");
        for (int i = 0; i < 13; i++) {
            Card card = deck.drawCard();
            if (card != null) {
                card.showCard();
            } else {
                System.out.println("The deck is empty.");
            }
        }
    }
}
