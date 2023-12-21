import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoliterApp {


        public static void main(String[] args) {
            List<Card> deck = createDeck();
            shuffleDeck(deck);

            List<Card> initialLine = dealInitialLine(deck);

            while (true) {
                List<Card> nextLine = dealNextLine(deck);
                if (nextLine.isEmpty()) {
                    break;
                }

                updateInitialLine(initialLine, nextLine);

            }


            System.out.println("Карты в стопке:");
            for (Card card : initialLine) {
                System.out.println(card.getRank() + " " + card.getSuit());
            }
        }


            private static List<Card> createDeck() {
                List<Card> cards = new ArrayList<>();
                for (Suit suit : Suit.values()) {
                    for (Rank rank : Rank.values()) {
                        cards.add(new Card(rank, suit));
                    }
                }
                return cards;
            }
            private static void shuffleDeck(List<Card> deck) {
                Collections.shuffle(deck);
            }

    private static List<Card> dealInitialLine(List<Card> deck) {
        List<Card> initialLine = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            initialLine.add(deck.remove(0));
        }
        return initialLine;
    }

    private static List<Card> dealNextLine(List<Card> deck) {
        List<Card> nextLine = new ArrayList<>();
        for (int i = 0; i < 5 && !deck.isEmpty(); i++) {
            nextLine.add(deck.remove(0));
        }
        return nextLine;
    }

    private static void updateInitialLine(List<Card> initialLine, List<Card> nextLine) {
        List<Card> newInitialLine = new ArrayList<>();
        List<Card> newNextLine = new ArrayList<>();

        for (int i = 0; i < initialLine.size(); i++) {
            Card initialCard = initialLine.get(i);
            if (!nextLine.isEmpty()) {
                Card nextCard = nextLine.remove(0);

                if (initialCard.getSuit() != nextCard.getSuit()) {
                    newInitialLine.add(initialCard);
                    newNextLine.add(nextCard);
                }
            } else {
                newInitialLine.add(initialCard);
            }
        }

        initialLine.clear();
        initialLine.addAll(newInitialLine);
        nextLine.clear();
        nextLine.addAll(newNextLine);
            }
        }








