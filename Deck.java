import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> listOfCards;

    public Deck() {
        listOfCards = new ArrayList<>();
    }

    public void createCards() {
        for (int i = 0; i < 2; i++) {
            for (Card.Color color : Card.Color.values()) {
                for (int rank = 1; rank < 14; rank++) {
                    listOfCards.add(new Card(rank, color, false));
                }
            }
        }

        shuffle();
    }

    public List<Card> getListOfCards() {
        return listOfCards;
    }

    public void shuffle() {
        Collections.shuffle(listOfCards);
    }

    public void addCardToPile(Card card) {
        listOfCards.add(card);
    }

    public void removeCardFromPile(Card card) {
        listOfCards.remove(card);
    }

    public Card getCard(int i) {
        return listOfCards.get(i);
    }

    public int getSizeOfPile() {
        return listOfCards.size();
    }

    public Card getFirstCard() {
        return getCard(0);
    }

    public Card getLastCard() {
        return getCard(getSizeOfPile() - 1);
    }

    public boolean isCardValid(Card patternCard) {
        return (patternCard.getRank() == getLastCard().getRank()
                || patternCard.getColor().equals(getLastCard().getColor()));
    }

    public void clearPile() {
        listOfCards.clear();
    }

}