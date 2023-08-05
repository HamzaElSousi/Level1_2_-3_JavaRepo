package CardGames;
import java.util.ArrayList;

import Card.Card;
import Card.Deck;
public class WarGame {



    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        // Divide the deck between two players
        int halfDeckSize = deck.getSize() / 2;
        ArrayList<Card> player1Deck = new ArrayList<>(deck.getCards().subList(0, halfDeckSize));
        ArrayList<Card> player2Deck = new ArrayList<>(deck.getCards().subList(halfDeckSize, deck.getSize()));

        int round = 1;
        while (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
            System.out.println("Round " + round);
            Card player1Card = player1Deck.remove(0);
            Card player2Card = player2Deck.remove(0);

            System.out.println("Player 1 plays: " + player1Card.getValue() + " of " + player1Card.getSuit());
            System.out.println("Player 2 plays: " + player2Card.getValue() + " of " + player2Card.getSuit());

            int result = player1Card.getValue().compareTo(player2Card.getValue());
            if (result > 0) {
                System.out.println("Player 1 wins the round!");
                player1Deck.add(player1Card);
                player1Deck.add(player2Card);
            } else if (result < 0) {
                System.out.println("Player 2 wins the round!");
                player2Deck.add(player2Card);
                player2Deck.add(player1Card);
            } else {
                // War!
                System.out.println("It's a tie! WAR!");
                ArrayList<Card> warCards = new ArrayList<>();
                warCards.add(player1Card);
                warCards.add(player2Card);
                performWar(player1Deck, player2Deck, warCards);
            }

            round++;
        }

        // Determine the winner
        if (player1Deck.isEmpty()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("Player 1 wins the game!");
        }
    }

    private static void performWar(ArrayList<Card> player1Deck, ArrayList<Card> player2Deck, ArrayList<Card> warCards) {
        int warSize = 3;

        if (player1Deck.size() < warSize || player2Deck.size() < warSize) {
            // Not enough cards for war, one player loses automatically
            if (player1Deck.size() < warSize) {
                System.out.println("Player 1 doesn't have enough cards for war. Player 2 wins!");
                player2Deck.addAll(warCards);
            } else {
                System.out.println("Player 2 doesn't have enough cards for war. Player 1 wins!");
                player1Deck.addAll(warCards);
            }
            return;
        }

        // Continue with the regular war
        for (int i = 0; i < warSize; i++) {
            warCards.add(player1Deck.remove(0));
            warCards.add(player2Deck.remove(0));
        }

        Card player1WarCard = player1Deck.remove(0);
        Card player2WarCard = player2Deck.remove(0);

        System.out.println("Player 1 plays a war card: " + player1WarCard.getValue() + " of " + player1WarCard.getSuit());
        System.out.println("Player 2 plays a war card: " + player2WarCard.getValue() + " of " + player2WarCard.getSuit());

        int result = player1WarCard.getValue().compareTo(player2WarCard.getValue());
        if (result > 0) {
            System.out.println("Player 1 wins the war!");
            player1Deck.addAll(warCards);
            player1Deck.add(player1WarCard);
            player1Deck.add(player2WarCard);
        } else if (result < 0) {
            System.out.println("Player 2 wins the war!");
            player2Deck.addAll(warCards);
            player2Deck.add(player2WarCard);
            player2Deck.add(player1WarCard);
        } else {
            // Recursive war
            System.out.println("It's a tie again! Another war!");
            performWar(player1Deck, player2Deck, warCards);
        }
    }
}
