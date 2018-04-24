import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> listOfCards;

    private static final int FIRST_CARD = 0;

    public Deck() {
        
        listOfCards = new ArrayList<>();
        for (int suit = 1; suit < 5; suit++) {
            for (int rank = 1; rank < 14; rank++) {
                listOfCards.add(new Card(rank, suit, true));
            }
        }
        shuffle();
    }
    
    public List<Card> getListOfCards(){ 
        return listOfCards;
    }

    public void shuffle() {
        Collections.shuffle(listOfCards);
    }

    public void addCardToPile(Card card) {
        listOfCards.add(card);
    }
    public removeCardFromPile(Card card) {
        listOfCards.remove(card);
    }
    public Card getCard(int i) {
        return listOfCards.get(i);
    }
    public int getSizeOfPile() {
        return listOfCards.size();
    }
    public boolean isCardValid(Card card1, Card card2) {
        if(card1.isSameColor(card2) || card1.isSameRank(card2)) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean checkIfCheated(){
        if (isCardValid()) {
            return false;
        }
        else {
            return true;
        }
    }
}