import java.util.ArrayList;
import java.util.Random;

public class RandomCardDrawer {
    private ArrayList<Card> cardList;

    // Constructor to initialize the cardList with a standard deck
    public RandomCardDrawer() {
        cardList = generateStandardDeck();
    }

    // Method to draw two random cards
    public ArrayList<Card> drawTwoRandomCards() {
        ArrayList<Card> drawnCards = new ArrayList<>();
        drawnCards.add(drawRandomCard(cardList));
        drawnCards.add(drawRandomCard(cardList));
        drawnCards.add(drawRandomCard(cardList));
        drawnCards.add(drawRandomCard(cardList));
        drawnCards.add(drawRandomCard(cardList));
        return drawnCards;

    }

    // Method to generate a standard deck of cards
    private ArrayList<Card> generateStandardDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Populate the deck
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    } 

    // Method to draw a random card from the list
    private Card drawRandomCard(ArrayList<Card> cardList) {
        Random random = new Random();
        int index = random.nextInt(cardList.size());
        return cardList.get(index);
    }
}
