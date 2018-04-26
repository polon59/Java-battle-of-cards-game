import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> listOfCards;

    private static final int FIRST_CARD = 0;

    public Deck() {
        listOfCards = new ArrayList<>();
    }

    public void createCards() {
        
        for (Suit suit : suit.values()) {
            for (Rank rank : Rank.values()) {
                if (suit.getN() % 2 == 1) {
                    listOfCards.add(new Card(rank, suit, Color.RED, false));
                } else {
                    listOfCards.add(new Card(rank, suit, Color.BLACK, false));
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
        return getCard(FIRST_CARD);
    }

    public Card getLastCard() {
        return getCard(getSizeOfPile() - 1);
    }

    public boolean isCardValid(Card patternCard) {
        return (patternCard.getRank().equals(getLastCard().getRank())
                || patternCard.getColor().equals(getLastCard().getColor()));
    }

    public void clearPile() {
        listOfCards.clear();
    }

}